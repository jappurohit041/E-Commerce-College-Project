package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserDetailBean;
import com.dao.UserDao;
import com.util.UtilValidation;

@WebServlet("/EditAddressServlet")
public class EditAddressServlet extends HttpServlet{
	private static final long serialVersionUID = -4848656872477418349L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isError=false;
		UserDetailBean user = new UserDetailBean();
		user.setUserID(Integer.parseInt(request.getParameter("userID")));
		String houseNumber=request.getParameter("houseNumber");
		String landmark=request.getParameter("landmark");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pinCode=request.getParameter("pinCode");
		String country=request.getParameter("country");
		String phoneNumber=request.getParameter("phoneNumber");
		user.setAddress(houseNumber.trim()+" "+landmark.trim()+" "+city.trim()+" "+state.trim()+" "+country.trim()+" Pincode:- "+pinCode);
		user.setCity(city);
		user.setState(state);
		user.setPinCode(pinCode);
		user.setCountry(country);
		try {
			user.setPhoneNumber(Long.parseLong(phoneNumber));	
		}
		catch(NumberFormatException e) {
			request.setAttribute("phoneNumberError", "Please enter valid phone number");
		}
		if(UtilValidation.valueValidation(houseNumber) || UtilValidation.HouseNoValidaition(houseNumber)) {
			request.setAttribute("houseNumberError", "Please enter valid house number"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(landmark) || UtilValidation.HouseNoValidaition(landmark) ){
			request.setAttribute("landmarkError", "Please enter valid landmark"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(city)  || UtilValidation.nameValidation(city)) {
			request.setAttribute("cityError", "Please enter valid city"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(state)  || UtilValidation.nameValidation(state)) {
			request.setAttribute("stateError", "Please enter valid state"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(pinCode) || UtilValidation.pincodeValidaition(pinCode)) {
			request.setAttribute("pincodeError","Please enter valid pincode"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(country)   || UtilValidation.nameValidation(country)) {
			request.setAttribute("countryError", "Please enter valid country"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(phoneNumber)   || UtilValidation.phoneValidation(phoneNumber) ) {
			request.setAttribute("phoneNumberError", "Please enter valid phone number"); 
			isError=true; 
		}
		if(isError) {
			request.getRequestDispatcher("EditAddress.jsp").forward(request, response);
		}
		else {
			boolean flag = UserDao.updateAddressDetail(user);
			if(flag) {
				user = UserDao.getUserByID(user.getUserID());
				boolean isLogin = true;
				HttpSession session = request.getSession();
				session.setAttribute("mainUser", user);
				session.setAttribute("isLogin", isLogin);
				request.setAttribute("msg", "Updated Succesfully");
			}
			else {
				request.setAttribute("msg", "Error Occured");
			}
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
	}
}

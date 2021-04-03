package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bean.UserDetailBean;
import com.dao.UserDao;
import com.util.SecurityQuestion;
import com.util.UtilValidation;

/**
 * Servlet Filter implementation class SignupValidationfilter
 */
@WebFilter("/SignupValidationfilter")
public class SignupValidationFilter implements Filter 
{
	public void destroy() {
		System.out.println("Filter destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		UserDetailBean user = new UserDetailBean();
		String firstName=request.getParameter("firstName");	
		user.setUserID(UserDao.getCurrentValue()+1);
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("emailAddress");
		String dob=request.getParameter("dateOfBirth");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("cPassword");
		String houseNumber=request.getParameter("houseNumber");
		String landmark=request.getParameter("landmark");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pinCode=request.getParameter("pinCode");
		String country=request.getParameter("country");
		String phoneNumber=request.getParameter("phoneNumber");
		int securityQuestion=Integer.parseInt(request.getParameter("inputSecurityQuestion"));
		String securityAnswer=request.getParameter("securityAnswer");
		boolean isError=false;
		user.setCity(city);
		user.setAddress(houseNumber.trim()+" "+landmark.trim()+" "+city.trim()+" "+state.trim()+" "+country.trim()+" Pincode:- "+pinCode);
		user.setCountry(country);
		user.setIsBlock(0);
		user.setRoleID(1);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailID(email.trim());
		user.setPassWord(confirmPassword);
		request.setAttribute("password", password);
		user.setPinCode(pinCode);
		request.setAttribute("houseNumber", houseNumber);
		System.out.println(dob);
		user.setDateOfBirth(dob.replaceAll("-", ""));
		System.out.println(user.getDateOfBirth());
		user.setState(state);
		request.setAttribute("landMark",landmark);
		if(securityQuestion >= 1 && securityQuestion <= 4) {
			String questionOfUser = SecurityQuestion.questionSet().get(securityQuestion);	
			user.setSecurityQuestion(questionOfUser);
		}
		user.setSecurityAnswer(securityAnswer);
		try {
			user.setPhoneNumber(Long.parseLong(phoneNumber));	
		}
		catch(NumberFormatException e) {
			request.setAttribute("phoneNumberError", "Please enter valid phone number");
		}
		if(UtilValidation.valueValidation(firstName) || UtilValidation.nameValidation(firstName)) {
			request.setAttribute("firstNameError", "Please enter valid name"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(lastName)  || UtilValidation.nameValidation(lastName)) {
			request.setAttribute("lastNameError", "Please enter valid name"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(email) || UtilValidation.emailValidation(email)) {
			request.setAttribute("emailIDError", "Please enter valid email"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(dob)) {
			request.setAttribute("dOB", "Please enter valid DOB");
			 isError=true; 
		}
		if(UtilValidation.valueValidation(password) || UtilValidation.passwordValidation(password)) {
			request.setAttribute("passwordError", "Please enter valid password"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(confirmPassword) || UtilValidation.passwordValidation(confirmPassword) || !(confirmPassword.equals(password))) {
			request.setAttribute("cPasswordError", "Confirm Password not equal to password"); 
			isError=true; 
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
		if(securityQuestion==-1) {
			 request.setAttribute("securityQuestionError", "Please select security question");
			isError=true; 
		}
		if(UtilValidation.valueValidation(securityAnswer)) {
			request.setAttribute("securityAnswerError", "Please write security answer");
			 isError=true; 
		}
		request.setAttribute("user", user);
		if(isError)
		{
			request.getRequestDispatcher("SignupForm.jsp").forward(request, response);
		}	
		else
		{
		chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Signup filter started");
	}
}

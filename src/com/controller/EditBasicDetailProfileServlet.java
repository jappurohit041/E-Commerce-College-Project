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

@WebServlet("/EditBasicDetailProfileServlet")
public class EditBasicDetailProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isError = false;
		UserDetailBean user = new UserDetailBean();
		user.setUserID(Integer.parseInt(request.getParameter("userID")));
		String firstName =request.getParameter("firstName");
		String lastName =request.getParameter("lastName");
		String dob=request.getParameter("dateOfBirth");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("cPassword");
		String emailID = request.getParameter("emailAddress");
		user.setPassWord(confirmPassword);
		user.setEmailID(emailID);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDateOfBirth(dob.replaceAll("-", ""));
		if(UtilValidation.valueValidation(firstName) || UtilValidation.nameValidation(firstName)) {
			request.setAttribute("firstNameError", "Please enter valid name"); 
			isError=true; 
		}
		if(UtilValidation.valueValidation(lastName)  || UtilValidation.nameValidation(lastName)) {
			request.setAttribute("lastNameError", "Please enter valid name"); 
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
		if(isError) {
			request.getRequestDispatcher("EditBasicDetailProfile.jsp").forward(request, response);
		}
		else {
			int flag = UserDao.updateBasicDetail(user);
			if(flag==1) {
				user = UserDao.getUserByID(user.getUserID());
				boolean isLogin = true;
				HttpSession session = request.getSession();
				session.setAttribute("mainUser", user);
				session.setAttribute("isLogin", isLogin);
				request.setAttribute("msg", "Updated Succesfully");
			}
			else if(flag==-1){
				request.setAttribute("passwordError", "Same as old password please change the password");
				request.getRequestDispatcher("EditBasicDetailProfile.jsp").forward(request, response);
				
			}
			else {
				request.setAttribute("msg", "Error Occured");
			}
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
	}
}

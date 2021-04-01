package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserDetailBean;
import com.dao.UserDao;
import com.util.UtilValidation;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailAddress= request.getParameter("emailAddress");
		int count= UserDao.recoverUser(emailAddress);
		if(count==0 || UtilValidation.valueValidation(emailAddress) || UtilValidation.emailValidation(emailAddress)) {
			request.setAttribute("msg", "Invalid EmailID. Please enter valid emailid");
			request.getRequestDispatcher("ForgotPasswordEmail.jsp").forward(request, response);
		}
		else {
			UserDetailBean dummyUser = UserDao.getUserByID(count);
			request.setAttribute("dummyUser", dummyUser);
			request.getRequestDispatcher("ForgotPasswordSecurityQuestion.jsp").forward(request, response);
		}
	}
}

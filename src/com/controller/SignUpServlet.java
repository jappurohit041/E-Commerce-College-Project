package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserDetailBean;
import com.dao.UserDao;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 2126807520234217370L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserDetailBean user = (UserDetailBean)request.getAttribute("user");
		int flag = UserDao.insertUser(user);
		if(flag==1) {
			request.setAttribute("msg", "Successfull Sign Up. Please login to continue");
			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);

		}
		else if(flag==-1) {
			request.setAttribute("emailIDError", "Email ID Already registered");
			request.getRequestDispatcher("SignupForm.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", "Error Occured Please try again");
			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		}
	}
}

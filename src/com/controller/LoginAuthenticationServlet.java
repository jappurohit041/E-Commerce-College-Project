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

@WebServlet("/LoginAuthenticationServlet")
public class LoginAuthenticationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailID");
		String password = request.getParameter("password");
		int userId= UserDao.getUserIDByEmailAndPassword(email,password);
		if(userId!=-1) {
			UserDetailBean user = UserDao.getUserByID(userId);
			if(user.getIsBlock()!=1) {
				boolean isLogin = true;
				HttpSession session = request.getSession();
				session.setAttribute("mainUser", user);
				session.setAttribute("isLogin", isLogin);
				session.setMaxInactiveInterval(300);
				response.sendRedirect("Home.jsp");
			}
			else {
				request.setAttribute("msg", "Your account is block please contact admin");
				request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("msg", "Invalid EmailID or Password");
			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		}
		

	}
}

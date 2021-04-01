package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserDetailBean;
import com.dao.UserDao;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
		UserDetailBean user = UserDao.getUserByID(userID);
		request.setAttribute("user", user);
		request.getRequestDispatcher("AdminEditUser.jsp").forward(request, response);
	}
}

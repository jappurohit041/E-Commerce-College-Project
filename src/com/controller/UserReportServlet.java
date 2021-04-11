package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserDetailBean;
import com.dao.UserDao;

@WebServlet("/UserReportServlet")
public class UserReportServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resposne) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
		ArrayList<UserDetailBean> users = new ArrayList<UserDetailBean>();
		users.add(UserDao.getUserByID(userID));
		users.add(UserDao.getUserByIDForCurrentMonth(userID));
		request.setAttribute("userReport", users);
		request.getRequestDispatcher("UserReports.jsp").forward(request, resposne);
	}
}

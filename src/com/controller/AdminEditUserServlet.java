package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserDetailBean;
import com.dao.UserDao;

@WebServlet("/AdminEditUserServlet")
public class AdminEditUserServlet extends HttpServlet{
	private static final long serialVersionUID = -5034819785615163782L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetailBean user = (UserDetailBean)request.getAttribute("user");
		boolean flag= UserDao.updateUserAdmin(user);
		if(flag) {
			request.setAttribute("msg", "Updated user succesfully");
		}
		else {
			request.setAttribute("msg", "Some error occured");
		}
		request.getRequestDispatcher("UsersDisplay.jsp").forward(request, response);
	}
}

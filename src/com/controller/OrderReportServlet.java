package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDao;

@WebServlet("/OrderReportServlet")
public class OrderReportServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String,Object> map = OrderDao.getOrderReport();
		request.setAttribute("orderReport", map);
		request.getRequestDispatcher("OrderReport.jsp").forward(request, response);
	}
}

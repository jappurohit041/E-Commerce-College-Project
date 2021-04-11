package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/CategoryReportServlet")
public class CategoryReportServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		HashMap<String,Object> map = CategoryDao.getCategoryReport(categoryID);
		map.put("categoryDetailed", CategoryDao.getCategoryDetailed(categoryID));
		System.out.println(map.containsKey("Error"));
		
		request.setAttribute("report", map);
		request.getRequestDispatcher("CategoryReport.jsp").forward(request, response);
	}
}

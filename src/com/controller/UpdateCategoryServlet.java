package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryDetailBean;
import com.dao.CategoryDao;

@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		CategoryDetailBean category = CategoryDao.getCategory(categoryID);
		request.setAttribute("category", category);
		request.getRequestDispatcher("EditCategory.jsp").forward(request, response);
	}
}

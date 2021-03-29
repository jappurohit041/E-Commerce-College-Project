package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryDetailBean;
import com.dao.SubCategoryDao;

@WebServlet("/UpdateSubCategoryServlet")
public class UpdateSubCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subCategoryID = Integer.parseInt(request.getParameter("subCategoryID"));
		SubCategoryDetailBean subCategory = SubCategoryDao.getSubCategory(subCategoryID);
		request.setAttribute("subCategory", subCategory);
		request.getRequestDispatcher("EditSubCategory.jsp").forward(request, response);
	}
}

package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SubCategoryDao;
@WebServlet("/RecoverSubCategoryServlet")
public class RecoverSubCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1343424134608576567L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subCategoryID = Integer.parseInt(request.getParameter("subCategoryID"));
		boolean flag = SubCategoryDao.makeSubCategoryActive(subCategoryID);
		if(flag) {
			request.setAttribute("msg", "Recovered Sub-Category Successfully");
		}
		else {
			request.setAttribute("msg", "Error Occured while Recovering Sub-Category");
		}
		request.getRequestDispatcher("SubCategoryDisplay.jsp").forward(request, response);;
		
	}
}

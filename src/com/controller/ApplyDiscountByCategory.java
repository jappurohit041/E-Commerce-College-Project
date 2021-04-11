package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/ApplyDiscountByCategory")
public class ApplyDiscountByCategory extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float percent = Float.parseFloat(request.getParameter("valueOfDiscount"));
		int categoryID= Integer.parseInt(request.getParameter("categoryID"));
		int flag =0;
		if(percent<0) {
			request.setAttribute("negativeType", "Negative percentage or price to be applied");
			request.getRequestDispatcher("ApplyDiscountByCategory.jsp").forward(request, response);
		}
		else {
			flag = CategoryDao.applyDiscountByCategoryID(categoryID,percent);
		}
		if(flag==-1) {
			request.setAttribute("msg", "Price becoming negative");
		}
		else if(flag==0) {
			request.setAttribute("msg", "Some Error Occured");
		}
		else {
			request.setAttribute("msg", "Successfully Updated Price");
		}
		request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
		
	}
}

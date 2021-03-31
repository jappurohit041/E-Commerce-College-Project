package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;

@WebServlet("/RecoverProductServlet")
public class RecoverProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		boolean flag = ProductDao.makeProductDaoActive(productID);
		if(flag) {
			request.setAttribute("msg", "Recovered Product Successfully");
		}
		else {
			request.setAttribute("msg", "Some Error Occured While Recovering the Product");
		}
		request.getRequestDispatcher("ProductsDisplay.jsp").forward(request, response);
	}
}

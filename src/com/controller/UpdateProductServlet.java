package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductDetailBean;
import com.dao.ProductDao;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		ProductDetailBean product = ProductDao.getProductByID(productID);
		request.setAttribute("product", product);
		request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
	}
}

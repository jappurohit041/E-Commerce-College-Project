package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductDetailBean;
import com.dao.ProductDao;

@WebServlet("/SearchProductByName")
public class SearchProductByName extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		ArrayList<ProductDetailBean> product = ProductDao.getProductByName(productName);
		request.setAttribute("productDetails", product);
		request.getRequestDispatcher("SearchedProduct.jsp").forward(request, response);
	}
}

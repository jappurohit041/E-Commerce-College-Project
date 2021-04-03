package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductDetailBean;
import com.dao.ProductDao;

@WebServlet("/DetailProductServlet")
public class DetailProductServlet extends HttpServlet{
	private static final long serialVersionUID = -7072819760966170848L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		ProductDetailBean p = ProductDao.getProductByID(productID);
		request.setAttribute("detailProduct", p);
		request.getRequestDispatcher("ProductDescription.jsp").forward(request, response);
	}
}

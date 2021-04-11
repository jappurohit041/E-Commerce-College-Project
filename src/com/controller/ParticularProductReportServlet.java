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

@WebServlet("/ParticularProductReportServlet")
public class ParticularProductReportServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resposne) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		ArrayList<ProductDetailBean> product = new ArrayList<ProductDetailBean>();
		product.add(ProductDao.getTopSellingProductByProductID(productID));
		product.add(ProductDao.getTopSellingProductByProductIDForMonth(productID));
		request.setAttribute("productReport", product);
		request.getRequestDispatcher("ParticularProductReport.jsp").forward(request, resposne);
	}
}

package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductDetailBean;
import com.dao.CartDao;
import com.dao.ProductDao;

@WebServlet("/ChangeQuantityServlet")
public class ChangeQuantityServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag =0;
		String operation = request.getParameter("operation");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		if(operation.equals("minus") && quantity-1>0) {
			int productID = Integer.parseInt(request.getParameter("productID"));
			int userID = Integer.parseInt(request.getParameter("userID"));
			ProductDetailBean product = ProductDao.getProductByID(productID);
			flag = CartDao.decreaseQuantity(productID,userID,product.getOfferPrice());
		}
		if(operation.equals("plus")) {
			int productID = Integer.parseInt(request.getParameter("productID"));
			int userID = Integer.parseInt(request.getParameter("userID"));
			ProductDetailBean product = ProductDao.getProductByID(productID);
			flag = CartDao.updateQuantity(productID,userID,product.getOfferPrice());
		}
		if(flag == -1) {
			request.setAttribute("msg", "We aren't available with that much amount of quantity.");
		}
		request.getRequestDispatcher("CartDisplay.jsp").forward(request, response);
	}
}

package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CartDao;

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartID = Integer.parseInt(request.getParameter("cartID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		boolean flag = CartDao.deleteFromCart(cartID, userID);
		if(flag) {
			request.setAttribute("msg", "Delete Product Succesfully from cart");
		}
		else {
			request.setAttribute("msg", "Some error occured");
		}
		request.getRequestDispatcher("CartDisplay.jsp").forward(request, response);
	}
}

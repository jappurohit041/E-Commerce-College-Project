package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CartDetailBean;
import com.dao.CartDao;

@WebServlet("/BuyNowCartServlet")
public class BuyNowCartServlet extends HttpServlet{
	private static final long serialVersionUID = 2853719846013030602L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartID,userID;
		ArrayList<CartDetailBean> list = new ArrayList<CartDetailBean>();
		
		boolean fullCart=Boolean.parseBoolean(request.getParameter("fullCart"));
		if(request.getParameter("cartID").equals("")) {
			cartID=0;
		}
		else {
			cartID=Integer.parseInt(request.getParameter("cartID"));
			request.setAttribute("cartID", cartID);
		}
		if(request.getParameter("userID").equals("")) {
			userID=0;
		}
		else {
			userID=Integer.parseInt(request.getParameter("userID"));
			request.setAttribute("userID", userID);
		}
		if(fullCart) {
			list= CartDao.getListOfCart(userID);
		}
		else {
			list = CartDao.getListOfCartByCartID(cartID,userID);
		}
		request.setAttribute("fullCart", fullCart);
		request.setAttribute("cartList", list);
		request.getRequestDispatcher("PlaceOrder.jsp").forward(request, response);
	}
}

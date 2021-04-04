package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CartDetailBean;
import com.bean.ProductDetailBean;
import com.dao.CartDao;
import com.dao.ProductDao;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet{
	private static final long serialVersionUID = 1042996639914896307L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		int userID = Integer.parseInt(request.getParameter("userID"));
		System.out.println(productID+"User ID: "+userID);
		ProductDetailBean product = ProductDao.getProductByID(productID);
		CartDetailBean cart = new CartDetailBean();
		boolean typeCase  = CartDao.toCheckIfProductExistOrNot(productID,userID);
		int flag=0;
		if(typeCase) {
			flag = CartDao.updateQuantity(productID,userID,product.getOfferPrice());
		}
		else {
			cart.setCartID(CartDao.getCurrentValue()+1);
			cart.setUserID(userID);
			cart.setProductID(productID);
			cart.setQuantity(1);
			cart.setPrice(product.getOfferPrice()*1);
			flag = CartDao.insertCart(cart);
		}
		
		if(flag==1) {
			request.setAttribute("msg", "Product Added in the Cart");
		}
		else {
			request.setAttribute("msg", "Some Error Occured");
		}
		request.getRequestDispatcher("CartDisplay.jsp").forward(request, response);
	}
}

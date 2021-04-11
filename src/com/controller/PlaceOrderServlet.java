package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CartDetailBean;
import com.bean.OrderDetailBean;
import com.bean.OrderDetailedBean;
import com.bean.UserDetailBean;
import com.dao.CartDao;
import com.dao.OrderDao;
import com.dao.OrderDetailedDao;
import com.dao.UserDao;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean fullCart = Boolean.parseBoolean(request.getParameter("fullCart"));
		boolean flag=false;
		float finalAmount = Float.parseFloat(request.getParameter("finalAmount"));
		int userID= Integer.parseInt(request.getParameter("userID"));
		int cartID=-1;
		try{
			cartID= Integer.parseInt(request.getParameter("cartID"));
		}
		catch(Exception e) {
		}
		int paymentMode= Integer.parseInt(request.getParameter("paymentMode"));
		System.out.println("Payment mode "+paymentMode);
		System.out.println("Boolean Full Cart"+fullCart);
		System.out.println("Cart ID "+cartID);
		System.out.println("User ID"+userID);
		
		if(fullCart) {
			UserDetailBean user = UserDao.getUserByID(userID);
			OrderDetailBean orderDetail = new OrderDetailBean();
			ArrayList<CartDetailBean> cart = CartDao.getListOfCart(userID);
			orderDetail.setOrderID(OrderDao.getCurrentValue()+1);
			orderDetail.setUserID(user.getUserID());
			orderDetail.setAddress(user.getAddress());
			orderDetail.setPaymentType(paymentMode);
			orderDetail.setTotalAmount(finalAmount);
			orderDetail.setDeliveryStatus(0);
			float finalAmountForOrder =0;
			float discountAmount = 0;
			int flag1=-2;
			for(CartDetailBean c : cart) {
				finalAmountForOrder =finalAmountForOrder+c.getPrice();
				discountAmount = discountAmount+(c.getOrignalPrice()-c.getOfferPrice())*c.getQuantity();
			}
			orderDetail.setFinalAmount(finalAmountForOrder);
			orderDetail.setDiscountAmount(discountAmount);
			OrderDao.insertRecord(orderDetail);
			finalAmountForOrder=0;
			discountAmount=0;
			finalAmount=0;
			int sFlag=0;
			int counter=0;
			for(CartDetailBean c: cart) {
				OrderDetailedBean order = new OrderDetailedBean();
				order.setOrderID(orderDetail.getOrderID());
				order.setUserID(user.getUserID());
				order.setProductID(c.getProductID());
				order.setPrice(c.getOfferPrice());
				order.setQuntity(c.getQuantity());
				order.setOrignalPrice(c.getOrignalPrice());
				order.setTotalAmount(c.getOfferPrice()*c.getQuantity());
				flag1 = OrderDetailedDao.insertRecord(order);
				if(flag1==-1) {
					finalAmountForOrder=finalAmountForOrder+c.getPrice();
					discountAmount = discountAmount+(c.getOrignalPrice()-c.getOfferPrice())*c.getQuantity();
					finalAmount=finalAmount+((c.getOfferPrice()*0.18f)+c.getOfferPrice())*c.getQuantity();
					sFlag=1;
					counter++;
				}
				else if(flag1==0) {
					flag=true;
					request.setAttribute("msg", "Some error occured please try again!!");
				}
			}
			if(sFlag==1) {
				flag=true;
				finalAmountForOrder = orderDetail.getFinalAmount()-finalAmountForOrder; 
				finalAmount = orderDetail.getTotalAmount()-finalAmount;
				discountAmount = orderDetail.getDiscountAmount()-discountAmount;
				if(counter==cart.size()) {
					OrderDao.removeOrder(orderDetail.getOrderID());
					request.setAttribute("msg", "All products went out of stock");
				}
				else {
					OrderDao.updateRecord(finalAmountForOrder,finalAmount,discountAmount,orderDetail.getOrderID());	
					request.setAttribute("msg", "Sorry you have been late. Some product went out of stock. Please Try by decreasing the quantity.");
					
				}
			}
		}
		else {
			UserDetailBean user = UserDao.getUserByID(userID);
			OrderDetailedBean order = new OrderDetailedBean();
			OrderDetailBean orderDetail = new OrderDetailBean();
			CartDetailBean cart = CartDao.getListOfCartByCartIDAndUserID(cartID, userID);
			//orderDetails 
			orderDetail.setOrderID(OrderDao.getCurrentValue()+1);
			orderDetail.setUserID(user.getUserID());
			orderDetail.setAddress(user.getAddress());
			orderDetail.setPaymentType(paymentMode);
			orderDetail.setFinalAmount(cart.getPrice());
			orderDetail.setTotalAmount(finalAmount);
			orderDetail.setDiscountAmount((cart.getOrignalPrice()-cart.getOfferPrice())*cart.getQuantity());
			orderDetail.setDeliveryStatus(0);
			OrderDao.insertRecord(orderDetail);
			//orderDetailed Query
			System.out.println(orderDetail.getOrderID());
			order.setOrderID(orderDetail.getOrderID());
			order.setUserID(user.getUserID());
			order.setProductID(cart.getProductID());
			order.setPrice(cart.getOfferPrice());
			order.setQuntity(cart.getQuantity());
			order.setOrignalPrice(cart.getOrignalPrice());
			order.setTotalAmount(cart.getOfferPrice()*cart.getQuantity());
			int flag1 = OrderDetailedDao.insertRecord(order);
			if(flag1==-1) {
				flag=true;
				request.setAttribute("msg", "Sorry you have been late. Product is might out of stock. Please Try by decreasing the quantity.");
				OrderDao.removeOrder(orderDetail.getOrderID());
			}
			else if(flag1==0) {
				flag=true;
				request.setAttribute("msg", "Some error occured please try again!!");
			}
		}
		if(flag) {
			request.getRequestDispatcher("CartDisplay.jsp").forward(request, response);	
		}
		else {
			request.setAttribute("msg", "Order Placed Sucessfully. Thank you for shopping. Please do visit again. Hurray!!!");
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		
	}
}

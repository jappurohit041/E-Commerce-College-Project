package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;

@WebServlet("/ApplyDiscountByProduct")
public class ApplyDiscountByProduct extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float percent = Float.parseFloat(request.getParameter("valueOfDiscount"));
		int discountType= Integer.parseInt(request.getParameter("discountType"));
		int productID= Integer.parseInt(request.getParameter("productID"));
		String offerTill=request.getParameter("offerTill").replaceAll("-", "");
		System.out.println("offerTill : "+offerTill);
		if(percent<0) {
			request.setAttribute("negativeType", "Negative percentage or price to be applied");
			request.getRequestDispatcher("ApplyDiscountByProduct.jsp").forward(request, response);
		}
		int flag=0;
		if(discountType==1) {
			//by price
			flag = ProductDao.applyDiscountByPrice(productID,percent,offerTill);
		}
		else {
			//by percentage
			flag = ProductDao.applyDiscountByPercent(productID,percent,offerTill);
		}
		if(flag==-1) {
			request.setAttribute("msg", "Price becoming negative");
		}
		else if(flag==0) {
			request.setAttribute("msg", "Some Error Occured");
		}
		else {
			request.setAttribute("msg", "Successfully Updated Price");
		}
		request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
	}
}

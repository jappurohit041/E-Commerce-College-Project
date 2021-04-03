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

@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryID = request.getParameter("categoryID");
		String subCategoryID = request.getParameter("subCategoryID");
		System.out.println("categoryID : "+categoryID);
		System.out.println("subCategoryID : "+subCategoryID);
		System.out.println(subCategoryID==null);
		System.out.println(categoryID==null);
		ArrayList<ProductDetailBean> product;
		if(subCategoryID.equals("")) {
			System.out.println("Category wise products");
			product = ProductDao.getProductByCategory(Integer.parseInt(categoryID));
		}
		else {
			System.out.println("Category and subcategorywise products");
			product = ProductDao.getProductByCategoryAndSubCategory(Integer.parseInt(categoryID),Integer.parseInt(subCategoryID));
		}
		request.setAttribute("productDetails", product);
		request.getRequestDispatcher("SearchedProduct.jsp").forward(request, response);
		
	}
}

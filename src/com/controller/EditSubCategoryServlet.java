package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryDetailBean;
import com.dao.SubCategoryDao;

@WebServlet("/EditSubCategoryServlet")
public class EditSubCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subCategoryName = request.getParameter("subCategoryName");
		int subCategoryID = Integer.parseInt(request.getParameter("subCategoryID"));
		int inputCategoryID = Integer.parseInt(request.getParameter("inputCategory"));
		int subCategoryStatus = Integer.parseInt(request.getParameter("inputSubCategoryStatus"));
		
		SubCategoryDetailBean subCategory = new SubCategoryDetailBean();
		
		subCategory.setCategoryID(inputCategoryID);
		subCategory.setIsActive(subCategoryStatus);
		subCategory.setSubCategoryID(subCategoryID);
		subCategory.setSubCategoryName(subCategoryName);
		
		boolean isError = false;
		if(subCategoryName == null || subCategoryName.trim().length()==0) {
			isError = true;
			request.setAttribute("subCategoryNameError", "Please enter valid Sub-Category");
		}
		if(inputCategoryID == -1) {
			isError = true;
			request.setAttribute("categoryError", "Please select valid Category name");
		}
		if(subCategoryStatus == -1) {
			isError = true;
			request.setAttribute("subCategoryStatus", "Please select Sub-Category Active status");
		}
		if(isError) {
			request.setAttribute("subCategory",subCategory);
			request.getRequestDispatcher("EditSubCategory.jsp").forward(request, response);
		}
		else {
			boolean flag = SubCategoryDao.updateSubCategory(subCategory);
			if(flag)
			{	request.setAttribute("msg", "Sub Category Updated Successfully");}
			else
			{	request.setAttribute("msg", "Error occured while adding Sub Category");	}			
			request.getRequestDispatcher("SubCategoryDisplay.jsp").forward(request, response);
		}
	}
}

package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryDetailBean;
import com.bean.SubCategoryDetailBean;
import com.dao.CategoryDao;
import com.dao.SubCategoryDao;
import com.google.gson.Gson;

@WebServlet("/GetCategoryAndSubCategory")
public class GetCategoryAndSubCategory extends HttpServlet{
	private static final long serialVersionUID = 2349731047617040398L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()){
			String op = request.getParameter("operation");
			if(op.equals("category")) {
				List<CategoryDetailBean> clist = CategoryDao.getAllCategory();
				Gson json = new Gson();
				String categoryList = json.toJson(clist);
				response.setContentType("text/html");
				response.getWriter().write(categoryList);
			}	
			if(op.equals("subCategory")) {
				int id = Integer.parseInt(request.getParameter("id"));
				List<SubCategoryDetailBean> slist = SubCategoryDao.getSubCategoryByID(id);
				Gson json = new Gson();
				String categoryList = json.toJson(slist);
				response.setContentType("text/html");
				response.getWriter().write(categoryList);
			}
		}
		
	}
}

package com.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1343424134608576567L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		boolean flag = CategoryDao.makeCategoryDeActive(categoryID);
		if(flag) {
			request.setAttribute("msg", "Deleted Category Successfully");
		}
		else {
			request.setAttribute("msg", "Error Occured while Deleting Category");
		}
		request.getRequestDispatcher("CategoryDisplay.jsp").forward(request, response);;
		
	}
}

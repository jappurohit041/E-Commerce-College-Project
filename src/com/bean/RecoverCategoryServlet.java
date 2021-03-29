package com.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/RecoverCategoryServlet")
public class RecoverCategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1343424134608576567L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		boolean flag = CategoryDao.makeCategoryActive(categoryID);
		if(flag) {
			request.setAttribute("msg", "Recovered Category Successfully");
		}
		else {
			request.setAttribute("msg", "Error Occured while Recovering Category");
		}
		request.getRequestDispatcher("CategoryDisplay.jsp").forward(request, response);;
		
	}
}

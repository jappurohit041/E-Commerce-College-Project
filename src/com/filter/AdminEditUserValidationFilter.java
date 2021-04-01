package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bean.UserDetailBean;

/**
 * Servlet Filter implementation class SignupValidationfilter
 */
@WebFilter("/AdminEditUserValidationFilter")
public class AdminEditUserValidationFilter implements Filter 
{
	public void destroy() {
		System.out.println("Filter destroyed");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		UserDetailBean user = new UserDetailBean();
		System.out.println(request.getParameter("userID"));
		user.setUserID(Integer.parseInt(request.getParameter("userID")));
		user.setRoleID(Integer.parseInt(request.getParameter("roleID")));
		user.setIsBlock(Integer.parseInt(request.getParameter("isBlock")));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmailID(request.getParameter("emailID"));
		
		System.out.println("first name"+user.getFirstName());
		System.out.println("user id"+user.getUserID());
		System.out.println("Is Block "+user.getIsBlock());
		System.out.println("ROle Id "+user.getRoleID());
		request.setAttribute("user", user);
		boolean isError=false;
		if(request.getParameter("roleID").equals("-1")) {
			isError=true;
			request.setAttribute("roleIDError", "Please select role id");
		}
		if(request.getParameter("isBlock").equals("-1")) {
			isError=true;
			request.setAttribute("isBlockError", "Please select block status");
		}

		if(isError)
		{
			request.getRequestDispatcher("AdminEditUser.jsp").forward(request, response);
		}	
		else
		{
		chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Admin Edit filter started");
	}
}

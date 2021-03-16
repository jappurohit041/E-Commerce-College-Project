

package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.util.UtilValidation;

/**
 * Servlet Filter implementation class SignupValidationfilter
 */
@WebFilter("/SignupValidationfilter")
public class SignupValidationfilter implements Filter 
{
    public SignupValidationfilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		String firstName=request.getParameter("firstName");										
		String Lastname=request.getParameter("lastName");
		String email=request.getParameter("emailAddress");
		String dob=request.getParameter("dateOfBirth");
		String password=request.getParameter("password");
		String Confirmpassword=request.getParameter("cPassword");
		String HouseNumber=request.getParameter("houseNumber");
		String Landmark=request.getParameter("Landmark");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pincode=request.getParameter("pincode");
		String country=request.getParameter("country");
		String phoneNumber=request.getParameter("phoneNumber");
		String securityQuestion=request.getParameter("securityQuestion");
		String secrityAnswer=request.getParameter("securityAnswer");
		
		if(UtilValidation.firstNameValidation(firstName)) {
			System.out.println("True");
		}
		
		else
		{
		chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}

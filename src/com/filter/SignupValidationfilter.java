

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
		
		String Firstname=request.getParameter("firstName");										
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
		
		boolean isError=false;
		if(Firstname==null || Firstname.trim().length()==0)
		{
			isError=true;
		}
		if(Lastname==null || Lastname.trim().length()==0)
		{
			isError=true;
		}if(email==null || email.trim().length()==0)
		{
			isError=true;
		}if(dob==null || dob.trim().length()==0)
		{
			isError=true;
		}if(password==null || password.trim().length()==0)
		{
			isError=true;
		}if(Confirmpassword==null || Confirmpassword.trim().length()==0)
		{
			isError=true;
		}if(HouseNumber==null || HouseNumber.trim().length()==0)
		{
			isError=true;
		}if(Landmark==null || Landmark.trim().length()==0)
		{
			isError=true;
		}if(city==null || city.trim().length()==0)
		{
			isError=true;
		}if(state==null || state.trim().length()==0)
		{
			isError=true;
		}if(pincode==null || pincode.trim().length()==0)
		{
			isError=true;
		}if(country==null || country.trim().length()==0)
		{
			isError=true;
		}if(phoneNumber==null || phoneNumber.trim().length()==0)
		{
			isError=true;
		}if(securityQuestion.equals("-1") )
		{
			isError=true;
		}if(secrityAnswer==null || secrityAnswer.trim().length()==0)
		{
			isError=true;
		}
		
		
		if(isError==true)
		{
			request.getRequestDispatcher("").forward(request, response);
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

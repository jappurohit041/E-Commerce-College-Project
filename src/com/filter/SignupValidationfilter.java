

package com.filter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("emailAddress");
		String dob=request.getParameter("dateOfBirth");
//		--------------
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
		if(UtilValidation.valueValidation(firstName) && UtilValidation.nameValidation(firstName)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(lastName)  && UtilValidation.nameValidation(lastName)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(email) && UtilValidation.emailValidation(email)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(dob)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(password) && UtilValidation.passwordValidation(password)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(Confirmpassword) && UtilValidation.passwordValidation(Confirmpassword) && Confirmpassword.equals(password)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(HouseNumber) && UtilValidation.HouseNoValidaition(HouseNumber)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(Landmark) && UtilValidation.nameValidation(Landmark) ){
			 isError=false; 
		}
		if(UtilValidation.valueValidation(city)  && UtilValidation.nameValidation(city))) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(state)  && UtilValidation.nameValidation(state)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(pincode) && UtilValidation.pincodeValidaition(pincode)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(country)   && UtilValidation.nameValidation(country)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(phoneNumber)   && UtilValidation.phoneValidation(phoneNumber) ) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(securityQuestion)) {
			 isError=false; 
		}
		if(UtilValidation.valueValidation(secrityAnswer)) {
			 isError=false; 
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

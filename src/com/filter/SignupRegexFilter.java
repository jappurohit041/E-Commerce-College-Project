package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/SignupRegexFilter")
public class SignupRegexFilter implements Filter {

    public SignupRegexFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		String Firstname=request.getParameter("firstName");						
		String Lastname=request.getParameter("lastName");						// 	start wwith capital
		String email=request.getParameter("emailAddress");						// email validation
		String dob=request.getParameter("dateOfBirth");							//   dd/mm/yyyy
		String password=request.getParameter("password");						// should be more than 8 and should have specific characters
		String Confirmpassword=request.getParameter("cPassword");				// same as password
		String pincode=request.getParameter("pincode");			////// 6 digit number
		String phoneNumber=request.getParameter("phoneNumber"); 		/////////////// 10 digit number 
	
		String regexFirstName="^\\b([A-Z][-,a-z. ']+[ ]*)+$";
		String regexLastName="^\\b([A-Z][-,a-z. ']+[ ]*)+$";
		String regexemail="^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		String regexdob="(?:\\d{1,2}[-/\\s]\\d{1,2}[-/\\s]'?\\d{2,4})|(?:\\d{2,4}[-/\\s]\\d{1,2}[-/\\s]\\d{1,2})|(?:(?:January|February|March|April|May|June|July|August|September|October|November|December|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec)[\\s-/,]*?\\d{1,2}(?:\\s)*(?:rd|th|st)?(?:\\s)*[-/,]?(?:\\s)*'?\\d{2,4})|(?:\\d{1,2}(?:\\s)*(?:rd|th|st)?(?:\\s)*(?:January|February|March|April|May|June|July|August|September|October|November|December|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec)(?:\\s)*?[-/,]?(?:\\s)*'?\\d{2,4})";
		String regexpassword="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}[]:;<>,.?/~_+-=|\\]).{8,32}$";
		/*				PASSWORD REGEX
			 *  At least one digit [0-9]	
				At least one lowercase character [a-z]
				At least one uppercase character [A-Z]
				At least one special character [*.!@#$%^&(){}[]:;<>,.?/~_+-=|\]
				At least 8 characters in length, but no more than 32.
		 * 
		 * */
		String regexPincode="^[1-9]{1}[0-9]{2}\\\\s{0, 1}[0-9]{3}$";
		String regexphone="\\d{10}";
	
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}

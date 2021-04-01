package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserDetailBean;
import com.dao.UserDao;
import com.util.UtilValidation;

@WebServlet("/ForgotPasswordLoginServlet")
public class ForgotPasswordLoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDetailBean user = UserDao.getUserByID(Integer.parseInt(request.getParameter("userID")));
		String answer = request.getParameter("securityAnswer");
		boolean isError = false;
		if(UtilValidation.valueValidation(answer)) {
			request.setAttribute("answerError", "Please enter valid answer");
			isError=true;
		}
		else if(!user.getSecurityAnswer().equals(answer)) {
			request.setAttribute("answerError", "Your answer is wrong");
			isError=true;
		}
		else if(user.getSecurityAnswer().equals(answer) &&  user.getIsBlock()!=0) {
			request.setAttribute("answerError", "Your account is blocked please contact");	
			isError=true;
		}
		
		else if(isError==false && user.getSecurityAnswer().equals(answer) && user.getIsBlock()==0) {
			boolean isLogin = true;
			HttpSession session = request.getSession();
			session.setAttribute("mainUser", user);
			session.setAttribute("isLogin", isLogin);
			session.setMaxInactiveInterval(300);
			response.sendRedirect("Home.jsp");
		}
		if(isError) {
			request.setAttribute("dummyUser", user);
			request.getRequestDispatcher("ForgotPasswordSecurityQuestion.jsp").forward(request, response);
		}
	}
}

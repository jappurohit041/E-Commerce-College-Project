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
import com.util.SecurityQuestion;
import com.util.UtilValidation;

@WebServlet("/EditSecurityServlet")
public class EditSecurityServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isError=false;
		UserDetailBean user = new UserDetailBean();
		user.setUserID((Integer.parseInt(request.getParameter("userID"))));
		String securityAnswer=request.getParameter("securityAnswer");
		int securityQuestion=Integer.parseInt(request.getParameter("inputSecurityQuestion"));
		if(securityQuestion >= 1 && securityQuestion <= 4) {
			String questionOfUser = SecurityQuestion.questionSet().get(securityQuestion);	
			user.setSecurityQuestion(questionOfUser);
		}
		user.setSecurityAnswer(securityAnswer);
		if(securityQuestion==-1) {
			 request.setAttribute("securityQuestionError", "Please select security question");
			isError=true; 
		}
		if(UtilValidation.valueValidation(securityAnswer)) {
			request.setAttribute("securityAnswerError", "Please write security answer");
			 isError=true; 
		}
		if(isError) {
			request.getRequestDispatcher("SecurityEdit.jsp").forward(request, response);
		}
		else {
			boolean flag = UserDao.updateSecurityDetail(user);
			if(flag) {
				user = UserDao.getUserByID(user.getUserID());
				boolean isLogin = true;
				HttpSession session = request.getSession();
				session.setAttribute("mainUser", user);
				session.setAttribute("isLogin", isLogin);
				request.setAttribute("msg", "Updated Succesfully");
			}
			else {
				request.setAttribute("msg", "Error Occured");
			}
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
	}
}

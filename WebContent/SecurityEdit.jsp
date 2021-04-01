<%@page import="java.util.HashMap"%>
<%@page import="com.util.SecurityQuestion"%>
<%@page import="com.bean.UserDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="script.js"></script>
<title>Security Edit</title>
</head>
<body>
<%	
try{
	UserDetailBean mainUser=null;
	if(session == null || session.getAttribute("isLogin") == null){
		request.setAttribute("msg","Your session expired or you are not logined");		
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
	else{
		mainUser = (UserDetailBean)session.getAttribute("mainUser");	
	}
%>
		<form id="msform" action="EditSecurityServlet" method="post">
		<fieldset>
			<h2 class="fs-title">Security Questions</h2>
			<div class="row">
			<input type="hidden" value="${mainUser.getUserID() }" name="userID">
				<div class="col">
					<label for="inputSecurityQuestion">Please Select Your
						Security Question</label> <select class="form-control" id="questions"
						name="inputSecurityQuestion" onchange="getdata()">
						<%HashMap<Integer, String> questions = SecurityQuestion.questionSet();  %>
						<option value="-1">Please select security questions ?</option>
						 <%for (Integer i: questions.keySet()) {%>
			 			<option value="<%=i%>" > <%=questions.get(i) %> </option>
					<%} %>
					</select> <label class="error">${securityQuestionError}</label>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label for="inputSecurityAnswer">Please Answer Your
						Security Question</label> <input type="text"
						value="${mainUser.getSecurityAnswer()}" class="form-control"
						placeholder="Security Answer" id="inputSecurityAnswer"
						name="securityAnswer" /> <label class="error">${securityAnswerError}</label>
				</div>
			</div>
			<input type="submit" name="submit"
				class="btn btn-success success action-button" value="Submit" />
		</fieldset>
		</form>
<%}catch(Exception e){
		request.setAttribute("msg", "Please login again your session timed out");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
}	%>
</body>
</html>
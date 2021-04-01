<%@page import="com.dao.UserDao"%>
<%@page import="com.bean.UserDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<title>Basic Detail Edit Form</title>
<style>
.error {
	font-size: 20px;
	color: red;
}
</style>
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
		<form id="msform" action="EditBasicDetailProfileServlet" method="post">
		<fieldset>
			<h2 class="fs-title">Basic Details</h2>
			<div class="row">
				<div class="col-6">
				<input type="hidden" value="${mainUser.getUserID() }" name="userID">
					<label for="inputFirstName">First Name</label> <input type="text"
						value="${mainUser.getFirstName()}" class="form-control"
						placeholder="First Name" id="inputFirstName" name="firstName">
					<label class="error">${firstNameError}</label>
				</div>
				<div class="col-6">
					<label for="inputLastName">Last Name</label> <input type="text"
						value="${mainUser.getLastName()}" class="form-control"
						placeholder="Last Name" name="lastName"> <label
						class="error">${lastNameError}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputEmailAddress">Email Address</label> 
					<input
						type="hidden" value="${mainUser.getEmailID()}" class="form-control"
						placeholder="Email Address" id="inputEmailAddress"
						name="emailAddress" /> <label class="error">${emailIDError}</label>
					<p style="border: 2px solid black;">${mainUser.getEmailID() }</p>
				</div>
				<div class="col-6">
					<label for="inputDOB">Date of Birth</label> <input type="date"
						value="${mainUser.getDateOfBirth()}" class="form-control"
						placeholder="" id="inputDOB" name="dateOfBirth" /> <label
						class="error">${dOB}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputPassword">Password</label> <input type="password"
						 class="form-control" placeholder="Password"
						id="password" name="password"> <label class="error">${passwordError}</label>
				</div>
				<div class="col-6">
					<label for="inputCPassword">Confirm Password</label> <input
						type="password" class="form-control"
						placeholder="Confirm Password" id="inputCPassword"
						name="cPassword"> <label class="error">${cPasswordError}</label>
				</div>
			</div>
			<a href="Home.jsp" style="float: left">Home Page</a> <br> <input type="submit" name="submit"
				class="btn btn-success success action-button" value="Submit" />
		</fieldset>
		</form>
<%}catch(Exception e){
		request.setAttribute("msg", "Please login again your session timed out");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
}	%>

</body>
</html>
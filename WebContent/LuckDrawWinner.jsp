<%@page import="com.bean.UserDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Lucky Draw Winner</title>
</head>
<body>
<%try{ 
UserDetailBean mainUser=null;
if(session == null || session.getAttribute("isLogin") == null){
		request.setAttribute("msg","Your session expired or you are not logined");		
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
else{
	mainUser =(UserDetailBean) session.getAttribute("mainUser");
	if(mainUser.getRoleID()!=1){
		request.setAttribute("msg","You don't have access in this area");		
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
}
%>
	<%UserDetailBean luckyUser = (UserDetailBean)request.getAttribute("luckyUser");%>
	<form id="msform" action="LuckyDrawEmailServlet" method="post">
		<fieldset>
		
			<h2 class="fs-title">Basic Details</h2>
			<div class="row">
				<div class="col-6">
					<label for="inputFirstName">First Name</label> <input type="text"
						value="<%=luckyUser.getFirstName()%>" class="form-control"
						placeholder="First Name" id="inputFirstName" name="firstName" disabled>
				</div>
				<div class="col-6">
					<label for="inputLastName">Last Name</label> <input type="text"
						value="<%=luckyUser.getLastName()%>" class="form-control"
						placeholder="Last Name" name="lastName" disabled> 
				</div>
			</div>
			<div class="row">
					<div class="col-12">
					<label for="inputAddress">Address</label> <input
						type="text" value="<%=luckyUser.getAddress()%>" class="form-control"
						placeholder="Email Address" id="inputEmailAddress"
						name="emailAddress" disabled />
				</div>
			
			
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputEmailAddress">Email Address</label> <input
						type="hidden" value="${luckyUser.getEmailID()}" class="form-control"
						placeholder="Email Address" id="inputEmailAddress"
						name="emailAddress" />
					<p style="border: 2px solid black;">${luckyUser.getEmailID() }</p>
				</div>
				<div class="col-6">
					<label for="inputDOB">Date of Birth</label> <input type="date"
						value="<%=luckyUser.getDateOfBirth() %>" class="form-control" disabled/> 
				</div>
			</div>
			<a href="AdminDashboard.jsp" style="float: left">Admin Dashboard</a> <br> <input
				type="submit" name="submit" class="btn btn-success success action-button" value="Send Email" />
		</fieldset>
	</form>
	<%}catch(Exception e){request.setAttribute("msg","You are not logined Please login");
	request.getRequestDispatcher("LoginForm.jsp").forward(request,response);} %>

</body>
</html>
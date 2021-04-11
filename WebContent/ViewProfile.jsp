<%@page import="com.bean.UserDetailBean"%>
<%@page import="com.util.SecurityQuestion"%>
<%@page import="java.util.HashMap"%>
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
<title>Sign Up Form | Edit Form</title>
<style>
.error {
	font-size: 20px;
	color: red;
}
</style>
</head>

<body>
	<%	
try{UserDetailBean mainUser=null;
if(session == null || session.getAttribute("isLogin") == null){
		request.setAttribute("msg","Your session expired or you are not logined");		
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
else{
	mainUser =(UserDetailBean) session.getAttribute("mainUser");
	if(mainUser.getRoleID()!=1){
		request.setAttribute("msg","Your don't have access to this");		
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
}

%>
	<!-- multistep form -->
	<form id="msform" action="SignUpServlet" method="post">
		<!-- progressbar -->
		<ul id="progressbar">
			<li class="active">Basic Details</li>
			<li>Address Details</li>
			<li>Security Questions</li>
		</ul>
		<!-- fieldsets -->
		<fieldset>
			<h2 class="fs-title">Basic Details</h2>
			<div class="row">
				<div class="col-6">
					<label for="inputFirstName">First Name</label> <input type="text"
						value="${mainUser.getFirstName()}" class="form-control"
						placeholder="First Name" id="inputFirstName" name="firstName" disabled>
				</div>
				<div class="col-6">
					<label for="inputLastName">Last Name</label> <input type="text"
						value="${mainUser.getLastName()}" class="form-control"
						placeholder="Last Name" name="lastName" disabled> 
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputEmailAddress">Email Address</label> <input
						type="text" value="${mainUser.getEmailID()}" class="form-control"
						placeholder="Email Address" id="inputEmailAddress"
						name="emailAddress" disabled />
				</div>
				<div class="col-6">
					<label for="inputDOB">Date of Birth</label> <input type="date"
						value="${mainUser.getDateOfBirth()}" class="form-control"
						placeholder="" id="inputDOB" name="dateOfBirth" disabled/> 
				</div>
			</div>
			<a href="Home.jsp" style="float: left">Home Page</a> <br> <input
				type="button" name="next" class="next action-button" value="Next" />
		</fieldset>
		<fieldset>
			<h2 class="fs-title">Address Details</h2>
			<div class="row">
				<div class="col">
					<label for="address">Full Address</label> <input
						type="text" value="${mainUser.getAddress()}" class="form-control"
						placeholder="Street Number/ House Number" id="address"
						name="houseNumber" disabled/> 
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputPincode">Pincode</label> <input type="text"
						value="${mainUser.getPinCode()}" class="form-control"
						placeholder="Pincode" id="inputPincode" name="pinCode" disabled/> 
				</div>
				<div class="col-6">
					<label for="inputCity">City</label> <input type="text"
						value="${mainUser.getCity()}" class="form-control" placeholder="City"
						id="city" name="city" disabled/>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputState">State</label> <input type="text"
						value="${mainUser.getState()}" class="form-control"
						placeholder="State" id="inputState" name="state" disabled/> 
				</div>
					<div class="col-6">
					<label for="inputCountry">Country</label> <input type="text"
						value="${mainUser.getCountry()}" class="form-control"
						placeholder="Country" id="inputCountry" name="country" disabled/> 
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<label for="inputPhoneNumber">Phone Number</label> <input
						type="text" value="${mainUser.getPhoneNumber()}" class="form-control"
						placeholder="Phone Number" id="inputPhoneNumber"
						name="phoneNumber" disabled/> 
				</div>
			</div>
				<a href="Home.jsp" style="float: left">Home Page</a> <br> 
			<input type="button" name="previous" class="previous action-button"
				value="Previous" /> <input type="button" name="next"
				class="next action-button" value="Next" />
		</fieldset>
		<fieldset>
			<h2 class="fs-title">Security Questions</h2>
			<div class="row">
				<div class="col">
					<label for="inputSecurityQuestion">Please Select Your
						Security Question</label> 
						<select class="form-control" id="questions"
						name="inputSecurityQuestion" onchange="getdata()" disabled>
						<option value="-1">${mainUser.getSecurityQuestion()}</option>
					</select>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label for="inputSecurityAnswer">Please Answer Your
						Security Question</label> <input type="text"
						value="${mainUser.getSecurityAnswer()}" class="form-control"
						placeholder="Security Answer" id="inputSecurityAnswer"
						name="securityAnswer" disabled/>
				</div>
			</div>
				<a href="Home.jsp" style="float: left">Home Page</a> <br> 
			<input type="button" name="previous" class="previous action-button"
				value="Previous" />
		</fieldset>
	</form>
		<%}catch(Exception e){
		request.setAttribute("msg","You are not logined Please login");
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
%>
</body>
</html>

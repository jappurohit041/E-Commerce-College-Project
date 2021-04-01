<%@page import="com.bean.UserDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Detail Edit Form</title>
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
</head>
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
		<form id="msform" action="EditAddressServlet" method="post">
	<fieldset>
			<input type="hidden" value="${mainUser.getUserID()}" name="userID">
			<h2 class="fs-title">Address Details</h2>
			<div class="row">
				<div class="col">
					<label for="address">Street Number/ House Number</label> <input
						type="text" value="${houseNumber}" class="form-control"
						placeholder="Street Number/ House Number" id="address"
						name="houseNumber" /> <label class="error">${houseNumberError}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputLandmark">Landmark</label> <input type="text"
						value="${landMark}" class="form-control" placeholder="Landmark"
						id="inputLandmark" name="landmark"> <label class="error">${landmarkError}</label>

				</div>
				<div class="col-6">
					<label for="inputCity">City</label> <input type="text"
						value="${mainUser.getCity()}" class="form-control" placeholder="City"
						id="city" name="city"> <label class="error">${cityError}</label>

				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputState">State</label> <input type="text"
						value="${mainUser.getState()}" class="form-control"
						placeholder="State" id="inputState" name="state"> <label
						class="error">${stateError}</label>
				</div>
				<div class="col-6">
					<label for="inputPincode">Pincode</label> <input type="text"
						value="${mainUser.getPinCode()}" class="form-control"
						placeholder="Pincode" id="inputPincode" name="pinCode"> <label
						class="error">${pincodeError}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputCountry">Country</label> <input type="text"
						value="${mainUser.getCountry()}" class="form-control"
						placeholder="Country" id="inputCountry" name="country"> <label
						class="error">${countryError}</label>
				</div>
				<div class="col-6">
					<label for="inputPhoneNumber">Phone Number</label> <input
						type="text" value="${mainUser.getPhoneNumber()}" class="form-control"
						placeholder="Phone Number" id="inputPhoneNumber"
						name="phoneNumber"> <label class="error">${phoneNumberError}</label>
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
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
<title>Admin Edit User</title>
<style>
.error {
	font-size: 20px;
	color: red;
}
</style>
</head>

<body>
	<!-- multistep form -->
	<form id="msform" action="AdminEditUserServlet" method="post">

		<fieldset>
			<h2 class="fs-title">Role and IsBlock Status</h2>
			<input type="hidden" value="${user.getUserID()}" name="userID">
			<input type="hidden" value="${user.getFirstName()}" name="firstName">
			<input type="hidden" value="${user.getLastName()}" name="lastName">
			<input type="hidden" value="${user.getEmailID()}" name="emailID">
			
			<div class="row">
				<div class="col">
				 <p style="font-weight: bold;">User-Name : ${user.getFirstName()} ${user.getLastName()}<br>  &nbsp;&nbsp;Email-ID : ${user.getEmailID()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="roleID">Please select your Role ID</label>
					<select class="form-control" name="roleID">
						<option value="-1">Please select role-ID</option>
						<option value="1">Admin</option>
						<option value="2">User</option>
					</select>
					<label class="error">${roleIDError}</label>
				</div>
				<div class="col-6">
					<label for="roleID">Please Block Status</label>
					<select class="form-control" name="isBlock">
						<option value="-1">Is User Block?</option>
						<option value="1">Yes</option>
						<option value="0">No</option>
					</select>
					<label class="error">${isBlockError}</label>
				</div>
			</div>

			<br>
		<input type="submit" name="submit"
				class="btn btn-success success action-button" value="Submit" />
		</fieldset>
	</form>
</body>
</html>

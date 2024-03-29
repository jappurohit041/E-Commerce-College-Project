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
<title>Login Form</title>
</head>

<body>
	<!-- multistep form -->
	<form id="msform" action="LoginAuthenticationServlet" method="post">
	
		<!-- fieldsets -->
		<fieldset>
			<h2 class="fs-title">Login Form</h2>
			<div class="row">
				<div class="col">
					<label for="inputEmailID">Email ID</label> <input type="text"
						class="form-control" placeholder="Email ID" id="inputEmailID"
						name="emailID">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label for="inputPassword">Password</label> <input type="password"
						class="form-control" placeholder="Password" name="password">
				</div>
			</div>
			<label class="error">${msg}</label>
			<a href="ForgotPasswordEmail.jsp" style="float: left">Forget
				Password&nbsp;</a>
			 <a
				href="SignupForm.jsp" style="float: right">New User</a> <br /> <input
				type="submit" name="next" class="next action-button" value="Submit" />

		</fieldset>
	</form>

</body>

</html>

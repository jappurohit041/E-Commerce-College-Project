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
<title>Security Questions</title>
</head>

<body>
	<!-- multistep form -->
	<form id="msform" action="ForgotPasswordLoginServlet" method="post">
		<!-- progressbar -->
		<ul id="progressbar" style="text-align: center; margin-left: 450px">
			<li>Enter Email</li>
			<li class="active">Security Question</li>
		</ul>
		<fieldset>
			<h2 class="fs-title">Security Questions</h2>
			<div class="row">
				<div class="col">
				<input type="hidden" value="${dummyUser.getUserID()}" name="userID">
					<label for="inputSecurityQuestion">Please Select Your
						Security Question</label> <select class="form-control" id="questions"
						name="inputSecurityQuestion" onchange="getdata()" disabled>
						<option value="-1">${dummyUser.getSecurityQuestion() }</option>
					</select>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col">
					<label for="inputSecurityAnswer">Please Answer Your
						Security Question</label> <input type="text" class="form-control"
						placeholder="Security Answer" id="inputSecurityAnswer"
						name="securityAnswer" />
						<label class="error">${answerError}</label>
				</div>
			</div>
			<a href="LoginForm.jsp" style="float: left">Login&nbsp;</a><br>
				<input type="submit" name="next"
				class="action-button" value="Submit" />
		</fieldset>
	</form>
</body>
</html>

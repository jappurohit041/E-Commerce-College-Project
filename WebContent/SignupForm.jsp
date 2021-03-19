<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="script.js"></script>
    <title>Sign Up Form</title>
    <style>
    	.error{
    	font-size: 20px;
    	color: red;
    	}
    </style>
</head>

<body>
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
                    <label for="inputFirstName">First Name</label>
                    <input type="text" value="${user.getFirstName()}" class="form-control" placeholder="First Name" id="inputFirstName" name="firstName">
                	<label class="error">${firstNameError}</label>
                </div>
                <div class="col-6">
                    <label for="inputLastName">Last Name</label>
                    <input type="text" value="${user.getLastName()}" class="form-control" placeholder="Last Name" name="lastName">
                	<label class="error">${lastNameError}</label>
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputEmailAddress">Email Address</label>
                    <input type="text" value="${user.getEmailID()}" class="form-control" placeholder="Email Address" id="inputEmailAddress" name="emailAddress" />
                	<label class="error">${emailIDError}</label>
                </div>
                <div class="col-6">
                    <label for="inputDOB">Date of Birth</label>
                    <input type="date" value="${user.getDateOfBirth()}" class="form-control" placeholder="" id="inputDOB" name="dateOfBirth"/>
                	<label class="error">${dOB}</label>
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputPassword">Password</label>
                    <input type="password" value="${password}" class="form-control" placeholder="Password" id="password" name="password">
                	<label class="error">${passwordError}</label>
                </div>
                <div class="col-6">
                    <label for="inputCPassword">Confirm Password</label>
                    <input type="password" value="${user.getPassWord()}" class="form-control" placeholder="Confirm Password" id="inputCPassword" name="cPassword">
                	<label class="error">${cPasswordError}</label>
                </div>
            </div>
            <a href="LoginForm.jsp" style="float : left">Already Existing User&nbsp;</a>
            <div class="verticalLine" style="border-right: solid #000000; float:left">&nbsp;&nbsp;</div>
			<a style="float: left; text-decoration:none ;cursor: default">&nbsp;&nbsp;&nbsp;</a>
			<a href="Home.jsp" style="float: left">Home Page</a>
            <br>
            <input type="button" name="next" class="next action-button" value="Next" />
        </fieldset>
        <fieldset>
            <h2 class="fs-title">Address Details</h2>
            <div class="row">
                <div class="col">
                    <label for="address">Street Number/ House Number</label>
                    <input type="text" value="${houseNumber}" class="form-control" placeholder="Street Number/ House Number" id="address" name="houseNumber" />
                	<label class="error">${houseNumberError}</label>
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputLandmark">Landmark</label>
                    <input type="text" value="${landMark}" class="form-control" placeholder="Landmark" id="inputLandmark" name="landmark">
                	<label class="error">${landmarkError}</label>
                
                </div>
                <div class="col-6">
                    <label for="inputCity">City</label>
                    <input type="text" value="${user.getCity()}" class="form-control" placeholder="City" id="city" name="city">
                	<label class="error">${cityError}</label>
                
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputState">State</label>
                    <input type="text" value="${user.getState()}" class="form-control" placeholder="State" id="inputState" name="state">
                	<label class="error">${stateError}</label>
                </div>
                <div class="col-6">
                    <label for="inputPincode">Pincode</label>
                    <input type="text" value="${user.getPinCode()}" class="form-control" placeholder="Pincode" id="inputPincode" name="pinCode">
                	<label class="error">${pincodeError}</label>
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputCountry">Country</label>
                    <input type="text" value="${user.getCountry()}" class="form-control" placeholder="Country" id="inputCountry" name="country">
                	<label class="error">${countryError}</label>
                </div>
                <div class="col-6">
                    <label for="inputPhoneNumber">Phone Number</label>
                    <input type="text" value="${user.getPhoneNumber()}" class="form-control" placeholder="Phone Number" id="inputPhoneNumber" name="phoneNumber">
                	<label class="error">${phoneNumberError}</label>
                </div>
            </div>
            <input type="button" name="previous" class="previous action-button" value="Previous" />
            <input type="button" name="next" class="next action-button" value="Next" />
        </fieldset>
        <fieldset>
            <h2 class="fs-title">Security Questions</h2>
            <div class="row"> 
                <div class="col">
                    <label for="inputSecurityQuestion">Please Select Your Security Question</label>
                    <select class="form-control" id="questions" name="inputSecurityQuestion" onchange="getdata()">
                        <option value="-1">Please select security questions ?</option>
                        <option value="1">What is your favourite food dish ?</option>
                        <option value="2">Who is your favourite player ?</option>
                        <option value="3">What is name of your pet ?</option>
                        <option value="4">What is name of your childhood friend ?</option>
                        <option value="5">What is your school name ?</option>
                    </select>
                	<label class="error">${securityQuestionError}</label>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col">
                    <label for="inputSecurityAnswer">Please Answer Your Security Question</label>
                    <input type="text" value="${user.getSecurityAnswer()}"class="form-control" placeholder="Security Answer" id="inputSecurityAnswer" name="securityAnswer" />
                	<label class="error">${securityAnswerError}</label>
                </div>
            </div>
            <input type="button" name="previous" class="previous action-button" value="Previous" />
            <input type="submit" name="submit" class="btn btn-success success action-button" value="Submit" />
        </fieldset>
     </form>
</body>
</html>

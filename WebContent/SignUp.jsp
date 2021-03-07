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
</head>

<body>
		<!-- multistep form -->
    <form id="msform" action="#">
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
                    <input type="text" class="form-control" placeholder="First Name" id="inputFirstName" name="firstName">
                </div>
                <div class="col-6">
                    <label for="inputLastName">Last Name</label>
                    <input type="text" class="form-control" placeholder="Last Name" name="lastName">
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputEmailAddress">Email Address</label>
                    <input type="text" class="form-control" placeholder="Email Address" id="inputEmailAddress" name="emailAddress" />
                </div>
                <div class="col-6">
                    <label for="inputDOB">Date of Birth</label>
                    <input type="date" class="form-control" placeholder="" id="inputDOB" name="dateOfBirth" />
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputPassword">Password</label>
                    <input type="text" class="form-control" placeholder="Password" id="password" name="password">
                </div>
                <div class="col-6">
                    <label for="inputCPassword">Confirm Password</label>
                    <input type="text" class="form-control" placeholder="Confirm Password" id="inputCPassword" name="cPassword">
                </div>
            </div>
            <input type="button" name="next" class="next action-button" value="Next" />
        </fieldset>
        <fieldset>
            <h2 class="fs-title">Address Details</h2>
            <div class="row">
                <div class="col">
                    <label for="address">Street Number/ House Number</label>
                    <input type="text" class="form-control" placeholder="Street Number/ House Number" id="address" name="houseNumber" />
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputLandmark">Landmark</label>
                    <input type="text" class="form-control" placeholder="Landmark" id="inputLandmark" name="landmark">
                </div>
                <div class="col-6">
                    <label for="inputCity">City</label>
                    <input type="text" class="form-control" placeholder="City" id="city" name="city">
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputState">State</label>
                    <input type="text" class="form-control" placeholder="State" id="inputState" name="state">
                </div>
                <div class="col-6">
                    <label for="inputPincode">Pincode</label>
                    <input type="text" class="form-control" placeholder="Pincode" id="inputPincode" name="pincode">
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputCountry">Country</label>
                    <input type="text" class="form-control" placeholder="Country" id="inputCountry" name="country">
                </div>
                <div class="col-6">
                    <label for="inputPhoneNumber">Phone Number</label>
                    <input type="text" class="form-control" placeholder="Phone Number" id="inputPhoneNumber" name="phoneNumber">
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
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col">
                    <label for="inputSecurityAnswer">Please Answer Your Security Question</label>
                    <input type="text" class="form-control" placeholder="Security Answer" id="inputSecurityAnswer" name="securityAnswer" />
                </div>
            </div>
            <input type="button" name="previous" class="previous action-button" value="Previous" />
            <input type="submit" name="submit" class="submit action-button" value="Submit" />
        </fieldset>
    </form>

</body>

</html>

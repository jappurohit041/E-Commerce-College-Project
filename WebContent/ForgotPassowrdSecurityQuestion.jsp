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
    <form id="msform" action="#" method="post">
        <!-- progressbar -->
        <ul id="progressbar" style="text-align: center; margin-left: 450px">
            <li></li>
            <li class="active">Security Question</li>
          <!--    <li>Security Questions</li>-->
        </ul>
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
            <input type="submit" name="submit" class="submit action-button" value="Submit" />
        </fieldset>
    </form>
</body>
</html>

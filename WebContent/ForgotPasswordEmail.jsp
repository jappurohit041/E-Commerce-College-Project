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
        <ul id="progressbar" style="text-align: center; margin-left:450px">
            <li class="active">Enter Email</li>
            <li></li>
        </ul>
        <!-- fieldsets -->
        <fieldset>
            <h2 class="fs-title">Basic Details</h2>
                    <label for="inputEmailAddress" style="flex: content;">Email Address</label>
                    <input type="text" class="form-control" placeholder="Email Address" id="inputEmailAddress" name="emailAddress" />
            <input type="submit" name="next" class="action-button" value="Next" />
        </fieldset>
    </form>
</body>
</html>
<!-- next  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CategoryType</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<style>
body {
	background-color: black;
}

.categoryImg {
	text-align: center;
}

.DropdownRadiusLeft {
	border-radius: 0%;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-2 categoryImg">
				<img
					src="https://rukminim1.flixcart.com/flap/128/128/image/29327f40e9c4d26b.png?q=100"
					height="55px" width="55px">
				<!-- <p>Grocery</p> -->
				<!-- Example split danger button -->
				<br>
				<div class="btn-group">
					<button type="button"
						class="btn btn-light dropdown-toggle dropdown-toggle-split DropdownRadiusLeft"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<button type="button" class="btn btn-light text-dark">Grocery</button>
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">

						<a class="dropdown-item" href="#">Staples</a> <a
							class="dropdown-item" href="#">Snacks & Beverages</a> <a
							class="dropdown-item" href="#">Packaged Food</a>
						<!-- <div class="dropdown-divider"></div> -->
						<a class="dropdown-item" href="#">Personal & Baby Care</a> <a
							class="dropdown-item" href="#">Household Care</a> <a
							class="dropdown-item" href="#">Daiery & Eggs</a>
					</div>
				</div>
			</div>
			<div class="col-2 categoryImg">

				<img
					src="https://rukminim1.flixcart.com/flap/128/128/image/69c6589653afdb9a.png?q=100"
					height="55px" width="55px">
				<!-- <p>Electronics</p> -->
				<br>
				<div class="btn-group">
					<button type="button"
						class="btn dropdown-toggle dropdown-toggle-split btn-light DropdownRadiusLeft"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<button type="button" class="btn btn-light text-dark">Electronics</button>
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Separated link</a>
					</div>
				</div>
			</div>
			<div class="col-2 categoryImg">

				<img
					src="https://rukminim1.flixcart.com/flap/128/128/image/82b3ca5fb2301045.png?q=100 "
					height="55px" width="55px">
				<!-- <p>Fashion</p> -->
				<br>
				<div class="btn-group">
					<button type="button"
						class="btn dropdown-toggle dropdown-toggle-split btn-light DropdownRadiusLeft"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<button type="button" class="btn btn-light text-dark">Fashion</button>
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Staples</a> <a
							class="dropdown-item" href="#">Snacks & Beverages</a> <a
							class="dropdown-item" href="#">Packaged Food</a>
						<!-- <div class="dropdown-divider"></div> -->
						<a class="dropdown-item" href="#">Personal & Baby Care</a> <a
							class="dropdown-item" href="#">Household Care</a> <a
							class="dropdown-item" href="#">Daiery & Eggs</a>
					</div>
				</div>
			</div>
			<div class="col-2 categoryImg">

				<img
					src="https://rukminim1.flixcart.com/flap/128/128/image/ee162bad964c46ae.png?q=100"
					height="55px" width="55px">
				<!-- <p>Home</p> -->
				<br>
				<div class="btn-group">
					<button type="button"
						class="btn btn-light dropdown-toggle dropdown-toggle-split DropdownRadiusLeft"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<button type="button" class="btn btn-light text-dark">Home</button>
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Separated link</a>
					</div>
				</div>
			</div>
			<div class="col-2 categoryImg">

				<img src="images	\beauty-removebg-preview.png"
					style="margin-top: 4px;" height="50px" width="50px">
				<!-- <p>Beauty</p> -->
				<br>
				<div class="btn-group">
					<button type="button"
						class="btn  btn-light dropdown-toggle dropdown-toggle-split DropdownRadiusLeft"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<button type="button" class="btn btn-light text-dark ">Beauty</button>
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Separated link</a>
					</div>
				</div>
			</div>
			<div class="col-2 categoryImg">

				<img src="images\toycar-removebg-preview.png"
					style="margin-top: 4px;" height="50px" width="50px">
				<!-- <p>Toys</p> -->
				<br>
				<div class="btn-group">
					<button type="button"
						class="btn btn-light dropdown-toggle dropdown-toggle-split DropdownRadiusLeft"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<button type="button" class="btn btn-light text-dark ">Toys</button>
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Separated link</a>11
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
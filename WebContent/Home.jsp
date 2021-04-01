<%@page import="com.bean.UserDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"><link href="fontawesome/css/font-awesome.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
<title>Home Page</title>
<style>
.LoginButton {
	border: solid 1px White;
	background-color: WHITE;
	text-transform: uppercase;
	text-decoration: none;
	text-align: center;
	padding-top: 3PX;
	padding-bottom: 3PX;
	margin-top: 10px;
	color: black;
}

.HeaderIcons {
	margin-top: 10px;
	margin-left: 8px;
	text-align: right;
	color: white;
	font-size: 25px;
}

.HeaderIconsLabel {
	color: white;
	text-transform: uppercase;
	margin-right: 10px;
}

.HeaderIconsLabel:hover, .HeaderIcons:hover {
	color: rgb(212, 212, 253);
}

.searchForm {
	margin-top: 10px;
	text-align: right;
}

.searchHover {
	color: blue;
	background-color: white;
	font-weight: bold;
	margin-left: -6px;
	padding-top: 3px;
	padding-right: 10px;
	padding-bottom: 4px;
}

.searchHover:hover {
	border: snow solid 0.5px;
	padding: 5px;
	color: white;
}
/* Dropdown Button */
.dropbtn {
	
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: absolute;
	left: -60PX;
	top: 25PX;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.btn, .btn-secondary {
	background-color: transparent;
	color: white;
	border: transparent;
}

.btn:hover, .btn-secondary:hover {
	background-color: transparent;
	border: transparent;
	color: white;
}
/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #ddd;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

.footerHeader {
	font-size: medium;
	text-transform: uppercase;
	color: grey;
	margin-bottom: 5px;
}

.footerBackground {
	font-size: small;
	padding: 20px;
	text-align: center;
	background-color: rgb(39, 28, 56);
	color: cornsilk;
}

.vlLeft {
	border-left: 1px solid white;
	height: fit-content;
}
</style>
</head>
<body>
<%	
UserDetailBean user=null;
if(session == null || session.getAttribute("isLogin") == null){
		request.setAttribute("msg","Your session expired or you are not logined");		
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
else{
	user =(UserDetailBean) session.getAttribute("user");	
}

%>

	<header class="container-fluid "
		style="background: linear-gradient(#8aaed1, white);">
		<div class="row">
			<div class="col-1">
				<a href="Home.jsp"><img src="images/BigDealWhiteLogo.jpg"
					alt="White BigDeal Main Logo">
			</div>
			<div class="col-6">
				<form class="searchForm">
					<input type="text" placeholder="Search for ProductsName and More"
						style="width: 270px;"> <a href="#" class="searchHover"><i
						class="fa fa-search"></i></a>
				</form>
			</div>
			<div class="col-2"></div>
			<div class="col-1">
				<a href="#"><i data-toggle="tooltip" data-placement="bottom"
					title="Cart"
					class="btn btn-secondary HeaderIcons fa fa-shopping-cart"></i></a>
			</div>
			<div class="col-2 ">
				<div class="LoginButton">
					<div class="dropdown">
						
						<a href="LogoutServlet" class="dropbtn"
							style="text-decoration: none;">Logout</a>
						<div class="dropdown-content">
							<a href="ViewUserOrders.jsp">View Orders</a> 
							<a href="EditBasicDetailProfile.jsp">Basic Profile Edit</a>
							<a href="EditAddress.jsp">Address Edit</a>
							<a href="SecurityEdit.jsp">Security Edit</a>
							<%
							try {
							if(user.getRoleID()==1){out.print("<a href="+"AdminDashboard.jsp"+">Admin Dashboard</a>");}}
							catch(Exception e) {
									request.setAttribute("msg","Please Login !!");
									request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
								}
							%>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</header>

	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="content">
		Hello World!! ${user.getFirstName()}
	</div>
	<footer class="row "
		style="background: linear-gradient(#8aaed1, white);">
		<div class="col-6">
			<div class="row">
				<div class="col-3">
					<div class="footerHeader">About</div>
					<a class="link-light" href="#">Contact US</a><br> <a
						class="link-light" href="#">About Us</a><br>
				</div>
				<div class="col-3">
					<div class="footerHeader">Help</div>
					<a class="link-light" href="#">Payment</a><br> <a
						class="link-light" href="#">Shiping</a><bR>
				</div>
				<div class="col-3">
					<div class="footerHeader">Policy</div>
					<a class="link-light" href="#">Security</a><br> <a
						class="link-light" href="#">Privacy</a><br>
				</div>
				<div class="col-3">
					<div class="footerHeader">Socials</div>
					<a class="link-light" href="#">FaceBook</a><br> <a
						class="link-light" href="#">Twitter</a><br> <a
						class="link-light" href="#">Youtube</a><br>
				</div>
			</div>
			<img
				src="https://static-assets-web.flixcart.com/www/linchpin/fk-cp-zion/img/payment-method_7934bc.svg"
				alt="" style="margin-top: 70px; width: 450px; margin-left: 120px;">
		</div>
		<!--ubhi liti-->
		<div class="col-6 vlLeft">
			<div class="row">
				<div class="col-6">
					<div class="footerHeader">Mail us :</div>
					<p>Flipkart Internet Private Limited, Buildings Alyssa, Begonia
						& Clove Embassy Tech Village, Outer Ring Road, Devarabeesanahalli
						Village, Bengaluru, 560103, Karnataka, India</p>
				</div>
				<div class="col-6">
					<div class="footerHeader">Registered Office Address :</div>
					<p>
						Flipkart Internet Private Limited, Buildings Alyssa, Begonia &

						Clove Embassy Tech Village, Outer Ring Road, Devarabeesanahalli
						Village, Bengaluru, 560103, Karnataka, India <br> CIN :
						U51109KA2012PTC066107 Telephone: 1800 202 9898
					</p>
				</div>
			</div>
		</div>
		<hr style="margin-top: 15px;">
		<section style="font-size: 20px;">
			<div class="row">
				<div class="col-8">
					<div class="row">
						<div class="col-2">
							<i class="fa fa-instagram"></i>
						</div>
						<div class="col-2">
							<i class="fa fa-facebook-f"></i>
						</div>
						<div class="col-2">
							<i class="fa fa-twitter"></i>
						</div>
						<div class="col-2">
							<i class="fa fa-whatsapp"></i>
						</div>
						<div class="col-2">
							<i class="fa fa-linkedin"></i>
						</div>
						<div class="col-2">
							<i class="fa fa-youtube"></i>
						</div>
					</div>
				</div>
				<div class="col-4">
					<div class="vlLeft" style="font-size: small; padding: 10px;">
						&copy;CompanyName 2020-21 CompanyName.com</div>
				</div>
			</div>
		</section>
	</footer>
</body>
</html>
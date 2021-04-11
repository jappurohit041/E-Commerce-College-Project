<%@page import="java.util.Calendar"%>
<%@page import="java.util.Formatter"%>
<%@page import="com.bean.ProductDetailBean"%>
<%@page import="com.bean.CategoryDetailBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bean.UserDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Category Report</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<!-- CSS Files -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/light-bootstrap-dashboard.css?v=2.0.0 "
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="assets/css/demo.css" rel="stylesheet" />
<style>
.img-fluid{ max-width: 128px;max-height: 128px;}
tr,td,th,table{
	border: 3px solid black;
}


		
.bgColor{
	background-image:url('images/back.png');
	font-size: 100px;
	text-decoration: underline;
	font-family: 'Cairo', sans-serif;
	margin-top: 250px;
	padding-top: 50px;
	border-radius: 30px;
	text-align: center;
	white-space: normal;
	word-wrap: break-word;
	
	
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
	mainUser =(UserDetailBean) session.getAttribute("mainUser");
	if(mainUser.getRoleID()!=1){
		request.setAttribute("msg","You don't have access in this area");		
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
}
%>
	<div class="wrapper">
		<div class="sidebar" data-image="assets/img/sidebar-4.jpg"
			data-color="blue">
			<div class="sidebar-wrapper">
				<div class="logo" style="margin-left: 15px">
					<img src="images/BigDealWhiteLogo.png" />
				</div>
				<ul class="nav">
					<li class="nav-item active"><a class="nav-link"
						href="AdminDashboard.jsp"> <i class="nc-icon nc-grid-45"></i>
							<p>Dashboard</p>
					</a></li>
					<li>
						<!--href = "UsersDisplayServlet"--> <a class="nav-link"
						href="UsersDisplay.jsp"> <i class="nc-icon nc-single-02"></i>
							<p>Manage Users</p>
					</a>
					</li>
					<li>
						<!--href = "ProductsDisplayServlet"--> <a class="nav-link"
						href="ProductsDisplay.jsp"> <i class="nc-icon nc-cart-simple"></i>
							<p>Manage Products</p>
					</a>
					</li>
					<li>
						<!-- href = "OrdersDisplayServlet"--> <a class="nav-link"
						href="OrdersDisplay.jsp"> <i class="nc-icon nc-delivery-fast"></i>
							<p>List of Orders</p>
					</a>
					</li>
					<li>
						<!-- href = "OrdersDisplayServlet"--> <a class="nav-link"
						href="CategoryDisplay.jsp"> <i class="nc-icon nc-layers-3"></i>
							<p>Manage Category</p>
					</a>
					</li>
					<li>
						<!-- href = "OrdersDisplayServlet"--> <a class="nav-link"
						href="SubCategoryDisplay.jsp"> <i class="nc-icon nc-notes"></i>
							<p>Manage Sub-Category</p>
					</a>
					</li>

				</ul>
			</div>
		</div>
		<div class="main-panel">
			<!-- Navbar -->
			<nav class="navbar navbar-expand-lg " color-on-scroll="500">
				<div class="container-fluid">
					<p class="navbar-brand">Category Report</p>
					<div class="collapse navbar-collapse justify-content-end"
						id="navigation">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="Home.jsp">
									<span class="no-icon">Home Page</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="LogoutServlet">
									<span class="no-icon">Log out</span>
							</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- End Navbar -->
			<div class="content">
				<div class="container-fluid content-row" style="float: left">
					<div class="section">
						<%HashMap<String,Object> report= (HashMap<String,Object>)request.getAttribute("report"); 
						CategoryDetailBean c = (CategoryDetailBean)report.get("categoryDetailed");
						ProductDetailBean p = (ProductDetailBean)report.get("topSalingProduct");
						%>
						<%if(report.containsKey("Error")){ %>
							<img src="images/NotFound1.png" style="width: 100%;    object-fit: cover;    overflow: hidden;">
						<%}else{ %>
							
							
							
				<div class="row">
					<div class="col-5 " style=" margin: 20px 0px 20px 0px; z-index: 5;">
							
				
							<div class=" text-center text-light" style="z-index: 3;">
								<h1 class="bgColor  text-wrap">Category Detail</h1>
							</div>
					</div>
					<div class="col-7" style="z-index: 5;">
							<div class="table-responsive">
									<table class="table text-dark" style="font-size: x-large;">
										<tbody>
											<tr>
												<th scope="row" class="th_row bg-primary text-light text-center">Category Name</th>
												<td class="bg-primary text-light text-center"><%=c.getCategoryName()%></td>
											</tr>
										
											<tr>
												<th scope="row" class="th_row text-center">Image</th>
												<td><img src="<%=c.getImagePath()%>" class="img-fluid" ></td>
											</tr>
										
											<tr>
												<th scope="row" class="th_row bg-primary text-light">Sub-Category Names</th>
												<td class="bg-primary text-light"> <%=c.getSubCategoryNames().replace(",","<br>")%></td>
											</tr>
										
											<tr>
												<th scope="row" class="th_row">Product Names</th>
												<td><%=c.getProductNames().replace(",","<br>")%></td>
											</tr>
									
											<tr>
												<th scope="row" class="th_row bg-primary text-light">Total Selling Done By This Category</th>
												<td class="bg-primary text-light"><%=report.get("totalSale") %></td>
											</tr>
										
											<tr>
												<th scope="row"  class="th_row" >Total Discount Done By This Category</th>
												<td><%=report.get("totalDiscount") %></td>
											</tr>
										
											<tr>
												<th class="th_row bg-primary text-light" scope="row">Total Selling Done This month By This Category</th>
												<td class="bg-primary text-light"><%=report.get("thisMonthSale") %></td>
											</tr>
											<tr>
												<th scope="row"  class="th_row">Total Discount Done This month By This Category</th>
												<td><%=report.get("thisMonthDiscount") %></td>
											</tr>
										</tbody>
									</table>
								</div>
					</div>
				</div>
				<div class="row" style="margin-bottom: 50px;z-index: 5;">
					<div class="col-1" style="margin-top: 75px;">
						<a class="btn btn-primary prev" style="border-radius: 50%; position: relative; top: 100px;"  onclick="plusSlides(-1)"><</a>
				
					</div>
					<div class="col-10">
							
						<div class="slideshow-container bg-light" style="margin-top: 50px; text-align: center;">
							<div class="mySlides">
								<div class="row">
									<div class="col-6" style="padding: 20px;">
												<div class="card">
													<div class="card-header">
															<div class="card-text" style="font-weight: bold;"><h3>All Time Top Selling</h3></div>
															<div class="card-text"><h4>Product Name: <%=p.getProductName()%></h4></div>
													</div>
													<div class="card-body">
														<div class="card-text">Category Name : <%=p.getCategoryName() %></div>
														<div class="card-text">SubCategory Name : <%=p.getSubCategoryName() %></div>
													</div>
													<div class="card-footer">
														<a href="ParticularProductReportServlet?productID=<%=p.getProductId()%>" class="btn btn-primary btn-block">See More Details</a>
													</div>
												
												</div>
									</div>
									<%p = (ProductDetailBean)report.get("leastSalingProduct"); %>
									<div class="col-6" style=" padding: 20px;">
												<div class="card">
													<div class="card-header">
															<div class="card-text" style="font-weight: bold;"><h3>All Time Least Selling</h3></div>
															<div class="card-text"><h4>Product Name: <%=p.getProductName()%></h4></div>
													</div>
													<div class="card-body">
														<div class="card-text">Category Name : <%=p.getCategoryName() %></div>
														<div class="card-text">SubCategory Name : <%=p.getSubCategoryName() %></div>
													</div>
													<div class="card-footer">
														<a href="ParticularProductReportServlet?productID=<%=p.getProductId()%>" class="btn btn-primary btn-block">See More Details</a>
													</div>
												
												</div>
									</div>
								</div>
							</div>
																				<%
												Formatter fmt = new Formatter();
								     			Calendar cal = Calendar.getInstance();
								      			fmt = new Formatter();
								      			fmt.format("%tB",cal);
													%>
							<div class="mySlides">
								<div class="row" >
								<%p = (ProductDetailBean)report.get("topSalingProductMonth"); %>
									
									<div class="col-6" style="padding: 20px;">
												<div class="card">
													<div class="card-header">
															<div class="card-text" style="font-weight: bold;"><h3>Top Selling for This Month (<%=fmt%>)</h3></div>
															<div class="card-text"><h4>Product Name: <%=p.getProductName()%></h4></div>
													</div>
													<div class="card-body">
														<div class="card-text">Category Name : <%=p.getCategoryName() %></div>
														<div class="card-text">SubCategory Name : <%=p.getSubCategoryName() %></div>
													</div>
													<div class="card-footer">
														<a href="ParticularProductReportServlet?productID=<%=p.getProductId()%>" class="btn btn-primary btn-block">See More Details</a>
													</div>
												
												</div>
									</div>
									<%p = (ProductDetailBean)report.get("leastSalingProductMonth"); %>
								
									<div class="col-6" style=" padding: 20px;">
												<div class="card">
													<div class="card-header">
															<div class="card-text" style="font-weight: bold;"><h3>Least Selling for This Month (<%=fmt%>)</h3></div>
															<div class="card-text"><h4>Product Name: <%=p.getProductName()%></h4></div>
													</div>
													<div class="card-body">
														<div class="card-text">Category Name : <%=p.getCategoryName() %></div>
														<div class="card-text">SubCategory Name : <%=p.getSubCategoryName() %></div>
													</div>
													<div class="card-footer">
														<a href="ParticularProductReportServlet?productID=<%=p.getProductId()%>" class="btn btn-primary btn-block">See More Details</a>
													</div>		
												</div>
									</div>
								</div>
							</div>
					</div>
				</div>
				<div class="col-1" style="margin-top: 75px;">
						<a class="btn btn-primary next" style="float: right; border-radius: 50%;  position: relative; top: 100px;" onclick="plusSlides(1)">></a>    
				</div>
</div>
						<%} %>
					</div>
				</div>
			</div>
		</div>
	</div>
	<p style="display: none" id='con'>${msg}</p>
	<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
	  slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
	  dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>
	<script>
        var s = document.getElementById('con').innerHTML;	
        if(s!=''){
        	window.alert(s)	
        }
    </script>
	<%}catch(Exception e){
		request.setAttribute("msg","You are not logined Please login");
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
%>
</body>
<!--   Core JS Files   -->
<script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="assets/js/plugins/bootstrap-switch.js"></script>
<!--  Chartist Plugin  -->
<script src="assets/js/plugins/chartist.min.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="assets/js/light-bootstrap-dashboard.js?v=2.0.0 "
	type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

</html>
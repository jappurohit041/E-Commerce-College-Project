<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.ProductDetailBean"%>
<%@page import="java.util.ArrayList"%>
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
<title>Top Selling Products</title>
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
					<p class="navbar-brand">Top Five Selling Products</p>
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
					<%ArrayList<ProductDetailBean> list=(ArrayList<ProductDetailBean>)ProductDao.getTopSellingProducts();%>
				<div class="table-responsive">
					<table border="1">
						<thead>
							<tr>
								<th>Product ID</th>
								<th>Product Name</th>
								<th>Company Name</th>
								<th>Category Name</th>
								<th>SubCategory Name</th>
								<th>Orignal Price</th>
								<th>Offer Price</th>
								<th>Offer Till</th>
								<th>Quantity Left</th>
								<th>Quantity Sold</th>
								<th>Total Earning</th>
								<th>Image</th>
								<th>Product Description</th>
								<th>Is Active</th>
							</tr>
						</thead>
						<tbody>
							<%for(ProductDetailBean p: list ){ 
                		%>
							<tr>
								<td><%=p.getProductId()%></td>
								<td><%=p.getProductName()%></td>
								<td><%=p.getCompanyName() %></td>
								<td><%=p.getCategoryName() %></td>
								<td><%=p.getSubCategoryName() %></td>
								<td><%=p.getOriginalPrice() %></td>
								<td><%=p.getOfferPrice() %></td>
								<td><%=p.getOfferTill() %></td>
								<td><%=p.getQuantity() %></td>
								<td><%=p.getSoldQuantity() %></td>
								<td><%=p.getTotalAmount() %></td>
								<td><img src="<%=p.getImagePath() %>"></td>
								<td><%=p.getProductDescription() %></td>
								<%String answer = p.getIsActive()==1?"Yes":"No"; %>
								<td><%=answer %></td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>		
					</div>
				</div>
			</div>
		</div>
	</div>
	<p style="display: none" id='con'>${msg}</p>
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
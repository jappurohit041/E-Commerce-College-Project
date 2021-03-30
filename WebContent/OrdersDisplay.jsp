<%@page import="com.bean.OrderDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.OrderDao"%>
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
<title>Order Display Panel</title>
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
</head>

<body>
	<div class="wrapper">
		<div class="sidebar" data-image="assets/img/sidebar-4.jpg"
			data-color="blue">
			<div class="sidebar-wrapper">
				<div class="logo" style="margin-left: 15px">
					<img src="assets/img/logo.jpg" />
				</div>
				<ul class="nav">
					<li><a class="nav-link" href="AdminDashboard.jsp"> <i
							class="nc-icon nc-grid-45"></i>
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
					<li class="nav-item active">
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
					<p class="navbar-brand">List of Orders</p>
					<div class="collapse navbar-collapse justify-content-end"
						id="navigation">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="Home.jsp">
									<span class="no-icon">Home Page</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#pablo">
									<span class="no-icon">Log out</span>
							</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- End Navbar -->
			<div class="content">
				<%ArrayList<OrderDetailBean> listOfOrders = OrderDao.getAllOrders(); %>
				<div class="table-responsive">
					<table border="1">
						<thead>
							<tr>
								<th>Order ID</th>
								<th>User ID</th>
								<th>Address</th>
								<th>Payment Type</th>
								<th>Final Amount</th>
								<th>Total Amount</th>
								<th>Discount Amount</th>
								<th>Quantity</th>
								<th>Order Date</th>
								<th>Delivery Date</th>
								<th>Delivery Status</th>
							</tr>
						</thead>
						<tbody>
							<%for(OrderDetailBean order: listOfOrders ){ %>
                			<tr>
								<td><%=order.getOrderID() %></td>
								<td><%=order.getUserID() %></td>
								<td><%=order.getAddress() %></td>
								<%String answer = (order.getPaymentType()== 0) ? "COD" : order.getPaymentType()==1? "Net-Banking":"Credit-Card"; %>
								<td><%=answer %></td>
								<td><%=order.getFinalAmount() %></td>
								<td><%=order.getTotalAmount() %></td>
								<td><%=order.getDiscountAmount() %></td>
								<td><%=order.getQuantity() %></td>
								<td><%=order.getOrderDate() %></td>
								<td><%=order.getDeliveryDate() %></td>
								<%answer =  order.getDeliveryStatus()==0? "Delievered" : "Not-Delievered";%>
								<td><%=answer %></td>
							</tr>
							<%}%>
						</tbody>
					</table>
				</div>
				
			</div>
		</div>
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

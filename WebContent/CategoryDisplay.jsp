<%@page import="com.bean.UserDetailBean"%>
<%@page import="com.dao.CategoryDao"%>
<%@page import="com.bean.CategoryDetailBean"%>
<%@page import="java.util.ArrayList"%>
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
<title>Category Display Panel</title>
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
.navbar {
	
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
					<li>
						<!-- href = "OrdersDisplayServlet"--> <a class="nav-link"
						href="OrdersDisplay.jsp"> <i class="nc-icon nc-delivery-fast"></i>
							<p>List of Orders</p>
					</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="CategoryDisplay.jsp"> <i class="nc-icon nc-layers-3"></i>
							<p>Manage Category</p>
					</a></li>
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
					<p class="navbar-brand">Manage Category</p>
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
				<hr style="border-color: black; border-width: 5px;">
				<a class="btn btn-primary" href="AddCategory.jsp">Add Category</a> <a
					class="btn btn-danger" href="DeleteCategoryList.jsp" style="float: right">Deleted
					Category List</a>
				<hr style="border-color: black; border-width: 5px;">
				<br>
				<p style="display: none" id='con'>${msg}</p>	
				<%ArrayList<CategoryDetailBean> list=(ArrayList<CategoryDetailBean>)CategoryDao.getAllCategory();%>
				<div class="table-responsive">
					<table border="1" style="table-layout: fixed; width: 100%; text-align: center; word-wrap: break-word; text-align: center;" class="table-striped table-light">
						<thead  style="text-align: center;">
							<tr>
								<th style="word-wrap: break-word; text-align: center;">Category ID</th>
								<th style="word-wrap: break-word; text-align: center;">Category Name</th>
								<th style="word-wrap: break-word; text-align: center;">IsActive</th>
								<th style="word-wrap: break-word; text-align: center;">Category Display Image</th>
								<th style="word-wrap: break-word; text-align: center;">Action</th>
							</tr>
						</thead>
						<tbody>
							<%for(CategoryDetailBean category: list ){ 
                			if(category.getIsActive()==1){
                		%>
							<tr style="font-size: x-large;">
								<td><%=category.getCategoryID() %></td>
								<td><%=category.getCategoryName() %></td>
								<td><%=category.getIsActive()==0?"No":"Yes"%></td>
								<td><img src="<%=category.getImagePath() %>" class="img-fluid"></td>
								<td><a
									href="UpdateCategoryServlet?categoryID=<%=category.getCategoryID()%>"><button
											type="button" class="btn btn-primary btn-block" style="white-space:normal;">Update</button></a> <a
									href="DeleteCategoryServlet?categoryID=<%=category.getCategoryID()%>"><button
											type="button" class="btn btn-danger btn-block" style="white-space:normal;">Delete</button></a></td>
							</tr>
							<%}} %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
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

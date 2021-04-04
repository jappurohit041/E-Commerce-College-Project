<%@page import="com.bean.UserDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link href="headercss.css" rel="stylesheet"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"><link href="fontawesome/css/font-awesome.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>

</head>
<body>
<%	
UserDetailBean mainUser=null;
if(session == null || session.getAttribute("isLogin") == null){
		request.setAttribute("msg","Your session expired or you are not logined");		
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
else{
	mainUser = (UserDetailBean)session.getAttribute("mainUser");	
}

%>

	<header class="container-fluid header">
		<div class="row align-items-center">
			<div class="col-1">
				<a href="Home.jsp"><img src="images/BigDealWhiteLogo.png" width="250px"></a>
			</div>
			<div class="col-2"></div>
			<div class="col-4">
					<form action = "SearchProductByName">
					<div class="input-group">
 						<input type="search" name="productName" class="form-control rounded" placeholder="Search Product Name" aria-label="Search" aria-describedby="search-addon" />
  						<button type="submit" class="btn btn-outline-light">search</button>
					</div>
					</form>
			</div>
			<div class="col-2"></div>
			
			<div class="col-2">
				<div class="LoginButton">
					<div class="dropdown" style="margin:0px;width:100%;">
						<a href="LogoutServlet" class="dropbtn"
							style="text-decoration: none;">Logout</a>
						<div class="dropdown-content" style="margin:0px;text-align:center; width: 100%;">
							<a href="ViewUserOrders.jsp" style="text-decoration: none;">View Orders</a> 
							<a href="EditBasicDetailProfile.jsp" style="text-decoration: none;">Basic Profile Edit</a>
							<a href="EditAddress.jsp" style="text-decoration: none;">Address Edit</a>
							<a href="SecurityEdit.jsp" style="text-decoration: none;">Security Edit</a>
							<a href="ViewProfile.jsp" style="text-decoration: none;">View Whole Profile</a>
							<%
							try {
							if(mainUser.getRoleID()==1){%><a href=AdminDashboard.jsp style="text-decoration: none;">Admin Dashboard</a><%}}
							catch(Exception e) {
									request.setAttribute("msg","Please Login !!");
									request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
								}
							%>
						</div>
					</div>
				</div>
			</div>
			<div class="col-1">
				<a href="CartDisplay.jsp"><i data-toggle="tooltip" data-placement="bottom" title="Cart"
					class="btn btn-secondary HeaderIcons fa fa-shopping-cart"></i></a>
			</div>
		</div>
	</header>
</body>
</html>
<%@page import="com.dao.UserDao"%>
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
<link href="headercss.css" rel="stylesheet"/>
<title>Home Page</title>
</head>
<body>
<%@include file="Header.jsp" %>
<div class="container-fluid">
<div class="content">
<%@include file="Category.jsp" %>
<%@include file="Carousel.jsp" %>
<hr><p style="font-size: 25px;text-decoration: underline;"><strong>Top Selling Products</strong></p><hr>
<div class="card-deck">
				<div class="card">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.get(0).getImagePath()%>">
							</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.get(0).getProductName() %></h5>
							<h5>Product Description: <%=p.get(0).getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.get(0).getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.get(0).getOfferPrice() %></h5>	
						</div>
						
						<div class="card-footer">
								<a href="AddToCartServlet?productID=<%=p.get(0).getProductId()%>&userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.get(0).getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
				<div class="card">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.get(1).getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.get(1).getProductName() %></h5>
							<h5>Product Description: <%=p.get(1).getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.get(1).getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.get(1).getOfferPrice() %></h5>	
						</div>
						
						<div class="card-footer">
								<a href="AddToCartServlet?productID=<%=p.get(1).getProductId()%>&userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.get(1).getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
				<div class="card">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.get(2).getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.get(2).getProductName() %></h5>
							<h5>Product Description: <%=p.get(2).getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.get(2).getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.get(2).getOfferPrice() %></h5>	
						</div>
						
						<div class="card-footer">
								<a href="AddToCartServlet?productID=<%=p.get(2).getProductId()%>&userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.get(2).getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
				<div class="card">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.get(3).getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.get(3).getProductName() %></h5>
							<h5>Product Description: <%=p.get(3).getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.get(3).getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.get(3).getOfferPrice() %></h5>	
						</div>
						
						<div class="card-footer">
								<a href="AddToCartServlet?productID=<%=p.get(3).getProductId()%>&userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.get(3).getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
				<div class="card">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.get(4).getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.get(4).getProductName() %></h5>
							<h5>Product Description: <%=p.get(4).getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.get(4).getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.get(4).getOfferPrice() %></h5>	
						</div>
						
						<div class="card-footer">
								<a href="AddToCartServlet?productID=<%=p.get(4).getProductId()%>&userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.get(4).getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
</div>
<hr>
</div>
</div>
<%@include file="Footer.jsp" %>
</body>
</html>
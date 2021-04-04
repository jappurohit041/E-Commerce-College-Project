<%@page import="com.bean.ProductDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Description</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>


<style>
    .rowss{
        position: relative;
        height: 100%;
    }
    .imageStyling{

        border-radius: 20px;
        border: 2px solid black;
    }
</style>
</head>
<body>
<%ProductDetailBean p = (ProductDetailBean)request.getAttribute("detailProduct");%>
<%@include file="Header.jsp" %>
    <div class="container-fluid" >
    	<div class="content" style="margin-bottom: 50px;">
	        <div class="row align-self-center rowss">
	            <div class="col-5">
	                <div class="card">
	                    <div class="card-body text-center">
	                        <img src="<%=p.getImagePath()%>" class="imageStyling" alt="" width="500px" height="430px">
	                    </div>
	                    <div class="card-body" style="border-bottom: 2px solid black;border-top: 2px solid black; margin-left: 20px; margin-right: 10px;">
	                        <div class="row justify-content-center align-items-center">
	                            <div class="col-6 text-center">
	                                <a href="AddToCartServlet?productID=<%=p.getProductId()%>&userID=<%=mainUser.getUserID()%>" class="btn btn-outline-primary btn-group-lg"><h4>Add to cart</h4></a>        
	                            </div>
	                            <div class="col-6 text-center">
	                                <a href="#" class="btn btn-outline-primary btn-group-lg"><h4>BUY NOW</h4></a>        
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>

	            <div class="col-7 text-center">
	                <div style="margin-top: 30px;">
	                    <hr>
	                    <h3><%=p.getProductName() %></h3>
	                    <hr>
	                </div>
	                <div class="row" style="margin-top: 10px; text-align: left;">
	                	<div class="col"><h5>Category Name : <%=p.getCategoryName() %></h5>
	                	<br>
	                	<h5>Sub-Category Name : <%=p.getSubCategoryName()%></h5>
	                	<br>
	                	 <h5>Product Description : <%=p.getProductDescription()%></h5>
	                	 <br>
	                	 <h5>Offer Till : <%=p.getOfferTill()%></h5>
	                	 <br>
	                	 <h5>Company Name : <%=p.getCompanyName()%></h5>
	                	 <hr>
	                	</div>
	                </div>
	                
	                <div class="container-fluid" style="text-align: right;">
	                    <div class="text-primary"><h4>Discounted Price : <%=p.getOfferPrice()%></h4></div>
	                    <div class="text-danger"><h4>Original price : <span style="text-decoration: line-through;"><%=p.getOriginalPrice() %></span></h4></div>
	                   	<%float percentage = ((p.getOriginalPrice()-p.getOfferPrice())/p.getOriginalPrice())*100; %>
	                    <div class="text-success" style="text-decoration: underline"><h4>Discount Percentage : <%=percentage %></h4></div>
	                </div>
	            </div>
	        </div>
    	</div>
    </div>
<%@include file="Footer.jsp" %>
</body>
</html>
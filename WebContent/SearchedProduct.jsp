<%@page import="com.bean.UserDetailBean"%>
<%@page import="com.bean.ProductDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Searched Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"><link href="fontawesome/css/font-awesome.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
</head>
<style>
.btn.outline {
	background: none;
	padding: 10px 50px 10px 50px;
}
.btn-primary.outline {
	border: 2px solid #0099cc;
	color: blue;
}
.btn-primary.outline:hover, .btn-primary.outline:focus, .btn-primary.outline:active, .btn-primary.outline.active, .open > .dropdown-toggle.btn-primary {
	color: white;
	border-color: #33a6cc;
}

.btn-warning.outline {
	border: 2px solid orange;
	color: orange;
}
.btn-warning.outline:hover, .btn-warning.outline:focus, .btn-primary.outline:active, .btn-primary.outline.active, .open > .dropdown-toggle.btn-primary {
	color: white;
	border-color: orange;
}

</style>
<body>
<%@include file="Header.jsp" %>
<div class="container-fluid" >

	
	<%@include file="Category.jsp" %>
	<div class="content" style="margin-bottom: 50px;margin-top: 50px;">
	<%ArrayList<ProductDetailBean> products = (ArrayList<ProductDetailBean>)request.getAttribute("productDetails");
		int counter = 0;
		ProductDetailBean p;
		 for(int i = -1; i<products.size();){ 
			 /* if(products.size()%2==0){ */%>
			 <div class="row">
			 	<%	
					if(i<products.size()-1){i++;}
					else{break;}
				%>
				<%p = products.get(i);%>
				<div class=" col-3">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.getProductName() %></h5>
							<h5>Product Description: <%=p.getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.getOfferPrice() %></h5>	
						</div>
						
						<div class="card-bottom">
								<a href="AddToCartServlet?productID=<%=p.getProductId()%>userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
				<%	
					if(i<products.size()-1){i++;}
					else{break;}
				%>
				<%p = products.get(i);%>
				<%-- <div class=" col-3">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							Product Name: <%=p.getProductName() %><br>
							Product Description: <%=p.getProductDescription() %><br>
							Offer Till:	<%=p.getOfferTill() %><br>
							
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							Base Price Rs. <%=p.getOriginalPrice() %><br>
							Offer Price Rs.<%=p.getOfferPrice() %>	
						</div>
						
						<div class="card-bottom">
								<a href="AddToCartServlet?productID=<%=p.getProductId()%>userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div> --%>
						<div class=" col-3">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.getProductName() %></h5>
							<h5>Product Description: <%=p.getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.getOfferPrice() %></h5>	
						</div>
						
						<div class="card-bottom">
								<a href="AddToCartServlet?productID=<%=p.getProductId()%>userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
				<%	
					if(i<products.size()-1){i++;}
					else{break;}
				%>
				<%p = products.get(i);%>
						<div class=" col-3">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.getProductName() %></h5>
							<h5>Product Description: <%=p.getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.getOfferPrice() %></h5>	
						</div>
						
						<div class="card-bottom">
								<a href="AddToCartServlet?productID=<%=p.getProductId()%>userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
				<%	
					if(i<products.size()-1){i++;}
					else{break;}
				%>
				<%p = products.get(i);%>
		<div class=" col-3">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5>Product Name: <%=p.getProductName() %></h5>
							<h5>Product Description: <%=p.getProductDescription()%></h5>
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							<h5 class="text-danger">Base Price Rs. <%=p.getOriginalPrice() %></h5>
							<h5 class="text-primary">Offer Price Rs.<%=p.getOfferPrice() %></h5>	
						</div>
						
						<div class="card-bottom">
								<a href="AddToCartServlet?productID=<%=p.getProductId()%>userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-lg outline" >Add To Cart</a>
								<a href="DetailProductServlet?productID=<%=p.getProductId()%>" class="btn btn-warning btn-lg outline" >View Details</a>
						</div>
					</div>
				</div>
			 </div>	 
			 <%-- <%}%> --%>
			 <%-- else{%>
			  <div class="row">
			 	<%	
					if(i<products.size()-1){i++;}
					else{break;}
				%>
				<%p = products.get(i);%>
				<div class=" col-4">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							Product Name: <%=p.getProductName() %><br>
							Product Description: <%=p.getProductDescription() %><br>
							Offer Till:	<%=p.getOfferTill() %><br>
							
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							Base Price Rs. <%=p.getOriginalPrice() %><br>
							Offer Price Rs.<%=p.getOfferPrice() %>	
						</div>
						
						<div class="card-bottom">
								<a href="#" class="btn btn-outline-primary" style="float: left;">Add To Cart</a>
								<a href="#" class="btn btn-outline-warning" style="float: right;">View Details</a>
						</div>
					</div>
				</div>
				<%	
					if(i<products.size()-1){i++;}
					else{break;}
				%>
				<%p = products.get(i);%>
				<div class=" col-4">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							Product Name: <%=p.getProductName() %><br>
							Product Description: <%=p.getProductDescription() %><br>
							Offer Till:	<%=p.getOfferTill() %><br>
							
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							Base Price Rs. <%=p.getOriginalPrice() %><br>
							Offer Price Rs.<%=p.getOfferPrice() %>	
						</div>
						
						<div class="card-bottom">
								<a href="#" class="btn btn-outline-primary" style="float: left;">Add To Cart</a>
								<a href="#" class="btn btn-outline-warning" style="float: right;">View Details</a>
						</div>
					</div>
				</div>
				<%	
					if(i<products.size()-1){i++;}
					else{break;}
				%>
				<%p = products.get(i);%>
				<div class=" col-4">
						<div class="card text-center"  style="border : 1px solid black; ">
							<div class="card-header">
							<img class="card-img-top" src="<%=p.getImagePath()%>">
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							Product Name: <%=p.getProductName() %><br>
							Product Description: <%=p.getProductDescription() %><br>
							Offer Till:	<%=p.getOfferTill() %><br>
							
						</div>
						<div class="card-body"  style="border-bottom : 1px solid black;border-top : 1px solid black;">
							Base Price Rs. <%=p.getOriginalPrice() %><br>
							Offer Price Rs.<%=p.getOfferPrice() %>	
						</div>
						
						<div class="card-bottom">
								<a href="#" class="btn btn-outline-primary" style="float: left;">Add To Cart</a>
								<a href="#" class="btn btn-outline-warning" style="float: right;">View Details</a>
						</div>
					</div>
				</div>
				<%	
					if(i<products.size()-1){i++;}
					else{break;}
				%>
			 </div>	 
			 <%} %> --%>
			 
	
			

			<%} %>
			<%if(products.size()==0){ %>
				<img src="images\Product_Not_Found.png"   style="display: block; margin-left: auto; margin-right: auto; width: 50%;">
			<%} %>
	</div>
</div>
<%@include file="Footer.jsp" %>
</body>
</html>
<%@page import="com.bean.UserDetailBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="script.js"></script>
<title>Apply Discount By Product</title>
</head>
<body>
	<%try{
		UserDetailBean mainUser=null;
		if(session == null || session.getAttribute("isLogin") == null){
				request.setAttribute("msg","Your session expired or you are not logined");		
				request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
			}
		else{
			mainUser = (UserDetailBean)session.getAttribute("mainUser");	
			if(mainUser.getRoleID()!=1){
				request.setAttribute("msg","You are not authorise to access that thing");		
				request.getRequestDispatcher("LoginForm.jsp").forward(request,response);				
			}
		}
	 %>
	<form id="msform" action="ApplyDiscountByProduct" method="post">
		<fieldset>
			<%HashMap<Integer, String> map = ProductDao.productIDAndQuestion();  %>
			<h2 class="fs-title">Product Details</h2>
			<div class="row">
				<div class="col-6">
					<label for="inputProductName">Product Name</label> <select id="discountType" 
					class="form-control" name = "productID" required>
						<option value="">Please select option value</option>
						 <%for (Integer i: map.keySet()) {%>
			 			<option value="<%=i%>" > <%=map.get(i) %> </option>
			 			<%} %>
					</select>
				</div>
				<div class="col-6">
					<label for="discountType">Apply Discount Type</label> 
					<select id="discountType" class="form-control"
						name="discountType" required>
						<option value="">Please select discount type</option>
						<option value="1">By Price</option>
						<option value="2">By Percentage</option>
					</select>
				</div>
			</div>
			<br>	
			
			<div class="row">
				<div class="col-6">
					<label for="inputPrice">Value of Discount Percentage/Discount Amount</label> 
					<input type="number" name="valueOfDiscount" required>
					<label class="error" style="color: red; font-weight: bold;">${negativeType}</label>
				</div>
				<div class="col-6">
					<label for="inputPrice">Offer Till</label> 
					<input type="date" name="offerTill" required>
				</div>
			</div>
			<input type="submit" name="submit"
				class="btn btn-success success action-button" value="Update Price" />
		</fieldset>
	</form>
	<%} 
	catch(Exception e){
		request.setAttribute("msg", "You are not logined!! Please login");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	}
	%>
</body>
</html>
<%@page import="com.dao.CategoryDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bean.UserDetailBean"%>
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
<title>Insert title here</title>
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
	 	<form id="msform" action="ApplyDiscountByCategory" method="post">
		<fieldset>
			<%HashMap<Integer, String> map = CategoryDao.getCategoryName();  %>
			<h2 class="fs-title">Category Details</h2>
			<div class="row">
				<div class="col-12">
					<label for="inputProductName">Category Name</label> <select id="discountType" 
					class="form-control" name = "categoryID" style="padding: 8px 16px;" required>
						<option value="">Please select option value</option>
						 <%for (Integer i: map.keySet()) {%>
			 			<option value="<%=i%>" > <%=map.get(i) %> </option>
			 			<%} %>
					</select>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-6">
					<label for="inputPrice">Value of Discount Percentage</label> 
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
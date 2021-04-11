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
<title>Edit Category</title>
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
	<form id="msform" action="EditCategoryServlet" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<h2 class="fs-title">Category Details</h2>
			<input type="hidden" value="${category.getCategoryID()}"
				name="categoryID">
			<div class="row">
				<div class="col-6">
					<label for="inputProductName">Category Name</label> <input
						type="text" value="${category.getCategoryName()}"
						class="form-control" placeholder="Category Name"
						id="inputFirstName" name="categoryName"> <label
						class="error">${productNameError}</label>
				</div>
				<div class="col-6">
					<div class="col">
						<label for="inputImage">Image Path</label> <input type="file"
							class="form-control" placeholder="Input" id="inputImage"
							name="inputImage" style="padding: 3.5px 3px;" /> <label
							class="error">${imageError}</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="inputCategoryStatus">Category Active</label> <select
						class="form-control" id="questions" name="inputCategoryStatus"
						onchange="getdata()">
						<option value="-1">Please select category active status</option>
						<option value="0">No</option>
						<option value="1">Yes</option>
					</select> <label class="error">${categoryStatusError}</label>
				</div>
			</div>
			<input type="submit" name="submit"
				class="btn btn-success success action-button" value="Submit" />

		</fieldset>
	</form>
		<%}catch(Exception e){
		request.setAttribute("msg","You are not logined Please login");
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
%>
</body>
</html>
<%@page import="java.util.HashMap"%>
<%@page import="com.dao.CategoryDao"%>
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
<title>Add Sub-Category</title>
</head>
<body>
	<% HashMap<Integer, String> list = CategoryDao.getCategoryName();%>
	<form id="msform" action="EditSubCategoryServlet" method="post">
		<fieldset>
			<h2 class="fs-title">Sub-Category Details</h2>
			<div class="row">
				<input type ="hidden" value="${subCategory.getSubCategoryID()}" name="subCategoryID">
				<div class="col-6">
					<label for="inputSubCategoryName">Sub-Category Name</label> 
					<input
						type="text" value="${subCategory.getSubCategoryName()}" class="form-control"
						placeholder="Sub-Category Name" id="inputSubCategoryName"
						name="subCategoryName"> 
						<label class="error">${subCategoryNameError}</label>
				</div>
				<div class="col-6">
					<label for="inputCategory">Category</label> 
					<select
						class="form-control" id="questions" name="inputCategory"
						onchange="getdata()">
						<option value="-1">Please select category</option>
					 <%for (Integer i: list.keySet()) {%>
						 	<option value="<%=i%>" > <%=list.get(i) %> </option>
					<%} %>
					</select>
					<label class="error">${categoryError}</label>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="inputSubCategoryStatus">Sub-Category Active</label> 
					<select
						class="form-control" id="questions" name="inputSubCategoryStatus"
						onchange="getdata()">
						<option value="-1">Please select sub-category active
							status</option>
						<option value="0">No</option>
						<option value="1">Yes</option>
					</select>
					<label class="error">${subCategoryStatus}</label>
				</div>
			</div>
			<input type="submit" name="submit"
				class="btn btn-success success action-button" value="Submit" />

		</fieldset>
	</form>
</body>
</html>
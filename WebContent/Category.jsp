<%@page import="com.bean.UserDetailBean"%>
<%@page import="com.dao.SubCategoryDao"%>
<%@page import="com.bean.SubCategoryDetailBean"%>
<%@page import="com.bean.CategoryDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CategoryType</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<style>


.categoryImg {
	text-align: center;
}

.DropdownRadiusLeft {
	border-radius: 0%;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
}
</style>
</head>
<body>

	<%ArrayList<CategoryDetailBean> category = (ArrayList<CategoryDetailBean>)CategoryDao.getAllCategory(); %>
	<div class="container-fluid">
		<div class="row">
			<%for(CategoryDetailBean c: category){if(c.getIsActive()==1){%>
				<div class="col" align="center">
					<img src="<%=c.getImagePath()%>" height="55px" width="55px"/>
					<br>
					<div class="btn-group">
						
					<% ArrayList<SubCategoryDetailBean> subCategory = (ArrayList<SubCategoryDetailBean>)SubCategoryDao.getSubCategoryByID(c.getCategoryID());%>
					
					<%if (subCategory.size()!=0){ %>
					<button type="button"
			class="btn btn-light dropdown-toggle dropdown-toggle-split DropdownRadiusLeft"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<button type="button" class="btn btn-light text-dark"><a href="GetProductServlet?categoryID=<%=c.getCategoryID()%>&subCategoryID=" style="text-decoration: none; color: grey;"><%=c.getCategoryName()%></a></button>
			<span class="sr-only">Toggle Dropdown</span>
					</button>	
					<div class="dropdown-menu">
						
					<%for(SubCategoryDetailBean sb: subCategory){if(sb.getIsActive()==1){ %>
							<a class="dropdown-item" href="GetProductServlet?categoryID=<%=c.getCategoryID()%>&subCategoryID=<%=sb.getSubCategoryID()%>"><%=sb.getSubCategoryName() %></a><%}} }%>
					
					<%if(subCategory.size()==0 || subCategory==null){ %>
					<button type="button"
			class="btn btn-light dropdown-toggle dropdown-toggle-split DropdownRadiusLeft disabled"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<button type="button" class="btn btn-light text-dark"><%=c.getCategoryName() %></button>
			<span class="sr-only">Toggle Dropdown</span>
					</button><div class="dropdown-menu disabled"><%} %>
					</div>
					</div>
				</div>
				
			<%}}%>
		</div>
	</div>
</div>

</body>
</html>
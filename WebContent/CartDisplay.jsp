<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <link href="headercss.css" rel="stylesheet"/>
<title>Cart Display</title>
</head>
<body>
	<div class="Header" style="z-index: +10">
	<%@include file="Header.jsp"%>
	</div>
	<div class="container-fluid">
		<div class="content" style="z-index: -1">
			 <%@include file="CartDesign.jsp" %> 
		</div>
	</div>
	
	<%@include file="Footer.jsp" %>
</body>
</html>
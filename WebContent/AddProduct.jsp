<%@page import="com.bean.UserDetailBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<title>Add Product</title>
<style>
body {
	background-repeat: no-repeat;
}
.error{
	color: red;
}
</style>
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
	<form id="msform" action="AddProductServlet" method="post" enctype = "multipart/form-data">
		<fieldset>
			<h2 class="fs-title">Product Details</h2>
			<div class="row">
				<div class="col-6">
					<label for="inputProductName">Product Name</label> <input
						type="text" class="form-control" placeholder="Product Name"
						id="inputProductName" name="productName" value="${product.getProductName()}">
						<label class="error">${productNameError}</label>
				</div>
				<div class="col-6">
					<label for="inputCompanyName">Company Name</label> <input
						type="text" class="form-control" placeholder="Company Name"
						id="inputCompanyName" name="companyName" value="${product.getCompanyName()}"/>
						<label class="error">${productCompanyNameError}</label>			
				</div>
			</div>
			<div class="row">

				<div class="col-6">
					<label for="inputDescription">Description</label> <input
						type="text" class="form-control" placeholder="Description"
						id="inputDescription" name="description" value="${product.getProductDescription() }">
						<label class="error">${productDescriptionError}</label>
				</div>
				<div class="col-6">
					<label for="inputQuantity">Quantity</label> <input type="number"
						class="form-control" placeholder="Quantity" id="inputQuantity"
						name="quantity" value="${product.getQuantity() }" />
						<label class="error">${productQuantityPriceError}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputOriginalPrice">Original Price</label> <input
						type="number" class="form-control" placeholder="Original Price"
						id="inputOriginalPrice" name="originalPrice" value="${product.getOriginalPrice() }"/>
						<label class="error">${productOriginalPriceError}</label>
				</div>

				<div class="col-6">
					<label for="inputOfferPrice">Offer Price</label> <input
						type="number" class="form-control" placeholder="Offer Price"
						id="inputOfferPrice" name="offerPrice" value="${product.getOfferPrice() }" />
						<label class="error">${productOfferPriceError}</label>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputOfferTillDate">Offer Till Date</label> <input
						type="date" class="form-control" placeholder="Offer-Date"
						id="inputOfferTillDate" name="inputOfferTillDate" />
						<label class="error">${productOfferTillError}</label>
				</div>
				<div class="col-6">
					<label for="inputProductStatus">Product Active</label> 
					<select
						class="input-field" id="activeSession" name="inputProductStatus">
						<option value="-1">Please select product active status</option>
						<option value="0">No</option>
						<option value="1">Yes</option>
					</select>
					<div class="row">
						<label class="error">${productStatusError}</label>
					</div>
				</div>
								
			</div>
			<div class="row">
				<div class="col-6">
					<label for="inputCategory">Category</label> <select
						class="input-field" id="category" name="category">
						<option value="-1">Please select category ?</option>
					</select>
					<div class="row">
					<label class="error">${productCategoryError}</label>
					</div>
				</div>
				<div class="col-6">
					<label for="inputsubCategory">Sub-Category</label> <select
						class="input-field" id="subCategory" name="subCategory">
						<option value="-1">Please select sub category?</option>
					</select>
					<div class="row">
					<label class="error">${productSubCategoryError}</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="inputImage">Image Path</label> <input type="file"
						class="form-control" placeholder="Input" id="inputImage"
						name="input" style="padding: 3.5px 3px;" />
				</div>
				<div class="row">
				<label class="error">${productImagePathError}</label>
				</div>
			</div>
			<input type="submit" name="submit"
				class="btn btn-success success action-button"
				style="margin: 5px; padding: 0px" value="Submit" />
		</fieldset>
	</form>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
            url: "GetCategoryAndSubCategory",
            method: "GET",
            data: {operation: 'category'},
            success: function (data, textStatus, jqXHR) {
                let obj = $.parseJSON(data);
                console.log(obj)
                $.each(obj, function (key, value) {
                    $('#category').append('<option value="' + value.categoryID + '">' + value.categoryName + '</option>')
                });
                $('select').formSelect();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#category').append('<option>Category Unavailable</option>');
            },
            cache: false
        });	
	});
    $('#category').change(function () {
        $('#subCategory').find('option').remove();
        $('#subCategory').append('<option value="-1">Select Sub Category</option>'); 

        let cid = $('#category').val();
        let data = {
            operation: "subCategory",
            id: cid
        };
        
        $.ajax({
            url: "GetCategoryAndSubCategory",
            method: "GET",
            data: data,
            success: function (data, textStatus, jqXHR) {
                let obj = $.parseJSON(data);
                console.log(obj)
                $.each(obj, function (key, value) {
                    $('#subCategory').append('<option value="' + value.subCategoryID + '">' + value.subCategoryName + '</option>')
                });
                $('select').formSelect();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#subCategory').append('<option>SubCategory Unavailable</option>');
            },
            cache: false
        });
    });

</script>
	<%}catch(Exception e){
		request.setAttribute("msg","You are not logined Please login");
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}%>
</body>

</html>

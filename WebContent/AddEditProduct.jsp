<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <script src="script.js"></script>
    <title>Add or Edit Product</title>
</head>

<body>
			<!-- multistep form -->
            <form id="msform" action="Home.jsp" method="post">
                <!-- progressbar -->
               
                <!-- fieldsets -->
        <fieldset>
            <h2 class="fs-title">Product Details</h2>
            <div class="row">
                <div class="col-6">
                    <label for="inputProductName">Product Name</label>
                    <input type="text" class="form-control" placeholder="Product Name" id="inputProductName" name="productName">
                </div>
               <div class="col-6">
                    <label for="inputCompanyName">Company Name</label>
                    <input type="text" class="form-control" placeholder="Company Name" id="inputCompanyName" name="companyName" />
                </div>
            </div>
            <div class="row">

                <div class="col-6">
                    <label for="inputDescription">Description</label>
                    <input type="text" class="form-control" placeholder="Description" id="inputDescription" name="description">
                </div>
                <div class="col-6">
                    <label for="inputQuantity">Quantity</label>
                    <input type="number" class="form-control" placeholder="Quantity" id="inputQuantity" name="quantity" />

                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputOriginalPrice">Original Price</label>
                    <input type="number" class="form-control" placeholder="Original Price" id="inputOriginalPrice" name="originalPrice" />

                </div>

                <div class="col-6">
                    <label for="inputOfferPrice">Offer Price</label>
                    <input type="number" class="form-control" placeholder="Offer Price" id="inputOfferPrice" name="offerPrice" />

                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputOfferTillDate">Offer Till Date</label>
                    <input type="date" class="form-control" placeholder="Offer-Date" id="inputOfferTillDate" name="inputOfferTillDate" />
                </div>
                <div class="col-6">
                    <label for="inputImage">Image Path</label>
                   <input type="file" class="form-control" placeholder="Input" id="inputImage" name="input" style="padding: 3.5px 3px;"/>  
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <label for="inputCategory">Category</label>
					<select class="form-control" id="questions" name="category" onchange="getdata()">
                        <option value="-1">Please select category ?</option>
                    </select>
                </div>
                <div class="col-6">
                    <label for="inputsubCategory">Sub-Category</label>
					<select class="form-control" id="questions" name="subCategory" onchange="getdata()">
                        <option value="-1">Please select sub category?</option>
                    </select>
                </div>
            </div>
            
            <br>
            <input type="submit" name="submit" class="btn btn-success success action-button" value="Submit" />
        </fieldset>
       
           
    </form>

</body>

</html>

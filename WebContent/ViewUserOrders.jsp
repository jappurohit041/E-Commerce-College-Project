<%@page import="com.dao.OrderDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.OrderShowCaseDao"%>
<%@page import="com.bean.OrderShowCaseBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous"><link href="fontawesome/css/font-awesome.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
<link href="headercss.css" rel="stylesheet"/>
<link href="cartdisplay.css" rel="stylesheet"/>

<title>View Orders</title>
</head>
<body>
	<%@include file="Header.jsp" %>

	<%ArrayList<OrderShowCaseBean> list = OrderShowCaseDao.getAllOrderDetailByUserID(mainUser.getUserID());%>

<div class="container-fluid" style="margin-bottom: 250px;">
	 
		<div class="content" style="z-index: -1">
			<p style="display: none" id='con'>${msg}</p>
			<%if(list.size()!=0){ %>
			 <div class="container">
      			<section class="mt-5 mb-4">
      			<div class="row">
      				<div class="col-4">
      						<h4><strong>Previous Order of <%=mainUser.getFirstName() %></strong></h4>		
      				</div>
      				<div class="col-4">
      					<div class="text-primary"><h4>Total Discount Availed : <%=OrderDao.totalSavingDoneByUser(mainUser.getUserID()) %></h4>
      					</div>
      				</div>
      				<div class="col-4" style="float: right;">
      					<div class="text-success"><h4>Website Discount Percentage : <%=String.format("%.2f",OrderDao.totalSavingDoneByUser(mainUser.getUserID())/OrderDao.totalSavingDoneByWebSite())%>%</h4>
      					</div>
      				</div>
      			
      			</div>
      			  <div class="row">
          			<div class="col-lg-12">
            			<div class="card wish-list mb-4">
              				<div class="card-body">
                				<h5 class="mb-4">Previous Order (<span><%=list.size() %></span> items)</h5>
                				<%for(OrderShowCaseBean c: list){ %>
                <div class="row mb-4">
                  <div class="col-md-5 col-lg-3 col-xl-3">
                    <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                      <img class="img-fluid w-100" src="<%=c.getImagePath() %>" alt="Sample">
                    </div>
                  </div>
                  <div class="col-md-7 col-lg-9 col-xl-9">
                    <div>
                      <div class="d-flex justify-content-between">
                        <div>
                          <a href="DetailProductServlet?productID=<%=c.getProductID()%>" style="text-decoration: none;"><h5><%=c.getProductName() %></h5></a>
                          <p class="mb-3 text-muted text-uppercase small">Product Description : <%=c.getProductDescription() %></p>
                          <p class="mb-3 text-muted text-uppercase small">Order ID : <%=c.getOrderID() %></p> 
                          <p class="mb-3 text-muted text-uppercase small">Payment Mode : <%=c.getPaymentType()==0?"Cash On Delivery" : c.getPaymentType()==1? "Net-Banking" : "Debit or Credit Card"%></p> 
                          <p class="mb-3 text-uppercase small"><strong>Order Date : <%=c.getOrderDate() %></strong></p>
                          <p class="mb-3  text-uppercase small"><strong>Delivery Date : <%=c.getDeliveryDate() %></strong></p>
                          <p class="mb-3 text-uppercase small"><strong>Offer Price : Rs. <%=c.getPrice() %></strong></p>
                          <p class="mb-3 text-uppercase small"><strong>Discount Availed: Rs. <%=(c.getQuantity()*c.getOrignalPrice())-c.getAmount() %> </strong></p>
                        
                          <p class="mb-3 text-uppercase small"><strong>Total Price Without Tax: Rs. <%=c.getAmount() %></strong></p>
                       	  <p class="mb-3 text-uppercase small"><strong>Total Price With Tax: Rs. <%=(c.getAmount()*0.18)+c.getAmount() %></strong></p>
                       	  <p class="mb-3 text-uppercase small"><strong>Delivery Status : <%=c.getDeliveryStatus()==0? "Not-Delivered" : "Delivered" %></strong></p>
                       	
                        </div>
                        <div>
                          <div class="def-number-input number-input safari_only mb-0 w-100">
                            <p class="mb-3 text-muted text-uppercase small"><strong>Final Quantity: <%=c.getQuantity()%></strong></p>
                         </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <hr>
                   <%} %>       
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
	<%} %>
	<%if(list.size()==0){ %>
	<img src="images\nothing.png" class="img-fluid" style="height: 650px;display: block; margin-left: auto; margin-right: auto;margin-top: 120px;">
	<%} %>
</div>

</div>
<%@include file="Footer.jsp"%>
</body>
</html>
<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.CartDetailBean"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">

    <style>
        .number-input input[type="number"] {
            -webkit-appearance: textfield;
            -moz-appearance: textfield;
            appearance: textfield;
        }

        .number-input input[type=number]::-webkit-inner-spin-button,
        .number-input input[type=number]::-webkit-outer-spin-button {
            -webkit-appearance: none;
        }

        .number-input {
            display: flex;
            justify-content: space-around;
            align-items: center;
        }

            .number-input button {
                -webkit-appearance: none;
                background-color: transparent;
                border: none;
                align-items: center;
                justify-content: center;
                cursor: pointer;
                margin: 0;
                position: relative;
            }

                .number-input button:before,
                .number-input button:after {
                    display: inline-block;
                    position: absolute;
                    content: '';
                    height: 2px;
                    transform: translate(-50%, -50%);
                }

                .number-input button.plus:after {
                    transform: translate(-50%, -50%) rotate(90deg);
                    border: none;
                }

            .number-input input[type=number] {
                text-align: center;
            }

            .number-input.number-input {
                border: 1px solid #ced4da;
                width: 10rem;
                border-radius: .25rem;
                border: none;
            }

                .number-input.number-input button {
                    width: 2.6rem;
                    height: .7rem;
                    border: none;
                }

                    .number-input.number-input button.minus {
                        padding-left: 10px;
                        border: none;
                    }

                    .number-input.number-input button:before,
                    .number-input.number-input button:after {
                        width: .7rem;
                        background-color: #495057;
                        border: none;
                    }

                .number-input.number-input input[type=number] {
                    max-width: 4rem;
                    padding: .5rem;
                    border: 1px solid #ced4da;
                    font-size: 1rem;
                    height: 2rem;
                    color: #495057;
                    border: none;
                }


        .view {
            position: relative;
            overflow: hidden;
            cursor: default;
        }
        .waves-effect {
            position: relative;
            overflow: hidden;
            cursor: pointer;
            user-select: none
        }

            .waves-effect .waves-ripple {
                position: absolute;
                width: 100px;
                height: 100px;
                margin-top: -50px;
                margin-left: -50px;
                pointer-events: none;
                background: rgba(0,0,0,.2);
                background: radial-gradient(rgba(0,0,0,.2) 0,rgba(0,0,0,.3) 40%,rgba(0,0,0,.4) 50%,rgba(0,0,0,.5) 60%,rgba(255,255,255,0) 70%);
                border-radius: 50%;
                opacity: 0;
                -webkit-transition: all .5s ease-out;
                transition: all .5s ease-out;
                -webkit-transform: scale(0) translate(0,0);
                transform: scale(0) translate(0,0)
            }

            .waves-effect.waves-light .waves-ripple {
                background: rgba(255,255,255,.4);
                background: radial-gradient(rgba(255,255,255,.2) 0,rgba(255,255,255,.3) 40%,rgba(255,255,255,.4) 50%,rgba(255,255,255,.5) 60%,rgba(255,255,255,0) 70%)
            }

            .waves-effect.waves-classic .waves-ripple {
                background: rgba(0,0,0,.2)
            }

            .waves-effect.waves-classic.waves-light .waves-ripple {
                background: rgba(255,255,255,.4)
            }

        .waves-notransition {
            -webkit-transition: none !important;
            transition: none !important
        }

        .waves-button, .waves-circle {
            -webkit-transform: translateZ(0);
            transform: translateZ(0);
            -webkit-mask-image: -webkit-radial-gradient(circle,#fff 100%,#000 100%)
        }

            .waves-button, .waves-button-input, .waves-button:hover, .waves-button:visited {
                z-index: 1;
                font-size: 1em;
                line-height: 1em;
                color: inherit;
                text-align: center;
                text-decoration: none;
                white-space: nowrap;
                vertical-align: middle;
                cursor: pointer;
                background-color: rgba(0,0,0,0);
                border: none;
                outline: 0
            }

        .waves-button {
            padding: .85em 1.1em;
            border-radius: .2em
        }

        .waves-button-input {
            padding: .85em 1.1em;
            margin: 0
        }

        .waves-input-wrapper {
            position: relative;
            display: inline-block;
            vertical-align: middle;
            border-radius: .2em
        }

        .dropdown-submenu:hover > .dropdown-menu, .navbar .nav-item .nav-link, .waves-block {
            display: block
        }

        .waves-input-wrapper.waves-button {
            padding: 0
        }

        .waves-input-wrapper .waves-button-input {
            position: relative;
            top: 0;
            left: 0;
            z-index: 1
        }

        .waves-circle {
            width: 2.5em;
            height: 2.5em;
            line-height: 2.5em;
            text-align: center;
            border-radius: 50%
        }

        .waves-float {
            -webkit-mask-image: none;
            -webkit-box-shadow: 0 1px 1.5px 1px rgba(0,0,0,.12);
            box-shadow: 0 1px 1.5px 1px rgba(0,0,0,.12);
            -webkit-transition: all .3s;
            transition: all .3s
        }

            .waves-float:active {
                -webkit-box-shadow: 0 8px 20px 1px rgba(0,0,0,.3);
                box-shadow: 0 8px 20px 1px rgba(0,0,0,.3)
            }

        a.waves-effect, a.waves-light {
            display: inline-block
        }
        .zoom img, .zoom video {
            -webkit-transition: all .2s linear;
            transition: all .2s linear
        }

        .zoom:hover img, .zoom:hover video {
            -webkit-transform: scale(5);
            transform: scale(1.5);
        }



    </style>
</head>
<body>
	<div class="Header" style="z-index: +10">
	<%@include file="Header.jsp"%>
 	<%ArrayList<CartDetailBean> list = (ArrayList<CartDetailBean>) CartDao.getListOfCart(mainUser.getUserID()); %> 
 	<%float totalPrice = 0; %>
	</div>
	<div class="container-fluid">
		<div class="content" style="z-index: -1">
				            				<p style="display: none" id='con'>${msg}</p>
			<%if(list.size()!=0){ %>
			 <div class="container">
      			<section class="mt-5 mb-4">
      			  <div class="row">
          			<div class="col-lg-8">
            			<div class="card wish-list mb-4">
              				<div class="card-body">
                				<h5 class="mb-4">Cart (<span><%=list.size() %></span> items)</h5>
                				<%for(CartDetailBean c: list){ %>
                <div class="row mb-4">
                  <div class="col-md-5 col-lg-3 col-xl-3">
                    <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                      <img class="img-fluid w-100" src="<%=c.getImgPath() %>" alt="Sample">
                    </div>
                  </div>
                  <div class="col-md-7 col-lg-9 col-xl-9">
                    <div>
                      <div class="d-flex justify-content-between">
                        <div>
                          <a href="DetailProductServlet?productID=<%=c.getProductID()%>" style="text-decoration: none;"><h5><%=c.getProductName() %></h5></a>
                          <p class="mb-3 text-muted text-uppercase small">Product Description : <%=c.getProductDescription() %></p>
                          <p class="mb-3 text-muted text-uppercase small">Company Name : <%=c.getCompanyName() %></p>
                          <p class="mb-3 text-muted text-uppercase small"><strong>Offer Till : <%=c.getOfferTill().substring(0, 10)%></strong></p>
                          <p class="mb-3 text-muted text-uppercase small"><strong>Original Price: <%=c.getOrignalPrice()%></strong></p>
                          <p class="mb-3 text-muted text-uppercase small"><strong>Discount Price: <%=c.getOfferPrice()%></strong></p>
                       
                        </div>
                        <div>
                          <div class="def-number-input number-input safari_only mb-0 w-100">
                            <a href="ChangeQuantityServlet?userID=<%=mainUser.getUserID()%>&productID=<%=c.getProductID()%>&operation=minus&quantity=<%=c.getQuantity()%>" class="btn btn-outline-danger" style="margin-right: 1px;">-</a>
                            <input class="quantity" min="1" id = "quantity" name="quantity" value="<%=c.getQuantity()%>" type="number" disabled>
                            <a href="ChangeQuantityServlet?userID=<%=mainUser.getUserID()%>&productID=<%=c.getProductID()%>&operation=plus&quantity=<%=c.getQuantity()%>" class="btn btn-outline-primary" style="margin-left: 1px;">+</a>
                          </div>
                          <small id="passwordHelpBlock" class="form-text text-muted text-center">
                            (Note, 1 piece)
                          </small>
                        </div>
                      </div>
                      <div class="d-flex justify-content-between align-items-center">
                        <div>
                          <a href="RemoveFromCartServlet?cartID=<%=c.getCartID()%>&userID=<%=mainUser.getUserID() %>" type="button" class="card-link-secondary small text-uppercase mr-3"><i
                              class="fas fa-trash-alt mr-1"></i> Remove item </a>
                          <a href="BuyNowCartServlet?cartID=<%=c.getCartID()%>&fullCart=false&userID=<%=mainUser.getUserID() %>" type="button" class="card-link-secondary small text-uppercase"><i
                              class="fas fa-shopping-cart"></i>Order This Now </a>
                        </div>
                        <%totalPrice = totalPrice + c.getPrice(); %>
                        <p class="mb-0"><span><strong>Total Price Rs. <%=c.getPrice()%></strong></span></p>
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="mb-4">
                   <%} %>  
               
                <p class="text-primary mb-0"><i class="fas fa-info-circle mr-1"></i> Do not delay the purchase, adding
                  items to your cart does not mean booking them.</p>
                  <p class="text-primary mb-0"><i class="fas fa-info-circle mr-1"></i> Some Products might have been removed due to price change or offer end
                  </p>
              </div>
            </div>
            <div class="card mb-4">
              <div class="card-body">
                <h5 class="mb-4">Expected shipping delivery</h5>
                <p class="mb-0">5 to 7 Business-Working Days</p>
              </div>
            </div>
          </div>
          
          <div class="col-lg-4">
            <div class="card mb-4">
              <div class="card-body">
                <h5 class="mb-3">The total amount of</h5>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                    Before Tax Total Amount
                    <span>Rs. <%=totalPrice %></span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                    <div>
                      <strong>The total amount of</strong>
                      <strong>
                        <p class="mb-0">(including GST)</p>
                      </strong>
                    </div>
                    <%totalPrice = (float)totalPrice+ totalPrice*0.18f; %>
                    <span><strong>Rs. <%=totalPrice %></strong></span>
                  </li>
                </ul>
                <a href="BuyNowCartServlet?cartID=&fullCart=true&userID=<%=mainUser.getUserID()%>" class="btn btn-primary btn-block waves-effect waves-light">Go To Checkout </a>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
    <%} %>
		</div>
	</div>
			 	<%if(list.size()==0){ %>

				<img src="images\emptycart6.jpg" class="img-fluid" style="height: 650px;display: block; margin-left: auto; margin-right: auto; width: 100%;margin-bottom: 120px;margin-top: 120px;">
			<% }%> 
	<%@include file="Footer.jsp" %>
	
</body>
</html>
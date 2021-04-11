<%@page import="com.bean.ProductDetailBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.carousel-control-prev-icon,
.carousel-control-next-icon {
  height: 100px;
  width: 100px;
  outline: black;
  background-size: 100%, 100%;
  background-image: none;
  background: black;
  background-color: black;
}
.gif{

}

@KeyFrame gifInfinite {
	0% {}
	100% {}
}
</style>

</head>
<body style="margin: 0px;">
<section>

  <!--Carousel Wrapper-->
  <div id="carousel-example-2" class="carousel slide carousel-fade" data-ride="carousel" style="margin-bottom: 50px; margin-top: 50px; z-index: +1;">
    <!--Indicators-->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-2" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-2" data-slide-to="1"></li>
      <li data-target="#carousel-example-2" data-slide-to="2"></li>
      <li data-target="#carousel-example-2" data-slide-to="3"></li>
      <li data-target="#carousel-example-2" data-slide-to="4"></li>
    </ol>
    <!--/Indicators-->
    <!--Slides-->
    <%ArrayList<ProductDetailBean> p = ProductDao.getTopSellingProducts(); %>
    <div class="carousel-inner" role="listbox">
      <div class="carousel-item active">
        <div class="view">
          <img class="d-block w-100" src="<%=p.get(0).getImagePath()%>"
            alt="First slide" width="200%" height="500px">
          <a href="#!">
            <div class="mask rgba-black-light"></div>
          </a>
        </div>
        <div class="carousel-caption">
          <h3 class="h3-responsive" style="color: black;"><%=p.get(0).getProductName() %></h3>
          <p style="color: black;"><%=p.get(0).getProductDescription() %></p>
        </div>
    </div>
    <div class="carousel-item">
        <!--Mask color-->
        <div class="view">
          <img class="d-block w-100" src="<%=p.get(1).getImagePath() %>"
            alt="Second slide" width="100%" height="500px">
          <a href="#!">
            <div class="mask rgba-black-light"></div>
          </a>
        </div>
        <div class="carousel-caption">
          <h3 class="h3-responsive"  style="color: black;"><%=p.get(1).getProductName() %></h3>
          <p  style="color: black;"><%=p.get(1).getProductDescription() %></p>
        </div>
    </div>
    <div class="carousel-item">
        <!--Mask color-->
        <div class="view">
          <img src="<%=p.get(2).getImagePath() %>" 
          width="100%" height="500px">
                <a href="#!">
            <div class="mask rgba-black-light"></div>
          </a>
        </div>
        <div class="carousel-caption">
          <h3 class="h3-responsive"  style="color: black;"><%=p.get(2).getProductName() %></h3>
          <p  style="color: black;"><%=p.get(2).getProductDescription() %></p>
        </div>
    </div>
    <div class="carousel-item">
        <!--Mask color-->
        <div class="view">
          <img src="<%=p.get(3).getImagePath() %>" 
          width="100%" height="500px" loop=infinte>
                <a href="#!">
            <div class="mask rgba-black-light"></div>
          </a>
        </div>
        <div class="carousel-caption">
          <h3 class="h3-responsive"  style="color: black;"><%=p.get(3).getProductName() %></h3>
          <p  style="color: black;"><%=p.get(3).getProductDescription() %></p>
        </div>
    </div>
 	<div class="carousel-item">
        <!--Mask color-->
        <div class="view">
          <img src="<%=p.get(4).getImagePath() %>" 
          width="100%" height="500px" loop=infinte>
                <a href="#!">
            <div class="mask rgba-black-light"></div>
          </a>
        </div>
        <div class="carousel-caption">
          <h3 class="h3-responsive"  style="color: black;"><%=p.get(4).getProductName() %></h3>
          <p  style="color: black;"><%=p.get(4).getProductDescription() %></p>
        </div>
      </div>
    </div>
    <!--/Slides-->
    <!--Controls-->
    <a class="carousel-control-prev" href="#carousel-example-2" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel-example-2" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
    <!--/Controls-->
  </div>
  <!--/Carousel Wrapper-->

</section>
<!--Section: Block Content-->
</body>
</html>
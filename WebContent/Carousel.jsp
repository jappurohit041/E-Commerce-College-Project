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


</style>
</head>
<body>
<!-- <div  id="page-hero" class="carousel slide" data-bs-ride="carousel" style="margin-bottom: 50px; margin-top: 50px;">
    <ul class="carousel-indicators">
        <li data-bs-target="#page-hero" data-bs-slide-to='0' class="active bg-dark" ></li>
        <li data-bs-target="#page-hero" data-bs-slide-to='1' class="bg-dark"></li>
        <li data-bs-target="#page-hero" data-bs-slide-to='2' class="bg-dark"></li>
        <li data-bs-target="#page-hero" data-bs-slide-to='3' class="bg-dark"></li>
    </ul>
        <div class="carousel-inner">
            <div class="carousel-item  active">
                <img src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/4/1/e3db6c65-045e-4ab8-b0b6-cd847dfa03311617290551429-USPA_Kids_Desk_Banner.jpg" width="100%" height="400px">
            </div>
            <div class="carousel-item">
                <img src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/4/1/1a5ab5a0-dea6-4c68-a80a-79ec0efdae451617290551412-Biba_Desk_Banner.jpg" width="100%" height="400px">
            </div>
            <div class="carousel-item">
                <img src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/4/1/cecf7580-8d0b-4040-b9b6-1edec8f5dea01617290551366-Personal-Care_Desk.jpg" width="100%" height="400px">
            </div>
            <div class="carousel-item">
                <img src="https://cms.bigbazaarstore.com/cms/model/HFD/EIe/Cun6/1Dailyfavourites.jpg" width="100%" height="400px">
            </div>
        </div>
        <a class="carousel-control-prev" href="#page-hero" data-bs-slide="prev">
            <span class="carousel-control-prev-icon bg-dark text-dark"  style="padding: 30px; border-radius: 10px;"></span>
        </a>
        <a class="carousel-control-next" href="#page-hero" data-bs-slide="next">
            <span class="carousel-control-next-icon bg-dark text-dark" style="padding: 30px; border-radius: 10px;"></span>
        </a>
    </div> -->
    <!--Section: Block Content-->
<section>

  <!--Carousel Wrapper-->
  <div id="carousel-example-2" class="carousel slide carousel-fade" data-ride="carousel" style="margin-bottom: 50px; margin-top: 50px; z-index: +1;">
    <!--Indicators-->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-2" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-2" data-slide-to="1"></li>
      <li data-target="#carousel-example-2" data-slide-to="2"></li>
    </ol>
    <!--/Indicators-->
    <!--Slides-->
    <div class="carousel-inner" role="listbox">
      <div class="carousel-item active">
        <div class="view">
          <img class="d-block w-100" src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/4/1/e3db6c65-045e-4ab8-b0b6-cd847dfa03311617290551429-USPA_Kids_Desk_Banner.jpg"
            alt="First slide" width="100%" height="500px">
          <a href="#!">
            <div class="mask rgba-black-light"></div>
          </a>
        </div>
        <div class="carousel-caption">
          <h3 class="h3-responsive">First shop item</h3>
          <p>First text</p>
        </div>
      </div>
      <div class="carousel-item">
        <!--Mask color-->
        <div class="view">
          <img class="d-block w-100" src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/4/1/1a5ab5a0-dea6-4c68-a80a-79ec0efdae451617290551412-Biba_Desk_Banner.jpg"
            alt="Second slide" width="100%" height="500px">
          <a href="#!">
            <div class="mask rgba-black-light"></div>
          </a>
        </div>
        <div class="carousel-caption">
          <h3 class="h3-responsive">Second shop item</h3>
          <p>Secondary text</p>
        </div>
      </div>
      <div class="carousel-item">
        <!--Mask color-->
        <div class="view">
          <img src="https://assets.myntassets.com/f_webp,w_980,c_limit,fl_progressive,dpr_2.0/assets/images/2021/4/1/cecf7580-8d0b-4040-b9b6-1edec8f5dea01617290551366-Personal-Care_Desk.jpg" 
          width="100%" height="500px">
                <a href="#!">
            <div class="mask rgba-black-light"></div>
          </a>
        </div>
        <div class="carousel-caption">
          <h3 class="h3-responsive">Third shop item</h3>
          <p>Third text</p>
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
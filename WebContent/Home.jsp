<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link href="fontawesome/css/font-awesome.css" rel="stylesheet">
    <title>Document</title>
<style>
    .LoginButton{
        border: solid 1px White;
        background-color: WHITE;
        text-transform: uppercase;
        text-decoration: none;
        text-align: center;
        padding-top: 3PX;
        padding-bottom: 3PX;
        margin-top: 10px;

        color: black;
    }
    .HeaderIcons{
        margin-top: 10px;
        margin-left: 8px;
        text-align:right;
        color: white;
        font-size: 25px;
    }
    .HeaderIconsLabel
    {
        color: white;
        text-transform: uppercase;
        margin-right: 10px;
    }
    .HeaderIconsLabel:hover , .HeaderIcons:hover{
        color: rgb(212, 212, 253);
    }
    .searchForm
    {
        margin-top: 10px;
        text-align: right;
    }
    .searchHover{
        color: blue;
        background-color: white;
        font-weight: bold;
        margin-left: -6px;
        padding-top: 3px;
        padding-right: 10px;
        padding-bottom: 4px;
    }
    .searchHover:hover{
        border: snow solid 0.5px;
        padding: 5px;
        color: white;
    }
    /* Dropdown Button */
.dropbtn {
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
    left: -60PX;
    top: 25PX;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
.btn , .btn-secondary
{
    background-color: transparent;
    color: white;
    border: transparent;
}
.btn:hover , .btn-secondary:hover
{
    background-color: transparent;
    border: transparent;
    color: white;
}
/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #ddd;}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {display: block;}

 .footerHeader
    {
        font-size: medium;
        text-transform: uppercase;
        color: grey;
        margin-bottom: 5px;
    }
    .footerBackground
    {
        font-size: small;
        padding: 20px;
        text-align: center;
        background-color: rgb(39, 28, 56);
        color: cornsilk;
    }
    .vlLeft
    {
        border-left: 1px solid white;
        height: fit-content;
    }
</style>
</head>
<body>
    <header class="bg-primary container-fluid ">
        <div class="row">
            <div class="col-1">
                <img  src="images/BlueColorLogoWhiteFont.jpg" alt="White BigDeal Main Logo">
            </div>
            <div class="col-6">
                <form class="searchForm">
                    <input type="text" placeholder="Search for ProductsName and More" style="width: 270px;">
                    <a href="#" class="searchHover"><i class="fa fa-search"></i></a>
                </form>
            </div>
            <div class="col-2"></div>
            <div class="col-1">
                <a href="#"><i data-toggle="tooltip" data-placement="bottom" title="Cart" class="btn btn-secondary HeaderIcons fa fa-shopping-cart"></i></a>
            </div>
            <div class="col-2 ">
                <div class="LoginButton">
                    <div class="dropdown">
                        <a href="" class="dropbtn" style=" text-decoration: none;">Login</a>
                        <div class="dropdown-content">
                            <a>sfgsfgs</a>
                            <a>sfgsfgs</a>
                            <a>sfgsfgs</a>
                            <a>sfgsfgs</a>
                            <a>sfgsfgs</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    
    <br><br><br><br><br>

    <footer class="row footerBackground">
        <div class="col-6">
            <div class="row">
              <div class="col-3">
                <div class="footerHeader">About</div>
                <a class="link-light" href="#">Contact US</a><br>    
                <a class="link-light" href="#">About Us</a><br>    
               </div>
                <div class="col-3">
                    <div class="footerHeader">Help</div>
                        <a class="link-light" href="#">Payment</a><br>    
                        <a class="link-light" href="#">Shiping</a><bR>    
                </div> 
                <div class="col-3">
                    <div class="footerHeader">Policy</div>
                        <a class="link-light" href="#">Security</a><br>    
                        <a class="link-light" href="#">Privacy</a><br>    
                </div>
                <div class="col-3">
                    <div class="footerHeader">Socials</div>
                    <a class="link-light" href="#">FaceBook</a><br>    
                    <a class="link-light" href="#">Twitter</a><br>    
                    <a class="link-light" href="#">Youtube</a><br>    
           </div>
            </div>
            <img src="https://static-assets-web.flixcart.com/www/linchpin/fk-cp-zion/img/payment-method_7934bc.svg" alt="" style="margin-top: 70px; width: 410px;">
        </div>
       <!--ubhi liti-->
       <div class="col-6 vlLeft">
            <div class="row">
                    <div class="col-6">
                    <div class="footerHeader">Mail us : </div>
                    <p>Flipkart Internet Private Limited,

                        Buildings Alyssa, Begonia &
                        
                        Clove Embassy Tech Village,
                        
                        Outer Ring Road, Devarabeesanahalli Village,
                        
                        Bengaluru, 560103,
                        
                        Karnataka, India</p>
                    </div>
                <div class="col-6">
                    <div class="footerHeader">Registered Office Address : </div>
                    <p>Flipkart Internet Private Limited,

                        Buildings Alyssa, Begonia &
                        
                        Clove Embassy Tech Village,
                        
                        Outer Ring Road, Devarabeesanahalli Village,
                        
                        Bengaluru, 560103,
                        
                        Karnataka, India
                        <br>
                        CIN : U51109KA2012PTC066107
                        
                        Telephone: 1800 202 9898</p>
                </div>
            </div>
        </div>
        <hr style="margin-top: 15px;">
        <section style="font-size: 20px;">
            <div class="row">
                <div class="col-8">
                    <div class="row">
                        <div class="col-2">
                            <i class="fa fa-instagram"></i>
                        </div>
                        <div class="col-2">
                            <i class="fa fa-facebook-f"></i>
                        </div>
                        <div class="col-2">
                            <i class="fa fa-twitter"></i>
                        </div>
                        <div class="col-2">
                            <i class="fa fa-whatsapp"></i>
                        </div>
                        <div class="col-2">
                            <i class="fa fa-linkedin"></i>
                        </div>
                        <div class="col-2">
                            <i class="fa fa-youtube"></i>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="vlLeft" style="font-size: small; padding: 10px;">
                        &copy;CompanyName 2020-21 CompanyName.com
                    </div>
                </div>
            </div>
        </section>
    </footer>
</body>
</html>
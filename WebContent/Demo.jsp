<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<head>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300i,400" rel="stylesheet">
</head>
<style>
@import url('https://fonts.googleapis.com/css?family=Lato:400,700');
$font: 'Lato', sans-serif;

$white: #F5F5F5;
$light: #E0C9CB;
$tan: #C3A1A0;
$pink: #D9AAB7;
$rose: #BA7E7E;
$dark: #4E4E4E;

/* center container in the middle */
html {
  display: grid;
  min-height: 100%;
}

body {
  display: grid;
  background: $light;
  font-family: $font, sans-serif;
  text-transform: uppercase;
}

.container {
  position: relative;
  margin: auto;
  overflow: hidden;
  width: 520px;
  height: 350px;
  background: $white;
  box-shadow: 5px 5px 15px rgba($rose, .5);
  border-radius: 10px;
}

p {
  font-size: 0.6em;
  color: $rose;
  letter-spacing: 1px;
}

h1 {
  font-size: 1.2em;
  color: $dark;
  margin-top: -5px;
}

h2 {
  color: $tan;
  margin-top: -5px;
}

img {
  width: 290px;
  margin-top: 47px;
}

.slideshow-buttons {
  top: 70%;
  display: none;
}

.one, .two, .three, .four {
  position: absolute;
  width: 7px;
  height: 7px;
  border-radius: 50%;
  background: $light;
}

.one {
  left: 22%;
}
.two {
  left: 27%;
}
.three {
  left: 32%;
}
.four {
  left: 37%;
}

.product {
  position: absolute;
  width: 40%;
  height: 100%;
  top: 10%;
  left: 60%;
}

.desc {
  text-transform: none;
  letter-spacing: 0;
  margin-bottom: 17px;
  color: $dark;
  font-size: .7em;
  line-height: 1.6em;
  margin-right: 25px;
  text-align: justify;
}

button {
  background: darken($light, 10%);
  padding: 10px;
  display: inline-block;
  outline: 0;
  border: 0;
  margin: -1px;
  border-radius: 2px;
  text-transform: uppercase;
  letter-spacing: 1px;
  color: $white;
  cursor: pointer;
  &:hover {
    background: $rose;
    transition: all .4s ease-in-out;
  }
}

.add {
  width: 67%;
}

.like {
  width: 22%;
}

.sizes {
  display: grid;
  color: $pink;
  grid-template-columns: repeat(auto-fill, 30px);
  width: 60%;
  grid-gap: 4px;
  margin-left: 20px;
  margin-top: 5px;
  &:hover {
    cursor: pointer;
  }
}

.pick {
  margin-top: 11px;
  margin-bottom:0;
  margin-left: 20px;
}

.size {
  padding: 9px;
  border: 1px solid $light;
  font-size: 0.7em;
  text-align: center;
  &:hover{
    background: $rose;
    color: $white;
    transition: all .4s ease-in-out;
  }
}

.focus{
  background: $rose;
  color: $white;
}

footer {
  position: absolute;
  bottom: 0;
  right: 0;
  font-size: 0.8em;
  text-transform: uppercase;
  padding: 10px;
  p {
    letter-spacing: 3px;
  }
  a {
    color: #ffffff;
    text-decoration: none;
    &:hover {
      color: #7d7d7d;
    }
  }
}
</style>
<body>

<div class="container">
  <div class="images">
    <img src="http://mistillas.cl/wp-content/uploads/2018/04/Nike-Epic-React-Flyknit-%E2%80%9CPearl-Pink%E2%80%9D-01.jpg" />
  </div>
  <div class="slideshow-buttons">
    <div class="one"></div>
    <div class="two"></div>
    <div class="three"></div>
    <div class="four"></div>
  </div>
  <p class="pick">choose size</p>
  <div class="sizes">
    <div class="size">5</div>
    <div class="size">6</div>
    <div class="size">7</div>
    <div class="size">8</div>
    <div class="size">9</div>
    <div class="size">10</div>
    <div class="size">11</div>
    <div class="size">12</div>
  </div>
  <div class="product">
    <p>Women's Running Shoe</p>
    <h1>Nike Epic React Flyknit</h1>
    <h2>$150</h2>
    <p class="desc">The Nike Epic React Flyknit foam cushioning is responsive yet light-weight, durable yet soft. This creates a sensation that not only enhances the feeling of moving forward, but makes running feel fun, too.</p>
  </div>
</div>

<footer>
  <p>made by <a href="https://codepen.io/juliepark"> julie</a> ♡
</footer>
</body>
</body>
</html>
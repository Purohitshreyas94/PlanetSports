<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url  var="css" value="/resources/css" />
<spring:url  var="js" value="/resources/js" />
<spring:url  var="images" value="/resources/images" />


<html lang="en">
<head>
 
  <title>Planet Sports</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${css}/bootstrap.css">
  <link rel="stylesheet" href="${css}/stylesheet.css">
  <link rel="stylesheet" href="${css}/font-awesome.min.css">
  
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  
  <script src="${js}/jquery.min.js"></script>
   <script src="${js}/jquery.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
  
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<!--NavBar Code -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="index">PLANET SPORTS</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="index">Home</a></li>
        <li><a href="about.jsp">About</a></li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Running</a></li>
            <li><a href="#">Cricket</a></li>
            <li><a href="#">Football</a></li> 
			<li><a href="#">Tennis</a></li> 
          </ul>
        </li>
        <li><a href="#">Products</a></li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="signup.jsp">Sign Up</a></li>
            <li><a href="login.jsp">Login</a></li>
            
          </ul>
        </li>
        <li><a href="contact.jsp">Contact</a></li>
		
        
      </ul>
    </div>
  </div>
</nav>

<!-- NavBar End -->

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="${images}/sports-banner.jpg" alt="Sports"  >
        <div class="carousel-caption">
          <h3>Planet Sports</h3>
          <p>One Stop Solution for all your sport needs.</p>
        </div>      
      </div>

      <div class="item">
        <img src="${images}/sports-banner-2.jpg" alt="Sports" width="1200" height="700">
        <div class="carousel-caption">
          <h3>GAME</h3>
          <p>Go get your GAME on with PLANET SPORTS</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="${images}/sports-banner-3.jpg" alt="Los Angeles" width="1200" height="700">
        <div class="carousel-caption">
          <h3>SPORT</h3>
          <p>Sport is not just a word , it is an emotion for players.</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="fa fa-arrow-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="fa fa-arrow-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<!-- Container (The Band Section) -->
<div id="band" class="container text-center">
  <h3>PLANET SPORTS</h3>
  <p><em>Go get your Game on!</em></p>
  
					
					 <p>At Planet Sports, we place innovation at the heart of our activities: from research to retail, including design, production and logistics. Our twenty Passion Brand teams channel all their energy in to developing technical, good-looking and simple products, always at the lowest possible prices. These products are aimed at all sports enthusiasts, from beginners to experts, and are sold exclusively at Planet Sports.<br> <a href="about.jsp">Read More</a></p>
  <br>
  <!--<div class="row">
    <div class="col-sm-4">
      <p class="text-center"><strong>Name</strong></p><br>
      <a href="#demo" data-toggle="collapse">
        <img src="bandmember.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo" class="collapse">
        <p>Guitarist and Lead Vocalist</p>
        <p>Loves long walks on the beach</p>
        <p>Member since 1988</p>
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>Name</strong></p><br>
      <a href="#demo2" data-toggle="collapse">
        <img src="bandmember.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo2" class="collapse">
        <p>Drummer</p>
        <p>Loves drummin'</p>
        <p>Member since 1988</p>
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>Name</strong></p><br>
      <a href="#demo3" data-toggle="collapse">
        <img src="bandmember.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
      </a>
      <div id="demo3" class="collapse">
        <p>Bass player</p>
        <p>Loves math</p>
        <p>Member since 2005</p>
      </div>
    </div>
  </div>-->
  
</div>

<!-- Container (TOUR Section) -->
<div id="tour" class="bg-1">
  <div class="container">
    <h3 class="text-center">SPORT CATEGORIES </h3>
    
    
    <div class="row text-center">
      <div class="col-sm-3">
        <div class="thumbnail">
          <img src="${images}/running-small.png" class="img-responsive"alt="Paris" >
          <p><strong>RUNNING</strong></p>
          
          <a class="btn" href="running.jsp">View Products</a>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="thumbnail">
          <img src="${images}/football-small.png" class="img-responsive"alt="Paris" >
          <p><strong>Football</strong></p>
          
          <a class="btn" href="football.jsp">View Products</a>
        </div>
      </div>
	   <div class="col-sm-3">
        <div class="thumbnail">
          <img src="${images}/women-playing-tennis.jpg" class="img-responsive"alt="Paris" >
          <p><strong>Tennis</strong></p>
          
          <a class="btn" href="tennis.jsp">View Products</a>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="thumbnail">
          <img src="${images}/cricket-bat-small.png" class="img-responsive"alt="Paris" >
          <p><strong>Cricket</strong></p>
          
          <a class="btn" href="football.jsp">View Products</a>
        </div>
      </div>
	
    </div>
  </div>
  
 
</div>

<!-- Container (Contact Section) -->

<!-- Add Google Maps -->



<!-- Footer -->
<footer >
  <div class="container-fluid">
  <div class="col-sm-6">
  &copy; Copyright by Planet Sports
  </div>
  <div class="col-sm-3">
  
  </div>
  <div class="col-sm-3">
  Project Developed by Mr. Shreyas Purohit
  </div>
</footer>

<!-- Footer Ends -->

</body>
</html>

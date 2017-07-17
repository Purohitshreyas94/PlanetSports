<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<spring:url  var="css" value="/resources/css" />
<spring:url  var="js" value="/resources/js" />
<spring:url  var="images" value="/resources/images" />


<html lang="en">
<head>
 
  <title>Planet Sports - ${title}</title>
  <script >
     window.menu= '${title}';
     
     window.contextRoot = '${contextRoot}'
     
  </script>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${css}/bootstrap.css">
  <link rel="stylesheet" href="${css}/stylesheet.css">
  <link rel="stylesheet" href="${css}/font-awesome.min.css">
  <link rel="stylesheet" href="${css}/materialize.min.css">
  
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
  <script src="${js}/jquery.min.js"></script>
   <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
  <script src="${js}/materialize.min.js"></script>
  
  
    <script src="${js}/mysport.js"></script>
  
  
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
      <a class="navbar-brand" href="${contextRoot}/index">Back to Home..</a>
    </div>
   </div>
  </nav>  
  


<!-- NavBar End -->

<!-- Container (The Band Section) -->
<div id="band" class="container text-center mt-50">
          
          <!-- This is for wrong user credentials -->
        <c:if test="${not empty message}">
               <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                      <div class = "alert alert-danger">
                           ${message}                     
                      </div> 
                   </div>
               </div>
        </c:if>
              
       
  <h5 class="text-center">LOGIN</h5>
  <p><em>Please Login to Explore Planet Sports...!</em></p>
  <br>
	
  <div class="row text-center">
	    <div class="col-md-2 col-sm-0 col-xs-0">
		</div>
		<div class="col-md-8 col-sm-12  z-depth-4 pt-30 pb-20">
			<form class="col s12" method="POST" action="${contextRoot}/login">
				<div class="row">
					<div class="input-field col s12">
					  <input id="username" name="username" type="text" class="validate"required >
					  <label for="username"  class="active">Username</label>
					</div>
				</div>
			  <div class="row">
				<div class="input-field col s12">
				  <input id="password" name="password" type="password" class="validate" required>
				  <label for="password" class="active">Password</label>
				</div>
			  </div>
			  <div class="row text-center">
				<div class="col-md-3 ">
				</div>
				<div class="input-field col-md-6  text-center">
					<input type="submit" class="btn1" value="LOG IN">
				
				</div>
				<div class="col-md-3 ">
				</div>
				
			  </div>
			</form>	
			
        </div>	
        <div class="col-md-2 col-sm-0 col-xs-0">
		</div>		
  </div>
</div>

<!-- Container (TOUR Section) -->


<!-- Container (Contact Section) -->

<!-- Add Google Maps -->



<!-- Footer Starts-->
<footer >
  <%@include file="footer.jsp" %>
</footer>
<!-- Footer Ends -->

</body>
</html>






<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<spring:url  var="css" value="/resources/css" />

<html lang="en">
<head>
 
  <title>Planet Sports - ${title}</title>
  <script >
     window.menu= '${title}';
     
     window.contextRoot = '${contextRoot}'
     
  </script>
  meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${css}/bootstrap.css">
  <link rel="stylesheet" href="${css}/dataTables.bootstrap.css">
  <link rel="stylesheet" href="${css}/stylesheet.css">
  <link rel="stylesheet" href="${css}/font-awesome.min.css">
  <link rel="stylesheet" href="${css}/materialize.min.css">
  
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
  
  <script src="${js}/jquery.min.js"></script>
   <script src="${js}/jquery.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
   <script src="${js}/jquery.dataTables.js"></script>
   <script src="${js}/dataTables.bootstrap.js"></script>
  <script src="${js}/materialize.min.js"></script>
  
  
    <script src="${js}/mysport.js"></script>
    
</head>
  <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">
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
  
       
       <div class ="content" >
            <div class = "container">
            
              <div class = "row">
                
                <div class = "col-xs-12">
                
                      <div class = "jumbotron">
                      
                         <h1>${errorTitle}</h1>
                          <hr/>
                          
                          <blockquote style="word-wrap:break-word">
                                 
                                 ${errorDescription}
                           
                          </blockquote>
                          
                          
                      </div>
                
                </div>
              
              
              
              </div>
            
            
            </div>
                
            	
       
       </div>
              <footer >
  <%@include file="footer.jsp" %>
</footer>
<!-- Footer Ends -->
              
  
 </body>
 </html>
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

<!--NavBar Code -->

<%@include file="navbar.jsp" %>


<!-- NavBar End -->

<!-- Page Content -->
<c:if test="${userClickHome ==true}">
<%@include file="home.jsp" %>

</c:if>

<!-- Load Only When user Click About -->
<c:if test="${userClickAbout == true}">
   <%@include file="about.jsp" %>
</c:if>

<!-- Load Only When user Click About -->
<c:if test="${userClickContact == true}">
   <%@include file="contact.jsp" %>
</c:if>

  
<!-- Load Only When user Click Account --> 
<c:if test="${userClickAccount == true}">
   <%@include file="account.jsp" %>
</c:if>


<!-- Load Only When user Click Signup -->
<c:if test="${userClickSignup == true}">
   <%@include file="signup.jsp" %>
</c:if>


<!-- Load Only When user Click Product or Category -->
<c:if test="${userClickProducts == true or userClickCategoryProducts == true}">
   <%@include file="listProduct.jsp" %>
</c:if>

<!-- Load Only When user Click Cart -->
<c:if test="${userClickCart == true}">
  <%@include file="cart1.jsp" %>
</c:if>

<!-- Load Only When user Click Manage Product -->
<c:if test="${userClickManageProducts == true}">
  <%@include file="manageProducts.jsp" %>
</c:if>

<!-- Load Only When user Click Manage Product -->
<c:if test="${userClickManageCategory == true}">
  <%@include file="manageCategory.jsp" %>
</c:if>


<!-- Load Only When user Click Show Product -->
<c:if test="${userClickShowProduct == true}">
  <%@include file="singleProduct.jsp" %>
</c:if>

<!-- Load Only When user Click Order -->
<c:if test="${userClickOrder == true}">
  <%@include file="Order.jsp" %>
</c:if>

<!-- Load Only When user Click Order -->
<c:if test="${userClickConfirmOrder == true}">
  <%@include file="visitagain.jsp" %>
</c:if>
<!-- Add Google Maps -->



<!-- Footer Starts-->
<footer >
  <%@include file="footer.jsp" %>
</footer>
<!-- Footer Ends -->

</body>
</html>

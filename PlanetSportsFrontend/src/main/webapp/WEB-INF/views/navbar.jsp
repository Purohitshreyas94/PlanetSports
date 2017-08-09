<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<nav class="navbar navbar-default navbar-fixed-top">
<div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${contextRoot}/index">PLANET SPORTS</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="${contextRoot}/index">Home</a></li>
        
        <security:authorize access="isAnonymous()">
       <li id="about"><a href="${contextRoot}/about">About</a></li>   
		</security:authorize>
		
		<security:authorize access="hasAuthority('USER')">
		<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>
		</security:authorize>
		
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <c:forEach items="${list}" var="category">
                <li><a href="${contextRoot}/show/category/${category.catid}/products" id="a_${category.catname}">${category.catname}</a></li>
          </c:forEach>
          </ul>
        </li>
        <li id=listProduct><a href="${contextRoot}/show/all/products">Products</a></li>
       
		<li>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<a href="">Hello ${pageContext.request.userPrincipal.name }</a>
			</c:if>
		</li>
		
		<security:authorize access="hasAuthority('USER')">
       <li id="cart"><a href="${contextRoot}/cart/getcart"><i class="material-icons">shopping_cart</i></a></li> 
      	</security:authorize>
		
	
		<ul class="nav navbar-nav navbar-right">
		<c:if test="${pageContext.request.userPrincipal.name==null }">
		<li id=myaccount class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li id=signup><a href="${contextRoot}/register/user">Sign Up</a></li>
            <li id=login><a href="${contextRoot}/login">Login</a></li>
          </ul>
        </li>
       </c:if> 
        
        <c:if test="${pageContext.request.userPrincipal.name!=null }">
        <li id=logout><a href="${contextRoot}/j_spring_security_logout">Logout</a></li>
        </c:if>
        </ul>
        
        
      
          <c:if test="${pageContext.request.userPrincipal.name!=null }">
          <security:authorize access="hasAuthority('ADMIN')">
        <li id="manageProducts">
         <a href="${contextRoot}/manage/products">Manage Products</a>
         </li>		
        <li id="manageCategories">
         <a href="${contextRoot}/manage/category">Manage Category</a>
         </li>
       
         </security:authorize>
         </c:if>
         
      </ul>
    </div>
  </div>
 </nav>
 
 
 
 
 
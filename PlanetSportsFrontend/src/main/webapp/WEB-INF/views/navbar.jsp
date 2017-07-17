<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>>

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
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${contextRoot}/index">Home</a></li>
        
        <security:authorize access="isAnonymous()">
       <li id="about"><a href="${contextRoot}/about">About</a></li> 
         <li id="contact"><a href="${contextRoot}/contact">Contact Us</a></li>
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
		
		
		<security:authorize access="isAnonymous()">
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li id=signup><a href="${contextRoot}/register">Sign Up</a></li>
            <li id=login><a href="${contextRoot}/login">Login</a></li>
          </ul>
        </li>
        </security:authorize>
        
        
        <security:authorize access="hasAuthority('ADMIN')">
        <li id="manageProducts">
         <a href="${contextRoot}/manage/products">Manage Products</a>
         </li>		
        <li id="manageCategories">
         <a href="${contextRoot}/manage/category">Manage Category</a>
         </li>
         </security:authorize>
         
         
      </ul>
    </div>
  </div>
 </nav>
 
 
 
 
 
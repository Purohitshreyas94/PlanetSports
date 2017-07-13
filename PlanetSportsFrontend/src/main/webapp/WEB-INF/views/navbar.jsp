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
        <li id="about"><a href="${contextRoot}/about">About</a></li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <c:forEach items="${list}" var="category">
                <li><a href="${contextRoot}/show/category/${category.catid}/products" id="a_${category.catname}">${category.catname}</a></li>
          </c:forEach>
           <!--   <li><a href="#">Running</a></li>
            <li><a href="#">Cricket</a></li>
            <li><a href="#">Football</a></li> 
			<li><a href="#">Tennis</a></li>--> 
          </ul>
        </li>
        <li id=listProduct><a href="${contextRoot}/show/all/products">Products</a></li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li id=signup><a href="${contextRoot}/signup">Sign Up</a></li>
            <li id=login><a href="${contextRoot}/login">Login</a></li>
            
          </ul>
        </li>
        <li id="manageProducts">
         <a href="${contextRoot}/manage/products">Manage Products</a>
         </li>		
        
      </ul>
    </div>
  </div>
 </nav>
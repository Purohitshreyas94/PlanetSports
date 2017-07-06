 <%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
 
 <head>

	<!-- Basic Page Needs -->
	<meta charset="utf-8">
	<title>Planet Sports</title>
	
	<meta name="author" content="2code.info">
	
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<!-- Main Style -->
	<link rel="stylesheet" href="resources/style.css">
	
	<!-- Skins -->
	<link rel="stylesheet" href="resources/css/skins/skins.css">
	
 
	
	<!-- Dark -->
	<link rel="stylesheet" href="resources/css/dark.css">
	
	<!-- Responsive Style -->
	<link rel="stylesheet" href="resources/css/responsive.css">
	
	<!-- Favicons -->
	<link rel="shortcut icon" href="resources/images/favicon.png">
	
	<!-- js -->
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/html5.js"></script>
<script src="resources/js/jquery.isotope.min.js"></script>
<script src="resources/js/jquery.nicescroll.min.js"></script>
<script src="resources/js/jquery.appear.js"></script>
<script src="resources/js/count-to.js"></script>

<script src="resources/js/jquery.inview.min.js"></script>
<script src="resources/js/jquery.prettyPhoto.js"></script>
<script src="resources/js/jquery.bxslider.min.js"></script>
<script src="resources/js/jquery.themepunch.plugins.min.js"></script>
<script src="resources/js/jquery.themepunch.revolution.min.js"></script>
<script src="resources/js/custom.js"></script>
<script src="resources/js/myapp.js"></script>
<!-- End js -->
  
</head>
<body class="dark-s">

<div class="loader"><div class="loader_html"></div></div>

<div id="wrap" class="fixed-enabled grid_1200">
	
	
	<header id="header">
		<div class="container clearfix">
			<div class="logo"><a href="index"><img alt="" src="resources/images/logo.png"></a><span>Your Sports Gallery</span></div>
			<%-- <div class="header-search">
				<div class="header-search-a"><i class="fa fa-search"></i></div>
				<div class="header-search-form">
					<form method="post">
						<input type="text" placeholder="Search Words Here">
					</form>
				</div>
			</div> --%>
			<nav class="navigation navigation-2">
				<ul>
					<li class="current_page_item"><a href="index">Home</a>						
					</li>
					<li ><a href="aboutus">About</a>
					</li>
					<li ><a href="#">Categories</a>
						<ul>
							<li><a href="cricket">Cricket</a></li>
							<li><a href="tennis">Tennis</a></li>
							<li><a href="football">Football</a></li>
							<li><a href="running">Running</a></li>
														
						</ul>
					</li>
					<li><a href="contact">Contact</a>
						
					</li>
					<li><a href="account">My Account</a>
						<ul>
							<li><a href="#">Log In</a></li>
							<li><a href="#">Sign Up</a></li>
							
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
					
				</ul>
			</nav><!-- End navigation -->
		</div><!-- End container -->
	</header><!-- End header -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@page isELIgnored="false" %>
           <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<script src="resources/js/angular.min.js" ></script>
<script src="resources/js/angularmodule.js" ></script>
<script src="resources/js/ui-bootstrap.js" ></script>
<script src="resources/jquery/jquery.min.js"></script>
<script src="resources/jquery/bootstrap.js"></script>
<!-- <link href='//fonts.googleapis.com/css?family=Cagliostro' rel='stylesheet' type='text/css'> -->
<!-- <link href='//fonts.googleapis.com/css?family=Open+Sans:400,800italic,800,700italic,700,600italic,600,400italic,300italic,300' rel='stylesheet' type='text/css'> -->
<!--search jQuery-->
	<script src="resources/jquery/main.js"></script>
<!--search jQuery-->
<script src="resources/jquery/responsiveslides.min.js"></script>

 <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
 </script>
 
   <link rel="stylesheet" href="resources/css/style2.css" media="screen">
   <link rel="stylesheet" href="resources/css/fonts.css" media="screen">
   <!--mycart-->
<script type="text/javascript" src="resources/jquery/bootstrap-3.1.1.min.js"></script>
 <!-- cart -->
<script src="resources/jquery/simpleCart.min.js"></script>
<!-- cart -->
  <!--start-rate-->
<script src="resources/jquery/jstarbox.js"></script>
	<link rel="stylesheet" href="resources/css/style2.css" type="text/css" media="screen" charset="utf-8" />
		<script type="text/javascript">
			jQuery(function() {
			jQuery('.starbox').each(function() {
				var starbox = jQuery(this);
					starbox.starbox({
					average: starbox.attr('data-start-value'),
					changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
					ghosting: starbox.hasClass('ghosting'),
					autoUpdateAverage: starbox.hasClass('autoupdate'),
					buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
					stars: starbox.attr('data-star-count') || 5
					}).bind('starbox-value-changed', function(event, value) {
					if(starbox.hasClass('random')) {
					var val = Math.random();
					starbox.next().text(' '+val);
					return val;
					} 
				})
			});
		});
		</script>
		
		
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!--//End-rate-->
  
  
</head>
<body>
<div id="waitOverlay">
</div>

<!--header-->
		<div class="header">
			<div class="header-top">
				<div class="container">
					 <div class="top-left">
						<a href="#"> Help  <i class="glyphicon glyphicon-phone" aria-hidden="true"></i> +0123-456-789</a>
						<c:if test="${!empty pageContext.request.userPrincipal}">
						<span><a href="#"><i>welcome ${pageContext.request.userPrincipal.name}</i></a></span>
						</c:if>
					</div>
					<div class="top-right">
					<ul>
						<li><a href="checkout.html">Checkout</a></li>
						<c:if test="${empty pageContext.request.userPrincipal}">
						<li><a href="login">Login</a></li>
						<li><a href="registerUser"> Create Account </a></li>
						</c:if>
						<c:if test="${!empty pageContext.request.userPrincipal}">
						<li><a href="/BeeCasual/logout">Logout</a></li>
						</c:if>
					</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="heder-bottom">
				<div class="container">
					<div class="logo-nav">
						<div class="logo-nav-left">
							<h1><a href="/BeeCasual/" >bee casual <span>only casual clothing</span></a></h1>
						</div>
						<div class="logo-nav-left1">
							<nav class="navbar navbar-default">
							
							<div class="navbar-header nav_2">
								<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div> 
							<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
								<ul class="nav navbar-nav">
									<li class="active"><a href="/BeeCasual/" class="act">Home</a></li>	
									<!-- Mega Menu -->
									<c:forEach items="${categoryListDrop}" var="category">
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown">${category.categoryName}<b class="caret"></b></a>
										
										<ul class="dropdown-menu multi-column columns-3">


										
													<ul class="multi-column-dropdown">
														<h6>Shop</h6>
														<c:forEach items="${category.subCategory}" var="sub">
														<li><a href="productdisplay?search=${sub.subCategoryName}">${sub.subCategoryName}</a></li>
														</c:forEach>
														</ul>
												
										</ul>
										
									</li>
									</c:forEach>
								</ul>
								
							</div>
							</nav>
						</div>
						<div class="logo-nav-right">
							<ul class="cd-header-buttons">
								<li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>
							</ul> <!-- cd-header-buttons -->
							<div id="cd-search" class="cd-search">
									
        <div ng-module="myApp1">
    <div  ng-controller="TypeaheadCtrl">
	
    <input type="search" ng-model="selected" uib-typeahead="state as state.productName for state in states | filter:$viewValue | limitTo:8" class="form-control">
    
</div></div>

   

							</div>	
						</div>
						<div class="header-right2">
							<div class="cart box_1">
								<a href="checkout.html">
									<h3> <div class="total">
										<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</div>
										<img src="resources/images/bag.png" alt="" />
									</h3>
								</a>
								<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
								<div class="clearfix"> </div>
							</div>	
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
		</div>
		<!--header-->
		
		

</body>
<script>
		angular.module('myApp1', ['ui.bootstrap']);

		 var myApp1=angular.module('myApp1').controller('TypeaheadCtrl', function($scope) {

			  var _selected;

			  $scope.selected = undefined;
			  $scope.states = ${productListAdvice};
			});
		 </script>
		<script type="text/javascript">			
		jQuery(document).ready(function ($) {
		    $(window).load(function () {
		        setTimeout(function(){
		            $('#waitOverlay').fadeOut('slow', function () {
		            });
		        },1000);

		    });  
		});

            </script>
</html>

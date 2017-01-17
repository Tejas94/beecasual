<%@include file="Header1.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script defer src="resources/jquery/jquery.flexslider.js"></script>
<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>

<script type="text/javascript">
var myApp=angular.module("myApp",[]);
myApp.controller("myCtrl",function($scope)
		{
		$scope.product=${product};
		});
</script>


</head>
<body>
<div class="content" ng-app="myApp" ng-controller="myCtrl">
			<!--single-->
			<div class="single-wl3">
				<div class="container">
					<div class="single-grids">
						<div class="col-md-12 single-grid">
							<div clas="single-top">
								<div class="single-left">
									<div class="flexslider">
										<ul class="slides">
											<li data-thumb="resources/images/{{product.productId}}-0.jpg">
												<div class="thumb-image"> <img src="resources/images/{{product.productId}}-0.jpg" data-

imagezoom="true" class="img-responsive"> </div>
											</li>
											<li data-thumb="resources/images/{{product.productId}}-1.jpg">
												 <div class="thumb-image"> <img src="resources/images/{{product.productId}}-1.jpg" data-

imagezoom="true" class="img-responsive"> </div>
											</li>
											<li data-thumb="resources/images/{{product.productId}}-2.jpg">
											   <div class="thumb-image"> <img src="resources/images/{{product.productId}}-2.jpg" data-imagezoom="true" 

class="img-responsive"> </div>
											</li>
																						 
										 </ul>
									</div>
								</div>
								<div class="single-right simpleCart_shelfItem">
									<h4>{{product.productName}}</h4>
									<div class="block">
										<div class="starbox small ghosting"> </div>
									</div>
									<p class="price item_price">Rs.{{product.productPrice}}</p>
									<div class="description">
										<p><span>Quick Overview : </span> In cursus faucibus tortor eu vestibulum. Ut eget 

turpis ac justo porta varius. Donec vel felis ante, ac vehicula ipsum. Quisque sed diam metus. Quisque eget leo sit amet erat varius rutrum vitae dapibus lectus. 

Vivamus et sapien ante. Suspendisse potenti. Fusce in tellus est, ac consequat.</p>
									</div>
									<form:form modelAttribute="cartItems" action="/BeeCasual/addCart-${sessionScope.productId}?userId=1">
									<div class="color-quality">
										<h6>Quantity :</h6>
										<div>
										
										<form:input path="productQuantity" type="number" value="1"/>
										
										</div>
<!-- 											<div class="quantity">  -->
<!-- 												<div class="quantity-select">                            -->
<!-- 													<div class="entry value-minus1">&nbsp;</div> -->
<!-- 													<div class="entry value1"><span>1</span></div> -->
<!-- 													<div class="entry value-plus1 active">&nbsp;</div> -->
<!-- 												</div> -->
<!-- 											</div> -->
									</div>
									<div class="women">
										<span class="size">XL / XXL / S </span>
								<span class="my-cart-b item_add"><input type="submit" value="add"></span>
									</div>
									</form:form>
									<div class="social-icon">
										<a href="#"><i class="icon"></i></a>
										<a href="#"><i class="icon1"></i></a>
										<a href="#"><i class="icon2"></i></a>
										<a href="#"><i class="icon3"></i></a>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
        </div>
        </div>
        </div>

</body>
</html>
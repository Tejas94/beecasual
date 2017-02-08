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
<script type="text/javascript">
function clickdata()
{
var d=document.getElementById("radio").value;
document.getElementById("radio1").value=d;
}
</script>
<script type="text/javascript">
function clickdata1()
{
var e=document.getElementById("radio2").value;
document.getElementById("radio1").value=e;
}
</script>
<script type="text/javascript">
function clickdata2()
{
var f=document.getElementById("radio4").value;
document.getElementById("radio1").value=f;
}
</script>
<script type="text/javascript">
function clickdata3()
{
var g=document.getElementById("radio6").value;
document.getElementById("radio1").value=g;
}
</script>
<script type="text/javascript">
function clickdata4()
{
document.getElementById("radio1").value=document.getElementById("radio8").value;
}

</script>

</head>
<body>
<div class="content" ng-app="myApp" ng-controller="myCtrl">


			<!--single-->
			<div class="single-wl3">
			<div>
<ol class="breadcrumb">
    <li><a href="/BeeCasual/"><b>Home</b></a>
    </li>
    <li><a href="productdisplay"><b>View All Products</b></a>
    </li>
    <li class="active"><b>{{product.productName}}</b></li>
</ol>
</div>
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
									<p class="price">Rs {{product.productPrice}}</p>
								<form:form modelAttribute="cartItems" action="/BeeCasual/addCart-${sessionScope.productId}?userId=1">
									<div class="color-quality">
									<div>
									<h6><span class="btn-radio">Size</span></h6>
									<div>
									
										<form:input path="productSize"  id="radio1" type="hidden"  />
										<input type="button" value="S" class="btn-radio" onclick="clickdata()" id="radio">
										
										<form:input path="productSize"  id="radio1" type="hidden" />
										<input type="button" value="M" class="btn-radio" onclick="clickdata1()" id="radio2">
										
										<form:input path="productSize"  id="radio1" type="hidden" />
										<input type="button" value="L" class="btn-radio" onclick="clickdata2()" id="radio4">
										
										<form:input path="productSize"  id="radio1" type="hidden" />
										<input type="button" value="XL" class="btn-radio" onclick="clickdata3()" id="radio6">
										
										<form:input path="productSize"  id="radio1" type="hidden" />
										<input type="button" value="XXL" class="btn-radio" onclick="clickdata4()" id="radio8">
									

									
									</div>
									
									
									
									</div>
									
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
								<input type="submit" value="Add To Bag" class="btn-blue-blue-white" >
								<a href="buyNow-{{product.productId}}?userId=1"><input class="btn-blue-dark" type="button" value="Buy Now"></a>
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
<%@include file="Header1.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
var myApp=angular.module("myApp",[]);
myApp.controller("myCtrl",function($scope)
		{
		$scope.clist=${clist};
		});
</script>

</head>
<body>
<div class="content" ng-app="myApp" ng-controller="myCtrl">
			<div class="cart-items">
				<div class="container">
					 <h2>My Shopping Bag</h2>
						
					 <div class="cart-header">
						 <div class="close1"> </div>
						 <div class="cart-sec simpleCart_shelfItem">
								<div class="cart-item cyc">
									 <img src="resources/images/{{clist.productId}}-0.jpg" class="img-responsive" alt="">
								</div>
							   <div class="cart-item-info">
								<h3>{{clist.productName}}<span>Pickup time:</span></h3>
								<ul class="qty">
									<li><p>Min. order value:</p></li>
									<li><p>FREE delivery</p></li>
								</ul>
									 <div class="delivery">
									 <p>Service Charges : $10.00</p>
									 <span><h3><a href="/BeeCasual/checkout?userId=${sessionScope.userId}">Checkout</a></h3></span><br>
									 <span>Delivered in 1-1:30 hours</span>
									 <div class="clearfix"></div>
								</div>	
							   </div>
							   <div class="clearfix"></div>
													
						  </div>
					 </div>
				
		
</div>
</div>
</div>
</body>
</html>
<%@include file="Footer.jsp"%>
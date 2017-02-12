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
		$scope.slist=${slist};
		$scope.getTotal = function(){
		    var total = 0;
		    for(var i = 0; i < $scope.slist.length; i++){
		        var product = $scope.slist[i];
		        total += (s.productPrice-s.productDiscount*s.productPrice/100);
		    }
		    return total;
		}
		});
</script>

</head>
<body>
<div class="content" ng-app="myApp" ng-controller="myCtrl">
<div ng-init="total = 0">
			<div class="cart-items">
				<div class="container" >
					 <h2>My Shopping Bag</h2>
						
					 <div class="cart-header" ng-repeat="s in slist">
						 <div class="close1"><a href="deleteCartItem-{{s.cartItemId}}"><span class="glyphicon glyphicon-remove" ></span></a> </div>
						 <div class="cart-sec simpleCart_shelfItem">
								<div class="cart-item cyc">
									 <img src="resources/images/{{s.productId}}-0.jpg" class="img-responsive" alt="">
								</div>
							   <div class="cart-item-info">
								<h3>{{s.productName}}<span ng-init="$parent.total = total + s.productPrice-s.productDiscount*s.productPrice/100"><h3>Price:Rs {{s.productPrice-s.productDiscount*s.productPrice/100}}</h3></h3></span></h3>
								<ul class="qty">
									<li><p><h3>Quantity: {{s.productQuantity}}</h3></p></li>
									<li><p>FREE delivery</p></li>
								</ul>
									 <div class="delivery">
									 <p>Service Charges : Rs 10.00</p>
<%-- 									 <span><h3><a href="/BeeCasual/checkout?userId=${sessionScope.userId}">Checkout</a></h3></span><br> --%>
									 <span>Delivered in 1-3 days</span>
									 <div class="clearfix"></div>
								</div>	
							   </div>
							   <div class="clearfix"></div>
													
						  </div>
					 </div>
				
		
</div>
</div>
<h2><span style="margin-left:100px">Total: {{ total }}</span></h2><a href="/BeeCasual/checkout?userId=${sessionScope.userId}"><input class="btn-blue-dark" type="button" value="Checkout"></a>
</div>
</div>
</body>
</html>
<%@include file="Footer.jsp"%>
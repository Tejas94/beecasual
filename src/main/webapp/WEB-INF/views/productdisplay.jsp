<%@include file="Header1.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div ng-app="myApp" ng-controller="myCtrl">
<div>
<ol class="breadcrumb">
    <li><a href="/BeeCasual/"><b>Home</b></a>
    </li>
    
    <li class="active"><b>View All Products</b></li>
</ol>
</div>
<div id="wrapper">
        <div class="overlay"></div>
    
<div  id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                       Brand
                    </a>
                </li>
                <li><div class="checkbox">
  <label><input type="checkbox" value="">Option 1</label>
</div>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Events</a>
                </li>
                <li>
                    <a href="#">Team</a>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Works <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li class="dropdown-header">Dropdown heading</li>
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
                <li>
                    <a href="https://twitter.com/maridlcrmn">Follow me</a>
                </li>
            </ul>
        </div>
         <div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
    			<span class="hamb-middle"></span>
				<span class="hamb-bottom"></span>
            </button>
  		</div>	     
    
    

					<div class="container">
					<div class="row">
						<div >	
						<label>Search BOX: <input type="text" name="a" ng-model="searchKeyword"></label>					
						<div class="arrivals-grids">
							<div class="col-md-3 arrival-grid simpleCart_shelfItem" style="margin-bottom:1em" ng-repeat="p in product |  filter:searchKeyword">
								<div class="grid-arr">
									<div  class="grid-arrival">
										<figure>		
											<a href="#" class="new-gri" data-toggle="modal" data-target="#myModal1">
												<div class="grid-img">
													<img  src="resources/images/{{p.productId}}-1.jpg" class="" alt="">
												</div>
												<div class="grid-img">
													<img  src="resources/images/{{p.productId}}-0.jpg" class=""   alt="">
												</div>			
											</a>		
										</figure>	
									</div>
									
									<div class="block">
										<div class="starbox small ghosting"> </div>
									</div>
									<div class="women">
										<h6><a href="viewproduct-{{p.productId}}">{{p.productName}}</a></h6>
										<p><a href="wishList-{{p.productId}}?userId=1"><span class="glyphicon glyphicon-heart"></span></a></p><a href="buyNow-{{p.productId}}?userId=1"><span class="glyphicon glyphicon-shopping-cart"></span></a>
										
										<p ><del>{{p.productPrice}}</del><em> Rs {{p.productPrice-p.productDiscount*p.productPrice/100}}</em></p>
										
									</div>
								</div>
							</div>
					</div>
					</div>
					</div>
					</div>
					</div>
					</div>
	
<div>
<script type="text/javascript">
var myApp=angular.module("myApp",[]);
myApp.controller("myCtrl",function($scope,$http,$location)
		{
	
		$scope.searchKeyword=location.search.substr(8).replace(/%20/g," ");
		$scope.product=${productViewList};
		
		});
</script>

<script type="text/javascript">
$(document).ready(function () {
	  var trigger = $('.hamburger'),
	      overlay = $('.overlay'),
	     isClosed = false;

	    trigger.click(function () {
	      hamburger_cross();      
	    });

	    function hamburger_cross() {

	      if (isClosed == true) {          
	        overlay.hide();
	        trigger.removeClass('is-open');
	        trigger.addClass('is-closed');
	        isClosed = false;
	      } else {   
	        overlay.show();
	        trigger.removeClass('is-closed');
	        trigger.addClass('is-open');
	        isClosed = true;
	      }
	  }
	  
	  $('[data-toggle="offcanvas"]').click(function () {
	        $('#wrapper').toggleClass('toggled');
	  });  
	});
</script>

</div>
</body>
</html>
<%@ include file="Footer.jsp" %>
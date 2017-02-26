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
    <li class="active"><b><span><label>Search BOX: <input type="text" name="a" ng-model="searchKeyword"></label></span></b></li>
</ol>

</div>
<div id="wrapper">
        <div class="overlay"></div>
    
<div  id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                       Filter
                    </a>
                </li>
                
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Category <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeCategory('Mens')"/> Mens</div></li>
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeCategory('Women')"/> Women</div></li>
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeCategory('Kids')"/> kids</div></li>
                     </ul>
                </li>
                
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">SubCategory <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                   
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeSubCategory('t shirts')"/> t shirts</div></li>
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeSubCategory('jeans')"/> jeans</div></li>
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeSubCategory('shirts')"/> shirts</div></li>
                     </ul>
                </li>
                
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Brand <span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                   
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeBrand('nike')"/>nike</div></li>
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeBrand('Mr.right')"/>Mr.right</div></li>
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeBrand('Artic')"/>Artic</div></li>
                    <li><div class="checkbox" style="left:1em;color:white"><input type="checkbox" ng-click="includeBrand('Marvel')"/>Marvel</div></li>
                     </ul>
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
							
						<div>
<ol class="breadcrumb1">
    <li><b>Sort by</b>
    </li>
    
    <li class="active" style="color:#0d59af"><b><input id="buttonchange" type="button" ng-click="sortType= 'productName'; sortReverse= !sortReverse" value="name">
<span ng-show="sortType== 'productName'" ng-class="{'glyphicon glyphicon-arrow-up':!sortReverse, 'glyphicon glyphicon-arrow-down':sortReverse}" ></span>
</b></li>

<li class="active" style="color:#0d59af"><b><input id="buttonchange" type="button" ng-click="sortType= 'productPrice'; sortReverse= !sortReverse" value="Price">
<span ng-show="sortType== 'productPrice'" ng-class="{'glyphicon glyphicon-arrow-up':!sortReverse, 'glyphicon glyphicon-arrow-down':sortReverse}" ></span><span ng-if="sortReverse">High to low</span>
</b></li>

<li class="active" style="color:#0d59af"><b><input id="buttonchange" type="button" ng-click="sortType= 'productDiscount'; sortReverse= !sortReverse" value="Discount">
<span ng-show="sortType== 'productDiscount'" ng-class="{'glyphicon glyphicon-arrow-up':!sortReverse, 'glyphicon glyphicon-arrow-down':sortReverse}" ></span><span ng-if="sortReverse">High to low</span>
</b></li>
</ol>
</div>
										
						<div class="arrivals-grids">
							<div class="col-md-3 arrival-grid simpleCart_shelfItem" style="margin-bottom:1em" ng-repeat="p in product |  filter:searchKeyword | filter:categoryFilter | filter:subCategoryFilter | filter:brandFilter | orderBy:sortType:sortReverse">
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
										
										<p ><del ng-if="p.productDiscount!==0">{{p.productPrice}}</del><em> Rs {{p.productPrice-p.productDiscount*p.productPrice/100}}</em></p>
										
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
		
		
	    $scope.categoryIncludes = [];
	    
	    $scope.includeCategory = function(categoryName) {
	        var i = $.inArray(categoryName, $scope.categoryIncludes);
	        if (i > -1) {
	            $scope.categoryIncludes.splice(i, 1);
	        } else {
	            $scope.categoryIncludes.push(categoryName);
	        }
	    }
	    
	    $scope.categoryFilter = function(product) {
	        if ($scope.categoryIncludes.length > 0) {
	            if ($.inArray(product.categoryName, $scope.categoryIncludes) < 0)
	                return;
	        }
	        
	        return product;
	    }
	    //subcategory filter
		$scope.subCategoryIncludes = [];
	    
	    $scope.includeSubCategory = function(subCategoryName) {
	        var i = $.inArray(subCategoryName, $scope.subCategoryIncludes);
	        if (i > -1) {
	            $scope.subCategoryIncludes.splice(i, 1);
	        } else {
	            $scope.subCategoryIncludes.push(subCategoryName);
	        }
	    }
	    
	    $scope.subCategoryFilter = function(product) {
	        if ($scope.subCategoryIncludes.length > 0) {
	            if ($.inArray(product.subCategoryName, $scope.subCategoryIncludes) < 0)
	                return;
	        }
	        
	        return product;
	    }
		
	    //brand filter
		$scope.brandIncludes = [];
	    
	    $scope.includeBrand = function(brandName) {
	        var i = $.inArray(brandName, $scope.brandIncludes);
	        if (i > -1) {
	            $scope.brandIncludes.splice(i, 1);
	        } else {
	            $scope.brandIncludes.push(brandName);
	        }
	    }
	    
	    $scope.brandFilter = function(product) {
	        if ($scope.brandIncludes.length > 0) {
	            if ($.inArray(product.brandName, $scope.brandIncludes) < 0)
	                return;
	        }
	        
	        return product;
	    }
	    

	    	    
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
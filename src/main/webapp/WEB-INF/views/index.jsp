<%@ include file="Header1.jsp" %>
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script type="text/javascript">
var myApp=angular.module("myApp",[]);
myApp.controller("myCtrl",function($scope)
		{
		$scope.product=${productViewList};
		});
</script>


  <div ng-app="myApp" ng-controller="myCtrl">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/b1.jpg" alt="adidas" width="460" height="345">
      </div>

      <div class="item">
        <img src="resources/images/b2.jpg" alt="jackets" width="460" height="345">
      </div>
    
      

      <div class="item">
        <img src="resources/images/b3.jpg" alt="sneak" width="460" height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  
	<div class="content">
			<!--banner-bottom-->
				<div class="ban-bottom-w3l">
					<div class="container">
					<div class="row">
						<div class="col-md-6 ban-bottom">
							<div class="ban-top">
								<img src="resources/images/p1.jpg" class="img-responsive" alt=""/>
								<div class="ban-text">
									<h4>Men's Clothing</h4>
								</div>
<!-- 								<div class="ban-text2 hvr-sweep-to-top"> -->
<!-- 									<h4>50% <span>Off/-</span></h4> -->
<!-- 								</div> -->
							</div>
						</div>
		
		<div class="col-md-6 ban-bottom">
							<div class="ban-top">
								<img src="resources/images/p2.jpg" class="img-responsive" alt=""/>
								<div class="ban-text">
									<h4>Women's Clothing</h4>
								</div>
<!-- 								<div class="ban-text2 hvr-sweep-to-top"> -->
<!-- 									<h4>50% <span>Off/-</span></h4> -->
<!-- 								</div> -->
							</div>
						</div>
						</div>
		<br>
		<div class="row">
		<div class="col-md-6 ban-bottom">
							<div class="ban-top">
								<img src="resources/images/p3.jpg" class="img-responsive" alt=""/>
								<div class="ban-text">
									<h4>View Collection</h4>
								</div>
<!-- 								<div class="ban-text2 hvr-sweep-to-top"> -->
<!-- 									<h4>50% <span>Off/-</span></h4> -->
<!-- 								</div> -->
							</div>
						</div>
		
		<div class="col-md-6 ban-bottom">
							<div class="ban-top">
								<img src="resources/images/p4.jpg" class="img-responsive" alt=""/>
								<div class="ban-text">
									<h4>official merchandise</h4>
								</div>
<!-- 								<div class="ban-text2 hvr-sweep-to-top"> -->
<!-- 									<h4>50% <span>Off/-</span></h4> -->
<!-- 								</div> -->
							</div>
						</div>
						</div>
		
						<div class="clearfix"></div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					
			<div class="new-arrivals-w3agile" ng-repeat="p in product" >
					<div class="container">
						<h2 class="tittle">New Arrivals</h2>
						<div class="arrivals-grids">
							<div class="col-md-3 arrival-grid simpleCart_shelfItem">
								<div class="grid-arr">
									<div  class="grid-arrival">
										<figure>		
											<a href="#" class="new-gri" data-toggle="modal" data-target="#myModal1">
												<div class="grid-img">
													<img  src="resources/images/{{p.productId}}-1.jpg" class="img-responsive" alt="">
												</div>
												<div class="grid-img">
													<img  src="resources/images/{{p.productId}}-0.jpg" class="img-responsive"  alt="">
												</div>			
											</a>		
										</figure>	
									</div>
									<div class="ribben">
										<p>NEW</p>
									</div>
									<div class="ribben1">
										<p>SALE</p>
									</div>
									<div class="block">
										<div class="starbox small ghosting"> </div>
									</div>
									<div class="women">
										<h6><a href="">{{p.productName}}</a></h6>
										<span class="size">XL / XXL / S </span>
										<p ><del></del><em class="item_price">RS.{{p.productPrice}}</em></p>
										<a href="buyNow-{{p.productId}}?userId=1" data-text="Add To Cart" class="my-cart-b item_add">Add To Cart</a>
									</div>
								</div>
							</div>
					</div>
					</div>
					</div>
					
</div>
<%@ include file="Footer.jsp" %>
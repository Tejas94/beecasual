<%@include file="Header1.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="resources/js/angular.min.js" ></script>
<script type="text/javascript">
var myApp=angular.module("myApp",[]);
myApp.controller("myCtrl",function($scope)
		{
		$scope.jsonData=${productList};
		});
</script>
<script type="text/javascript">
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("productTable").style.display = "block";
		document.getElementById("productTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("productTable").style.display = "none";
		document.getElementById("productTable").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}

</script>
<link rel="stylesheet" href="resources/css/Style.css">
<style type="text/css">
#productTable{
display: none;


}
 #buttonchange {
     background:none!important;
     border:none; 
     padding:0!important;
     font: inherit;
     /*border is optional*/
     border-bottom:1px solid #444; 
     cursor: pointer;
}
#buttonToggle{
 background: #fdb515;
    color: #FFFFFF;
    text-align: center;
    padding: 10px 0;
    border: none;
    font-size: 1em;
    outline: none;
    width: 32%;
    cursor: pointer;
    margin-bottom:30px;
 

}
#buttonToggle:hover{
 background:#AF1D0D;
	transition:0.5s all;
	-webkit-transition:0.5s all;
	-moz-transition:0.5s all;
	-o-transition:0.5s all;
	-ms-transition:0.5s all;
 

}
  
</style>



</head>
<body>
<div class="container-fluid" ng-app="myApp" ng-controller="myCtrl" align="center">
	<form:form modelAttribute="product" action="addProduct" enctype="multipart/form-data" >
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>Product form</h3>
									
							<div class="key">
							
								<form:input type="hidden" path="productId" />
								<form:input path="productName" placeholder="add name" /><br>
								<form:errors path="productName"/><br>
								<div class="clearfix"></div>
							</div>
							Quantity
							<div class="key">
								<form:input path="productQantity" placeholder="add quantity" /><br>
								<form:errors path="productQantity" /><br>
								<div class="clearfix"></div>
							</div>
						Price
					<div class="key">
								<form:input path="productPrice" placeholder="add price" /><br>
								<form:errors path="productPrice" /><br>
								<div class="clearfix"></div>
							</div>
							discount
					<div class="key">
								<form:input path="productDiscount" placeholder="add discount" /><br>
								<form:errors path="productDiscount" /><br>
								<div class="clearfix"></div>
							</div>
					<div class="key">
								<form:input path="productDescription" placeholder="add description" /><br>
								<form:errors path="productDescription" /><br>
								<div class="clearfix"></div>
							</div>
					<div class="key">
								<input type="file" name="files" multiple="multiple" ><br>
								
								<div class="clearfix"></div>
							</div>
				<div class="row">
				<div class="col-xs-12 col-md-3">
				Category			
					<div class="key">
								<form:select path="category.categoryName">
 <form:options items="${categoryList}" itemValue="categoryName" itemLabel="categoryName"/>
</form:select><br>
<div class="clearfix"></div>
							</div>
							</div>
						<div class="col-xs-12 col-md-3">	
						SubCategory
					<div class="key">
								<form:select path="subCategory.subCategoryName">
 <form:options items="${subCategoryList}" itemValue="subCategoryName" itemLabel="subCategoryName"/>
</form:select>
<br>
<div class="clearfix"></div>
							</div>
							</div>
						<div class="col-xs-12 col-md-3">	
						Brand
					<div class="key">
								<form:select path="brand.brandName">
 <form:options items="${brandList}" itemValue="brandName" itemLabel="brandName"/>
</form:select>
<br>

								<div class="clearfix"></div>
							</div>
							</div>
						<div class="col-xs-12 col-md-3">	
						Supplier
					<div class="key">
<form:select path="supplier.supplierName">
 <form:options items="${supplierList}" itemValue="supplierName" itemLabel="supplierName"/>
</form:select>
<br>

								<div class="clearfix"></div>
							</div>
							</div>
						</div>					
						<c:if test="${!empty product.productName}">
				<input type="submit" value="Edit product"/>
			</c:if>
			<c:if test="${empty product.productName}">
			<input type="submit" value="Add product"/>
			<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/><br>
			<input type="text" ng-model="test" placeholder="Search"/>
			</c:if>
 
					</div>
				</div>
			</div>
		</div>
			<div class="table-responsive">
				<table class="table" id="productTable" align="center">
					<thead>										
						<tr>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productId'; sortReverse= !sortReverse" value="product Id ">
<span ng-show="sortType== 'productId'" ></span>

</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productName'; sortReverse= !sortReverse" value="Product name">
<span ng-show="sortType== 'productName'" ></span>
</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productQantity'; sortReverse= !sortReverse" value="Product Qantity ">
<span ng-show="sortType== 'productQantity'" ></span>
</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productPrice'; sortReverse= !sortReverse" value="Product Price ">
<span ng-show="sortType== 'productPrice'" "></span>
</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productDiscount'; sortReverse= !sortReverse" value="Product Discount ">
<span ng-show="sortType== 'productDiscount'" "></span>
</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productDescription'; sortReverse= !sortReverse" value="Product Description ">
<span ng-show="sortType== 'productDescription'" ></span>
</th>
<th><span id="buttonchange" >edit</span></th>
<th><span id="buttonchange" >delete</span></th>
<th><span id="buttonchange" >add info</span></th>
</tr>
					</thead>
					<tbody>
							<tr ng-repeat="p in jsonData | filter:test | orderBy:sortType:sortReverse">
<td>{{p.productId}}</td>
<td>{{p.productName}}</td>
<td>{{p.productQantity}}</td>
<td>{{p.productPrice}}</td>
<td>{{p.productDiscount}}</td>
<td>{{p.productDescription}}</td>
<td><a href="editProduct-{{p.productId}}">Edit</a></td>
<td><a href="deleteProduct-{{p.productId}}">Delete</a></td>
<td><a href="productspecification-{{p.productId}}">add</a></td>
<tr>

					</tbody>
				</table>
			</div>
	
	</form:form>
</div>
					


</body>
</html>
<%@include file="Footer.jsp" %>
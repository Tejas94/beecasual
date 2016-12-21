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
td
{
    padding:0 15px 0 15px;
}
th
{
    padding:0 20px 0 20px;
}
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
  
</style>



</head>
<body>
<div ng-app="myApp" ng-controller="myCtrl" align="center">
<form:form modelAttribute="product" action="addProduct" enctype="multipart/form-data">
<form:input path="productId" type="hidden"/>
<form:input path="productName" placeholder="add name"/>
<form:errors path="productName"></form:errors><br>
 add quantity
<form:input path="productQantity" placeholder="add quantity"/>
<form:errors path="productQantity"></form:errors><br>
 add price
<form:input path="productPrice" placeholder="add price"/><br> add discount
<form:input path="productDiscount" placeholder="add discount"/><br>
<form:input path="productDescription" placeholder="add desc"/>
<form:errors path="productDescription"></form:errors><br>
<form:input type="file" path="productImage"/>
<br>
<br>
category
<form:select path="category.categoryName">
 <form:options items="${categoryList}" itemValue="categoryName" itemLabel="categoryName"/>
</form:select>
<br>
<br>
subcategory
<form:select path="subCategory.subCategoryName">
 <form:options items="${subCategoryList}" itemValue="subCategoryName" itemLabel="subCategoryName"/>
</form:select>
<br>
<br>
brand
<form:select path="brand.brandName">
 <form:options items="${brandList}" itemValue="brandName" itemLabel="brandName"/>
</form:select>
<br>
<br>
supplier
<form:select path="supplier.supplierName">
 <form:options items="${supplierList}" itemValue="supplierName" itemLabel="supplierName"/>
</form:select>
<br>
<br>
<c:if test="${!empty product.productName}">
				<input type="submit" value="Edit product"/>
			</c:if>
			<c:if test="${empty product.productName}">
			<input type="submit" value="Add product"/>
			<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
			<input type="text" ng-model="test" placeholder="Search"/>
			</c:if>
 <br>
<br>
<table border="1" id="productTable">
<tr>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productId'; sortReverse= !sortReverse" value="product Id ">
<span ng-show="sortType== 'productId'" ></span>

</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productName'; sortReverse= !sortReverse" value="Product name">
<span ng-show="sortType== 'productName'" "></span>
</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'productQantity'; sortReverse= !sortReverse" value="Product Qantity ">
<span ng-show="sortType== 'productQantity'" "></span>
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

</tr>

<tr ng-repeat="p in jsonData | filter:test | orderBy:sortType:sortReverse">
<td>{{p.productId}}</td>
<td>{{p.productName}}</td>
<td>{{p.productQantity}}</td>
<td>{{p.productPrice}}</td>
<td>{{p.productDiscount}}</td>
<td>{{p.productDescription}}</td>
<td><a href="editProduct-{{p.productId}}">Edit</a></td>
<td><a href="deleteProduct-{{p.productId}}">Delete</a></td>
<tr>

</table>

</form:form>
</div>


</body>
</html>
<%@include file="Footer.jsp" %>
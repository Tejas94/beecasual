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
		$scope.jsonData=${brandList};
		});
</script>
<script type="text/javascript">
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("brandTable").style.display = "block";
		document.getElementById("brandTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("brandTable").style.display = "none";
		document.getElementById("brandTable").style.visibility = "hidden";
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
#brandTable{
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
<br>
<br>
<br>
<div ng-app="myApp" ng-controller="myCtrl" align="center">
<form:form modelAttribute="brand" action="addBrand">
<form:input type="hidden" path="brandId" />
<form:input path="brandName" placeholder="add name" />
<form:errors path="brandName"/><br>
<form:input path="brandDescription" placeholder="add description" />
<form:errors path="brandDescription" /><br>
<c:if test="${!empty brand.brandName}">
				<input type="submit" value="Edit brand"/>
			</c:if>
			<c:if test="${empty brand.brandName}">
			<input type="submit" value="Add brand"/>
			<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
			<input type="text" ng-model="test" placeholder="Search"/>
			</c:if>

<br>
<br>
<table id="brandTable">
<tr>
<th><input id="buttonchange" type="button" ng-click="sortType= 'brandId'; sortReverse= !sortReverse" value="Brand Id ">
<span ng-show="sortType== 'brandId'" ></span>

<th><input id="buttonchange" type="button" ng-click="sortType= 'brandName'; sortReverse= !sortReverse" value="Brand Name ">
<span ng-show="sortType== 'brandName'" ></span>

<th><input id="buttonchange" type="button" ng-click="sortType= 'brandDescription'; sortReverse= !sortReverse" value="Brand Description ">
<span ng-show="sortType== 'brandDescription'" ></span>

<tr>

<tr ng-repeat="b in jsonData">
<td>{{b.brandId}}</td>
<td>{{b.brandName}}</td>
<td>{{b.brandDescription}}</td>
<td><a href="editBrand-{{b.brandId}}"/>Edit</td>
<td><a href="deleteBrand-{{b.brandId}}"/>Delete</td>
<tr>
</table>
</form:form>
</div>
</body>
</html>


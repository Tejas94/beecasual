
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
		$scope.jsonData=${supplierList};
		});
</script>
<script type="text/javascript">
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("supplierTable").style.display = "block";
		document.getElementById("supplierTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("supplierTable").style.display = "none";
		document.getElementById("supplierTable").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}

</script>

<style type="text/css">
td
{
    padding:0 15px 0 15px;
}
th
{
    padding:0 20px 0 20px;
}
#supplierTable{
max-width:500px;
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
<form:form modelAttribute="supplier" action="addSupplier">
<form:input type="hidden" path="supplierId" /><br>
<form:input path="supplierName" placeholder="add name" />
<form:errors path="supplierName"/><br>
<form:input path="supplierAddress" placeholder="add address" />
<form:errors path="supplierAddress"/><br>
<form:input path="supplierContact" placeholder="add contact"/>
<form:errors path="supplierContact" /><br>
<form:input path="supplierEmailId" placeholder="add email"/>
<form:errors path="supplierEmailId" /><br>
<c:if test="${!empty supplier.supplierName}">
				<input type="submit" value="Edit supplier"/>
			</c:if>
			<c:if test="${empty supplier.supplierName}">
			<input type="submit" value="Add supplier"/>
			<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
			<input type="text" ng-model="test" placeholder="Search"/>
			</c:if>
         
<br>
<br>
<table id="supplierTable" align="center">
<tr>
<th><input id="buttonchange" type="button" ng-click="sortType= 'supplierId'; sortReverse= !sortReverse" value="supplier Id ">
<span ng-show="sortType== 'supplierId'" ></span>

<th><input id="buttonchange" type="button" ng-click="sortType= 'supplierName'; sortReverse= !sortReverse" value="supplier Name">
<span ng-show="sortType== 'supplierName'" ></span>

<th><input id="buttonchange" type="button" ng-click="sortType= 'supplierAddress'; sortReverse= !sortReverse" value="supplier Address">
<span ng-show="sortType== 'supplierAddress'" ></span>

<th><input id="buttonchange" type="button" ng-click="sortType= 'supplierContact'; sortReverse= !sortReverse" value="supplier Contact">
<span ng-show="sortType== 'supplierContact'" ></span>

<th><input id="buttonchange" type="button" ng-click="sortType= 'supplierEmailId'; sortReverse= !sortReverse" value="supplier EmailId">
<span ng-show="sortType== 'supplierEmailId'" ></span>

<tr>

<tr ng-repeat="s in jsonData| orderBy:sortType:sortReverse | filter:test">
<td>{{s.supplierId}}</td>
<td>{{s.supplierName}}</td>
<td>{{s.supplierAddress}}</td>
<td>{{s.supplierContact}}</td>
<td>{{s.supplierEmailId}}</td>
<td><a href="editSupplier-{{s.supplierId}}"/>Edit</td>
<td><a href="deleteSupplier-{{s.supplierId}}"/>Delete</td>
<tr>

</table>
</form:form>
</div>
</body>
</html>


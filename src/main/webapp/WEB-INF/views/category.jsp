<%@include file="Header1.jsp" %>

<br>
<br>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<script src="resources/js/angular.min.js" ></script>
<script type="text/javascript">
var myApp=angular.module("myApp",[]);
myApp.controller("myCtrl",function($scope)
		{
		$scope.jsonData=${categoryList};
		});
</script>
<script type="text/javascript">
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("categoryTable").style.display = "block";
		document.getElementById("categoryTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("categoryTable").style.display = "none";
		document.getElementById("categoryTable").style.visibility = "hidden";
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
#categoryTable{
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
<div align="center" ng-app="myApp" ng-controller="myCtrl">
<form:form modelAttribute="category" action="addCategory">
   <table>
   <tr>
        <td><form:label path="categoryId">Category ID</form:label></td>
        <td><form:input type="hidden" path="categoryId" /></td>
    </tr>
    <tr>
        <td><form:label path="categoryName">Category Name</form:label></td>
        <td><form:input path="categoryName" /></td>
    </tr>
    <tr>
        <td><form:label path="categoryDescription">Category Description</form:label></td>
        <td><form:input path="categoryDescription" /></td>
    </tr>
   
    <tr>
        <td colspan="2">
            
            <c:if test="${!empty category.categoryName}">
				<input type="submit" value="Edit Category"/>
			</c:if>
			<c:if test="${empty category.categoryName}">
			<input type="submit" value="Add Category"/>
			<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
			<input type="text" ng-model="test" placeholder="Search"/>
			</c:if>
           
        </td>
    </tr>
</table>  
<br>
<table id="categoryTable">
<tr>
<th><input id="buttonchange" type="button" ng-click="sortType= 'categoryId'; sortReverse= !sortReverse" value="category Id">
<span ng-show="sortType== 'categoryId'" class="fa fa-caret-down"></span>

</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'categoryName'; sortReverse= !sortReverse" value="Category name">
<span ng-show="sortType== 'categoryName'" class="fa fa-caret-down"></span>
</th>
<th><input id="buttonchange" type="button" ng-click="sortType= 'categoryDescription'; sortReverse= !sortReverse" value="Category Description">
<span ng-show="sortType== 'categoryDescription'" class="fa fa-caret-down"></span>
</th>
</tr>

<tr ng-repeat="c in jsonData | filter:test | orderBy:sortType:sortReverse">
<td>{{c.categoryId}}</td>
<td>{{c.categoryName}}</td>
<td>{{c.categoryDescription}}</td>
<td><a href="editCategory-{{c.categoryId}}"/>Edit</td>
<td><a href="deleteCategory-{{c.categoryId}}"/>Delete</td>
</tr>
</table>
</form:form>
</div>
</body>
</html>
<%@include file="Footer.jsp" %>
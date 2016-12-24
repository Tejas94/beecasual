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
#categoryTable{
display: none;
max-width: 40px;
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
	<form:form modelAttribute="category" action="addCategory">
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>Category form</h3>			
							<div class="key">
							
								<form:input type="hidden" path="categoryId" />
								<form:input path="categoryName" placeholder="add name" /><br>
								<form:errors path="categoryName"/><br>
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input path="categoryDescription" placeholder="add description" /><br>
								<form:errors path="categoryDescription" /><br>
								<div class="clearfix"></div>
							</div>
						
						
						 <c:if test="${!empty category.categoryName}">
				<input type="submit" value="Edit Category"/>
			</c:if>
			<c:if test="${empty category.categoryName}">
			<input type="submit" value="Add Category"/>
			<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
			<input type="text" ng-model="test" placeholder="Search"/>
			</c:if>
        	</div>
				</div>
			</div>
		</div>
			<div class="table-responsive">
				<table class="table" id="categoryTable" align="center">
					<thead>										
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
					</thead>
					<tbody>
							<tr ng-repeat="c in jsonData | filter:test | orderBy:sortType:sortReverse">
<td>{{c.categoryId}}</td>
<td>{{c.categoryName}}</td>
<td>{{c.categoryDescription}}</td>
<td><a href="editCategory-{{c.categoryId}}"/>Edit</td>
<td><a href="deleteCategory-{{c.categoryId}}"/>Delete</td>
</tr>

					</tbody>
				</table>
			</div>
	
	</form:form>
</div>

</body>
</html>
<%@include file="Footer.jsp" %>
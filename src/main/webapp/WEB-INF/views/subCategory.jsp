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
		$scope.jsonData=${subCategoryList};
		});
</script>
<script type="text/javascript">
function toggle()
{
	if(document.getElementById("buttonToggle").value == "Show List")
	{
		document.getElementById("subCategoryTable").style.display = "block";
		document.getElementById("subCategoryTable").style.visibility = "visible";
		document.getElementById("buttonToggle").value = "Hide List";
	}
	else
	{
		document.getElementById("subCategoryTable").style.display = "none";
		document.getElementById("subCategoryTable").style.visibility = "hidden";
		document.getElementById("buttonToggle").value = "Show List";
	}
}

</script>

<style type="text/css">
#subCategoryTable{
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
	<form:form modelAttribute="subcategory" action="addSubCategory">
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>SubCategory form</h3>			
							<div class="key">
							
								<form:input type="hidden" path="subcategoryId" />
								<form:input path="subCategoryName" placeholder="add name" /><br>
								<form:errors path="subCategoryName"/><br>
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input path="subcategoryDescription" placeholder="add description" /><br>
								<form:errors path="subcategoryDescription" /><br>
								<div class="clearfix"></div>
							</div>
	<div class="key">
								Category<form:select path="category.categoryName">
 <form:options items="${categoryList}" itemValue="categoryName" itemLabel="categoryName"/>
</form:select><br>
<div class="clearfix"></div>					
		</div>				
							<c:if test="${!empty subcategory.subCategoryName}">
							<input type="submit" value="Edit subcategory"/>
							</c:if>
			 				<c:if test="${empty subcategory.subCategoryName}">
							<input type="submit" value="Add subcategory"/>
		 			 		<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/> <br>
							<input type="text" ng-model="test" placeholder="Search"/> 
							</c:if> 
					</div>
				</div>
			</div>
		</div>
			<div class="table-responsive">
				<table class="table" id="subCategoryTable" align="center">
					<thead>										
						<tr>
							<th><input id="buttonchange" type="button" ng-click="sortType= 'subcategoryId'; sortReverse= !sortReverse" value="subcategory Id ">
							<span ng-show="sortType== 'subcategoryId'" ></span>

							<th><input id="buttonchange" type="button" ng-click="sortType= 'subCategoryName'; sortReverse= !sortReverse" value="subCategory Name ">
							<span ng-show="sortType== 'subCategoryName'" ></span>

							<th><input id="buttonchange" type="button" ng-click="sortType= 'subcategoryDescription'; sortReverse= !sortReverse" value="subcategory Description ">
							<span ng-show="sortType== 'subcategoryDescription'" ></span>

						<tr>
					</thead>
					<tbody>
							<tr ng-repeat="b in jsonData | orderBy:sortType:sortReverse | filter:test">
							<td>{{b.subcategoryId}}</td>
							<td>{{b.subCategoryName}}</td>
							<td>{{b.subcategoryDescription}}</td>
							<td><a href="editSubCategory-{{b.subcategoryId}}"/>Edit</td>
							<td><a href="deleteSubCategory-{{b.subcategoryId}}"/>Delete</td>
						<tr>
					</tbody>
				</table>
			</div>
	
	</form:form>
</div>
</body>
</html>

<%@include file="Footer.jsp"%>

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
	<form:form modelAttribute="supplier" action="addSupplier">
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>Supplier form</h3>			
							<div class="key">
							
								<form:input type="hidden" path="supplierId" />
								<form:input path="supplierName" placeholder="add name" /><br>
								<form:errors path="supplierName"/><br>
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input path="supplierAddress" placeholder="add address" /><br>
								<form:errors path="supplierAddress" /><br>
								<div class="clearfix"></div>
							</div>

							<div class="key">
								<form:input path="supplierContact" placeholder="add contact" /><br>
								<form:errors path="supplierContact" /><br>
								<div class="clearfix"></div>
							</div>
						

							<div class="key">
								<form:input path="supplierEmailId" placeholder="add email" /><br>
								<form:errors path="supplierEmailId" /><br>
								<div class="clearfix"></div>
							</div>
						

						
						
						
							<c:if test="${!empty supplier.supplierName}">
				<input type="submit" value="Edit supplier"/>
			</c:if>
			<c:if test="${empty supplier.supplierName}">
			<input type="submit" value="Add supplier"/>
			<input type="button" id="buttonToggle" value="Show List" onclick="toggle();"/>
			<input type="text" ng-model="test" placeholder="Search"/>
			</c:if>
         
 
					</div>
				</div>
			</div>
		</div>
			<div class="table-responsive">
				<table class="table" id="supplierTable" align="center">
					<thead>										
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
<th><span id="buttonchange" >edit</span></th>
<th><span id="buttonchange" >delete</span></th>

<tr>
					</thead>
					<tbody>
							<tr ng-repeat="s in jsonData| orderBy:sortType:sortReverse | filter:test">
<td>{{s.supplierId}}</td>
<td>{{s.supplierName}}</td>
<td>{{s.supplierAddress}}</td>
<td>{{s.supplierContact}}</td>
<td>{{s.supplierEmailId}}</td>
<td><a href="editSupplier-{{s.supplierId}}"/><span class="glyphicon glyphicon-pencil" style="color:green"></span></td>
<td><a href="deleteSupplier-{{s.supplierId}}"/><span class="glyphicon glyphicon-trash"></span></td>
<tr>


					</tbody>
				</table>
			</div>
	
	</form:form>
</div>
					
</body>
</html>

<%@include file="Footer.jsp" %>
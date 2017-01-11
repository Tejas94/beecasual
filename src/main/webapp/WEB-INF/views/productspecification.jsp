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
max-width: 600px;

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
<div class="container-fluid" align="center">
	<form:form modelAttribute="productspecification" action="addInfo">
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>Product Specification</h3>
									
							<div class="key">
							
								<form:input type="hidden" path="productId" />
								<form:input path="color" placeholder="add color" /><br>
								
								<div class="clearfix"></div>
							</div>
						
							<div class="key">
								<form:input path="fabric" placeholder="add fabric" /><br>
								
								<div class="clearfix"></div>
							</div>
					
					<div class="key">
								<form:input path="pattern" placeholder="add pattern" /><br>
							
								<div class="clearfix"></div>
							</div>
							
					<div class="key">
								<form:input path="fit" placeholder="add fit"/>
								<div class="clearfix"></div>
							</div>
							
					<div class="key">
								<form:input path="washcare" placeholder="add washcare"/><div class="clearfix"></div>
							</div>
					<div class="key">
								<form:input path="style" placeholder="add style" /><br>
							
								<div class="clearfix"></div>
							</div>
					<div class="key">
								<form:input path="size" placeholder="add size" /><br>
							
								<div class="clearfix"></div>
							</div>
					
					<div class="key">
								<input type="submit" value="add info">
							
								<div class="clearfix"></div>
							</div>
						
			

								
 
					</div>
				</div>
			</div>
		</div>
						
	
	</form:form>
</div>
					


</body>
</html>
<%@include file="Footer.jsp" %>
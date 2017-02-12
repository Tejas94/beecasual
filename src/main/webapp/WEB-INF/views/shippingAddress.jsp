<%@include file="Header1.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/js/angular.min.js" ></script>


</head>
<body>

	<form:form modelAttribute="shippingAddress">
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>Shipping Address</h3>			
							<div class="key">
							
								<form:input type="hidden" path="shippingId" />
								<form:input path="flatNo" placeholder="add flatNo" /><br>
								<div>
								<form:errors path="flatNo"></form:errors>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input  path="street" placeholder="add street" /><br>
								<form:errors path="street"></form:errors>
								<div class="clearfix"></div>
							</div>
							
							<div class="key">
								<form:input  path="locatlity" placeholder="add locatlity" /><br>
								<form:errors path="locatlity"/>
								<div class="clearfix"></div>
							</div>
						
							<div class="key">
								<form:input  path="city" placeholder="add city" /><br>
								<form:errors path="city"/>
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input  path="state" placeholder="add state" /><br>
								<form:errors path="state"/>
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input  path="pincode" placeholder="add pincode" /><br>
								<form:errors path="pincode"/>
								<div class="clearfix"></div>
							</div>
						<div class="key">

							
							<div class="clearfix"></div>
						</div>
						<input name="_eventId_submit" type="submit" value="next"/>
		 			 		
				</div>
			</div>
		</div>
		</div>
</form:form>

</body>
</html>
<%@ include file="Footer.jsp" %>
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

	<form:form modelAttribute="userDetails" action="addUser">
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>Register User</h3>			
							<div class="key">
							
								<form:input type="hidden" path="userId" />
								<form:input path="userName" placeholder="add username" /><br>
								
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input type="password" path="password" placeholder="add password" /><br>
								
								<div class="clearfix"></div>
							</div>
							
							<div class="key">
								<form:input  path="firstName" placeholder="add firstName" /><br>
								
								<div class="clearfix"></div>
							</div>
						
							<div class="key">
								<form:input  path="lastName" placeholder="add lastName" /><br>
								
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input  path="emailId" placeholder="add emailId" /><br>
								
								<div class="clearfix"></div>
							</div>
							<div class="key">
								<form:input  path="contactNo" placeholder="add contactNo" /><br>
								
								<div class="clearfix"></div>
							</div>
						<div class="key">

							<form:input path="billingAddress.flatNo" placeholder="add flatno" />
							<br>

							<div class="clearfix"></div>
						</div>

<div class="key">

							<form:input path="shippingAddress.flatNo" placeholder="add flatno" />
							<br>

							<div class="clearfix"></div>
						</div>
						<input type="submit" value="register"/>
		 			 		
				</div>
			</div>
		</div>
		</div>
</form:form>

</body>
</html>
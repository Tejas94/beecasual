<%@include file="Header1.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<form:form  modelAttribute="billingAddress">
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>Billing Address</h3>			
							<div class="key">
							
							
								FlatNo. :${billingAddress.flatNo}						
								<div class="clearfix"></div>
							</div>
							<div class="key">
								street :${billingAddress.street}	<div class="clearfix"></div>
							</div>
							
							<div class="key">
								locatlity :${billingAddress.locatlity}	
								<div class="clearfix"></div>
							</div>
						
							<div class="key">
							city :${billingAddress.city}				
								<div class="clearfix"></div>
							</div>
							<div class="key">
							state :${billingAddress.state}				
								<div class="clearfix"></div>
							</div>
							<div class="key">
							pincode :${billingAddress.pincode}				
								<div class="clearfix"></div>
							</div>
						<div class="key">

							
							<div class="clearfix"></div>
						</div>
						<input name="_eventId_submit" type="submit" value="next"/>
		 			 		<input name="_eventId_edit" type="submit" value="edit"/>
				</div>
			</div>
		</div>
		</div>

</form:form>

</body>
</html>
<%@ include file="Footer.jsp" %>
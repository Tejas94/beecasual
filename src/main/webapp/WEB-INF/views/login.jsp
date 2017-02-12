<%@include file="Header1.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="perform_login">
		<div class="content">
				<!--login-->
			<div class="login">
				<div class="main-agileits" >
					<div class="form-w3agile form1"   >
						<h3>Login</h3>			
							<div class="key">
							
								
							<input name="userName" type="text" placeholder="username" />
								
								<div class="clearfix"></div>
							</div>
							<div class="key">
							<input name="userPassword" type="password" placeholder="password"/>
								<br>
								
								<div class="clearfix"></div>
							</div>
							<input type="submit" value="submit"/>
							<a href="/BeeCasual/reg"><input type="button" class="btn-blue-blue-white1" value="Register"/></a>
	
</div>
</div>
</div></div>
</form>
</body>
</html>
<%@ include file="Footer.jsp" %>
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
<style type="text/css">
th{
	padding: 0 20px 0 20px;
}
td{
	padding: 0 15px 0 15px;
	text-align: center;
}
</style>
</head>
<body>
<div align="center">
<form:form modelAttribute="subcategory" action="addSubCategory" >
<form:input path="subcategoryId" type="hidden"/>
<form:input path="subCategoryName" placeholder="add name"/>
<form:input path="subcategoryDescription" placeholder="add desc"/>
<input type="submit" value="Submit"/>
<form:select path="category.categoryName">
 <form:options items="${categoryList}" itemValue="categoryName" itemLabel="categoryName"/>
</form:select>

</form:form>
</div>
</body>
</html>

<%@include file="Footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
<form:form action="savecustomer" method="post">
	<table>
		<caption>Add Customer</caption>
	<tr>
		<th>customerEmailId</th>
		<th><form:input path="customerEmailId"/></th>	
	</tr>
	<tr>
		<th>customerName</th>
		<th><form:input path="customerName"/></th>
	</tr>
	<tr>
		<th>customerPassword</th>
		<th><form:input path="customerPassword"/></th>
	</tr>
	<tr>
		<th>customerAddress</th>
		<th><form:input path="customerAddress"/></th>
	</tr>
	<tr>
		<th>customerContact</th>
		<th><form:input path="customerContact"/></th>
	</tr>
	
	</table>
	<input type="submit" value="Save">
</form:form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
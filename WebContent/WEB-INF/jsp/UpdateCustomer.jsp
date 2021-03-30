<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
<form:form action="updatecustomer" method="post">
<table>
		<caption>Update Customer</caption>
	<tr>
		<th>customerEmailId</th>
		<th><form:input path="customerEmailId" value="${customer.customerEmailId}"/></th>	
	</tr>
	<tr>
		<th>customerName</th>
		<th><form:input path="customerName" value="${customer.customerName}"/></th>
	</tr>
	<tr>
		<th>customerPassword</th>
		<th><form:input path="customerPassword" value="${customer.customerPassword}"/></th>
	</tr>
	<tr>
		<th>customerAddress</th>
		<th><form:input path="customerAddress" value="${customer.customerAddress}"/></th>
	</tr>
	<tr>
		<th>customerContact</th>
		<th><form:input path="customerContact" value="${customer.customerAddress}"/></th>
	</tr>
	
	</table>
	<input type="submit" value="Update">
</form:form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
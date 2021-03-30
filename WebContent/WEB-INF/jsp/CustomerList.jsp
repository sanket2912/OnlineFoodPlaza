<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
<form:form>
	<table border="2" width="70%" cellpadding="2">
	<caption>Customer List</caption>
	<tr>
		<th>Customer EmailId</th>
		<th>Customer Name</th>
		<th>Customer Password</th>
		<th>Customer Address</th>
		<th>Customer Contact</th>
		
		<th>Edit</th>
		<th>Delete</th>
	</tr>
		<c:forEach var="customer" items="${customerList}">
		<tr>
			<td>${customer.customerEmailId}</td>
			<td>${customer.getCustomerName()}</td>
			<td>${customer.getCustomerPassword()}</td>
			<td>${customer.getCustomerAddress()}</td>
			<td>${customer.getCustomerContact()}</td>
			
			<td><a href="editCustomer?customerEmailId=${customer.customerEmailId}">edit</a></td>
			<td><a href="deleteCustomer?customerEmailId=${customer.customerEmailId}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</form:form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
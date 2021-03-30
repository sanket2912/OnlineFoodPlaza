<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food List</title>
</head>
<body>
	<%
	String customerEmail = (String) session.getAttribute("customerEmail");
	String adminEmail = (String) session.getAttribute("adminEmail");
	%>
	<jsp:include page="Header.jsp"></jsp:include>
<table border="2" width="70%" cellpadding="2">
	<caption>Food List</caption>
	<tr>
		<th>Food Id</th>
		<th>Food Name</th>
		<th>Food Type</th>
		<th>Food Category</th>
		<th>Food Price</th>
		<%if(customerEmail==null && adminEmail!=null){ %>
		<th>Update</th>
		<th>Delete</th>
		<%} %>
		<%if(customerEmail!=null && adminEmail==null){ %>
		<th>AddToCart</th>
		<%} %>
	</tr>
	
		

<c:forEach var="food" items="${foodList}">
<tr>
	<td>${food.getFoodId()}</td>
	<td>${food.getFoodName()}</td>
	<td>${food.getFoodType()}</td>
	<td>${food.getFoodCategory()}</td>
	<td>${food.getFoodPrice()}</td>
	<%if(customerEmail==null && adminEmail!=null){ %>
	<td><a href="editFood?foodId=${food.getFoodId()}">edit</a></td>
	<td><a href="deleteFood?foodId=${food.getFoodId()}">delete</a></td>
	<%} %>
	<%if(customerEmail!=null && adminEmail==null){ %>
		<th><a href="cartForm?foodId=${food.getFoodId()}">addToCart</a>
	<%} %>
</tr>
</c:forEach>

	
</table>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
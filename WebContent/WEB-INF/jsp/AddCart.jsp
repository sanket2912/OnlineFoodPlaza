<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
<form:form action="addToCart" method="post">
	<table>
		<caption>Add To Cart</caption>
		<tr>
			<td>Customer Email Id</td>
			<td><form:input path="customerEmailId"/></td>
		</tr>
		<tr>
			<td>Food Id</td>
			<td><form:input path="foodId" value="${food.foodId}"/></td>
		</tr>	
		<tr>
			<td>Food Name</td>
			<td><form:input path="foodName" value="${food.foodName}"/></td>
		</tr>
		<tr>
			<td>Cart Quantity</td>
			<td><form:input path="cartQuantity"/></td>
		</tr>
		<tr>
			<td>Total Price</td>
			<td><form:input path="totalPrice" /></td>
		</tr>
	</table>
	<input type="submit" value="AddToCart">
</form:form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
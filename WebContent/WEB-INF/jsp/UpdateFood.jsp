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
<form:form method="post" action="updatefood">
<table>
	<caption>Update Food</caption>
	<tr>
		<td>FoodId</td>
		<td><form:input path="foodId" type="number" value="${food.foodId}"/></td>
	</tr>
	<tr>
		<td>FoodName</td>
		<td><form:input path="foodName" value="${food.foodName}"/></td>
	</tr>
	<tr>
		<td>FoodType</td>
		<td><form:input path="foodType" value="${food.foodType}"/></td>
	</tr>
	<tr>
		<td>FoodCategory</td>
		<td><form:input path="foodCategory" value="${food.foodCategory}"/></td>
	</tr>
	<tr>
		<td>FoodPrice</td>
		<td><form:input path="foodPrice" type="number" value="${food.foodPrice}"/></td>
	</tr>
</table>
<input type="submit" value="Update">
</form:form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
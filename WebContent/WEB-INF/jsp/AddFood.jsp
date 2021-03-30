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
<form:form  action="saveFood" method="post">
<table>
<caption>Add Food</caption>
<tr>
	<td>Food Name:</td>
	<td><form:input path="foodName"/></td>
</tr>
<tr>
	<td>Food Type:</td>
	<td><form:input path="foodType"/>
</tr>
<tr>
	<td>Food Category</td>
	<td><form:input path="foodCategory"/></td>
</tr>
<tr>
	<td>Food Price</td>
	<td><form:input path="foodPrice" type="number"/></td>
</table>
<input type="submit" value="save"/>
</form:form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
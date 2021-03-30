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
<form:form action="cLogin" method="POST" >
<table>
	<tr>
		<td>Enter UserName</td>
		<td><form:input path="customerEmilId"/></td>
	</tr>
	<tr>
		<td>Enter Password</td>
		<td><form:input path="customerPassword"/></td>
	</tr>
</table>
<input type="submit" value="Submit">
</form:form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.foodplaza.pojo.Orders" %>
<%@ page import="com.foodplaza.dao.OrderDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<table align="center">
	<tr>
	<td>Total Price :</td>
	<td>${total}</td>
	</tr>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
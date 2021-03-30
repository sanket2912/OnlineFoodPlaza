<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form method="post" action="searchFoodForm">
<input type="text" name="foodName">
<input type="submit" value="Search">
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
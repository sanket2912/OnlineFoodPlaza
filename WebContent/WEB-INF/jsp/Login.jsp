<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h2 style="color:red">${failure}</h2>
<h2 style="color:green">${success}</h2>
<form action="login" method="post" >
<table>
	<tr>
		<th>Type</th>
		<td><select name="type">
		<option value="user">User</option>
		<option value="admin">admin</otion>
		</select>
		</td>
	</tr>
	<tr>
		<th>UserName:</th>
		<td><input type="text" name="customerEmailId"/></td>
	</tr>
	<tr>
		<th>Password</th>
		<td><input type="password" name="customerPassword"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"></td>
		<td><input type="reset" value="Cancel"></td>
	
	</tr>

</table>
<a href="resetpassword">reset password</a>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
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
<form method="post" action="changePass">
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
	<td>Enter Email Id:</td>
	<td><input type="text" name="email"></td>
</tr>
<tr>
	<td>Enter Password</td>
	<td><input type="password" name="pass"></td>
</tr>
</table>
<input type="submit" value="Change Password">
</form>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
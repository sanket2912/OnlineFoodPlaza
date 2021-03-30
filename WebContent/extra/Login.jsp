<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<form:form action="login" mehtod="post" modelAttribute="cust"><!-- by default form modelAttribute is command -->
<table>
	<tr>
		<th>Type</th>
		<td><form:radiobutton path="type" value="user" label="User"/>
			<form:radiobutton path="type" value="admin" label="Admin"/>
		</td>
	</tr>
	<tr>
		<th>UserName:</th>
		<td><form:input path="customerEmailId"/></td>
	</tr>
	<tr>
		<th>Password</th>
		<td><form:input  path="customerPassword"/></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login"></td>
		<td><input type="reset" value="Cancel"></td>
	</tr>
</table>
</form:form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <c:url value="/resources/css/templatemo_style.css" var="cssUrl" />
<link rel="stylesheet" href="${cssUrl}"> 
<c:url value="/resources/css/bootstrap.css" var="boots"/>
<link rel="stylesheet" href="${boots}">
<c:url value="/resources/images" var="img1"></c:url>
</head>
<body>
	<%
		String customerEmail = (String) session.getAttribute("customerEmail");
		String adminEmail = (String) session.getAttribute("adminEmail");
	%>

	<!--  Free CSS Template by TemplateMo.com  -->
	<div id="templatemo_container">
		<div id="templatemo_header">
			<div id="site_title"></div>
		</div>
		<!-- end of header -->
		<div id="templatemo_menu">
			<ul>
				<%if (customerEmail == null && adminEmail == null) {%>
				<li class="current">
				<a href="displayIndex"><b>Home</b></a></li>
				<li><a href="foodList"><b>Food List</b></a></li>
				<li><a href="customerForm"><b>Add Customer</b></a></li>
				<li><a href="loginpage"><b>Login</b></a></li>
				<%}%>

				<%if (customerEmail != null && adminEmail == null) {%>
				<li><a href="foodList"><b>Food List</b></a></li>
				<li><a href="resetpassword"><b>Change Password</b></a></li>
				<li><a href="cartList"><b>Cart List</b></a></li>
				<li><a href="logout"><b>Logout</b></a></li>
				<li><a href="editCustomer?customerEmailId=<%=customerEmail%>">edit</a></li>
				
				<%}%>
				<%if (customerEmail == null && adminEmail != null) {%>
				<li><a href="foodForm"><b>Add Food</b></a></li>
				<li><a href="foodList"><b>Food List</b></a></li>
				<li><a href="customerList"><b>Customer List</b></a></li>
				<li><a href="resetpassword"><b>Change Password</b></a></li>
				<li><a href="logout"><b>Logout</b></a></li>
				<%}%>
			</ul>
		</div>
		<div>
		${msg}
		</div>
		<!-- end of menu -->
</body>
</html>
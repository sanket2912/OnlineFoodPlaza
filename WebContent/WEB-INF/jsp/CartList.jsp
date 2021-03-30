<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
<form:form action="placeOrder">
<table border="2" width="70%" cellpadding="2">
<tr>
	<th>Cart Id</th>
	<th>Cart Quantity</th>
	<th>Customer Email Id</th>
	<th>Food Id</th>
	<th>Food Name</th>
	<th>Total Price</th>
	<th>Update</th>
	<th>Delete</th>
</tr>
<c:forEach var="cart" items="${cartList}">
<tr>
	<td>${cart.getCartId()}</td>
	<td>${cart.getCartQuantity()}</td>
	<td>${cart.getCustomerEmailId()}</td>
	<td>${cart.getFoodId()}</td>
	<td>${cart.getFoodName()}</td>
	<td>${cart.getTotalPrice()}</td>
	<input type="hidden" name="totalPrice" value="${cart.getTotalPrice()}">
	<input type="hidden" name="quantity" value="${cart.getCartQuantity()}">
	<td><a href="editCart?cartId=${cart.getCartId()}">edit</a></td>
	<td><a href="deleteCart?cartId=${cart.getCartId()}">Delete</a>
</tr>
</c:forEach>
</table>
<input type="submit" value="PLACEORDER"/>
&nbsp; &nbsp; &nbsp; &nbsp; 
<input type="submit" value="CANCEL"/>
<%-- <a href="placeOrder?totalPrice=${cart.getTotalPrice()}&quantity=${cart.getCartQuantity()}">Place Order</a> --%>
	</form:form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
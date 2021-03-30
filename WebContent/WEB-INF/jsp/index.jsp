	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tea and Meal - Free CSS Template</title>
<c:url value="/resources/css/templatemo_style.css" var="cssUrl" />
<link rel="stylesheet" href="${cssUrl}">
<c:url value="/resources/css/images" var="img1"></c:url>
<%
	response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
%>
<meta name="keywords" content="" />
<meta name="description" content="" />
</head>
<%--
<body>
<a href="foodForm">show food</a>
<a href="foodUpdateForm">update food</a>
<a href="foodList"> show food List</a>

<br>
<a href="customerForm">show customer</a>
<a href="customerUpdateForm">Update customer</a>
<a href="customerList">show customer List</a>

<br>
<a href="showCartList">show cart List</a>
<a href="customerLogin">Customer Login</a>
<a href="searchByFoodType?foodType=veg">serch by FoodType</a>
<a href="searchByCategory?foodCategory=solid">search by category</a>
</body>
</html> --%>


<%-- <link href="${pageContext.request.contextPath}/templatemo_style.css" rel="stylesheet" type="text/css" /> --%>


<body>

	<jsp:include page="Header.jsp"></jsp:include>
	<div>
		<h2 style="color: red" align=center></h2>
	</div>

	<div id="templatemo_top_dishes">
		<h1>Recommended Dishes</h1>
		<div class="top_dishes_box">
		<img src="${img1}/VegBiryani.jpeg" alt="image" width="205" height="150" />
			<h2>Veg Biryani</h2>
			<p>
				this vegetable biryani recipe is light, a bit spicy and super
				delicious. the subtle flavors of the garam masala, onions and curd
				are so infused in the vegetables. each bite of the vegetable had the
				taste, flavor and aroma of the masala as well as the unique taste of
				that veggie. <a href="#">Read more...</a>
			</p>
		</div>

		<div class="top_dishes_box">
			<img src="${img1}/PavBhaji.jpeg" alt="image" width="205" height="150" />
			<h2>Pav Bhaji</h2>
			<p>
				Pav Bhaji – a spicy curry of mixed vegetables (bhaji) cooked in a
				special blend of spices and served with soft buttered pav (bread bun
				shallow fried in butter), is any Indian food lover's dream. <a href="#">Read more...</a>
			</p>
		</div>

		<div class="top_dishes_box">
			<img src="${img1}/VegKholaPuri.jpeg" alt="image" width="205" height="150" />
			<h2>VegKhola Puri</h2>
			<p>
				veg kolhapuri is a spicy and tasty mix vegetable curry from
				kolhapuri cuisine. <a href="#">Read more...</a>
			</p>
		</div>

		<div class="top_dishes_box">
			<img src="${img1}/MuttonBiryani.jpeg" alt="image" width="205" height="150" />
			<h2>MuttonBiryani</h2>
			<p>
				The meat is flavoured with ginger, garlic, turmeric, red chili,
				cumin, coriander powder, lots of onion and tomato. It is first
				cooked as a thick curry and then cooked along with rice. <a href="#">Read
					more...</a>
			</p>
		</div>

		<div class="cleaner">&nbsp;</div>

	</div>
	<!-- end of top dishes -->

	<div id="templatemo_content">
		<span class="top"></span>
		<div id="templatemo_innter_content">

			<div id="templatemo_content_left">
				<h1>Welcome to our website</h1>
				<img src="${img1}/FoodPlaza.jpeg" alt="image" width="300" height="200" />

				<p>Donec malesuada elit vel enim. Lorem ipsum dolor sit amet,
					consectetur adipiscing elit. Suspendisse id velit elementum mi
					egestas ullamcorper. Vivamus nec dui.</p>
				<p>Suspendisse vitae nibh ac nunc mattis blandit. Morbi
					consectetur ullamcorper felis. Nulla nec elit. Aliquam et mauris.
					Ut euismod congue diam.</p>
				<a href="#">Read more...</a>


				<div class="cleaner_with_height">&nbsp;</div>

			</div>
			<!-- end of content left -->

			<div id="templatemo_content_right">
				<h1>What's new?</h1>
				<div class="right_column_section">
					<h2>Special meal for you</h2>
					<img src="${img1}/ButterChicken.jpeg" alt="image" width="205" />
					<p>ButterChicken-is a dish, originating in India, of chicken in
						a mildly spiced tomato sauce.</p>
					<a href="#">Read more...</a>
				</div>

			</div>
			<!-- end of content right -->
			<div class="cleaner">&nbsp;</div>
		</div>
		<div class="cleaner" style="background: #fff;">&nbsp;</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
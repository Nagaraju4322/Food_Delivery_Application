<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.raju.model.Menu"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Pizza Menu | FoodZone</title>
<link rel="stylesheet" href="Menu.css" />
</head>
<body>

	<!-- Header Section -->
	<header class="menu-header">
		<h1>🍕 FoodZone</h1>
		<p>Delicious pizzas, hot deals, and quick delivery!</p>
	</header>

	<section class="menu-list">
		<h3>Recommended</h3>

		<%
		List<Menu> getAllMenusByRestaurant = (List<Menu>) request.getAttribute("getAllMenusByRestaurant");
		for (Menu menu : getAllMenusByRestaurant) {
		%>

		<div class="menu-item">
			<div class="menu-info">
				<span class="veg-icon"></span>
				<h4><%=menu.getItemName()%></h4>
				<span class="price">₹<%=menu.getPrice()%></span>
				<p class="rating">⭐ <%=menu.getRating()%></p>
				<p class="desc"><%=menu.getDescription()%></p>
			</div>

			<div class="menu-image">
				<img src="<%=menu.getImagePath()%>" alt="<%=menu.getItemName()%>" />
				<form action="cart" method="post">
					<input type="hidden" name="itemId" value="<%=menu.getMenuId()%>">
					<input type="hidden" name="quantity" value="1"> 
					<input type="hidden" name="restaurantId" value="<%=menu.getRestaurantId()%>"> 
					<input type="hidden" name="action" value="add">
					<button class="add-btn">ADD</button>
				</form>
			</div>
		</div>

		<%
		}
		%>
	</section>

	
	

	<a href="index.jsp" class="back-link">← Back to Home</a>

</body>
</html>

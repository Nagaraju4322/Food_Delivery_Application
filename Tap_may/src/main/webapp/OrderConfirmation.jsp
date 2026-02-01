<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.raju.model.Orders" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Confirmation | Foodie App</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap"
	rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	background: linear-gradient(135deg, #fff5eb, #ffe0b3);
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	color: #333;
}

.confirmation-container {
	background: #fff;
	padding: 40px 30px;
	border-radius: 20px;
	box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
	text-align: center;
	width: 90%;
	max-width: 480px;
	animation: fadeIn 1s ease-in-out;
}

.checkmark {
	font-size: 70px;
	color: #2ecc71;
	margin-bottom: 15px;
	animation: pop 0.8s ease;
}

.confirmation-container h2 {
	font-size: 26px;
	color: #333;
	margin-bottom: 10px;
}

.confirmation-container p {
	font-size: 16px;
	color: #666;
	margin-bottom: 20px;
	line-height: 1.5;
}

.order-details {
	background: #fff7e6;
	border-left: 5px solid #ff9f43;
	padding: 15px;
	border-radius: 10px;
	margin-bottom: 20px;
	text-align: left;
}

.order-details p {
	margin-bottom: 6px;
	font-size: 15px;
	color: #444;
}

.back-btn, .home-btn {
	display: inline-block;
	text-decoration: none;
	background: #ff9f43;
	color: #fff;
	padding: 12px 25px;
	border-radius: 30px;
	transition: 0.3s ease;
	margin: 8px;
	font-weight: 600;
}

.back-btn:hover, .home-btn:hover {
	background: #e67e22;
}

@
keyframes fadeIn {from { opacity:0;
	transform: translateY(20px);
}

to {
	opacity: 1;
	transform: translateY(0);
}

}
@
keyframes pop { 0% {
	transform: scale(0);
	opacity: 0;
}
80
%
{
transform
:
scale(
1.1
);
opacity
:
1;
}
100
%
{
transform
:
scale(
1
);
}
}
</style>
</head>
<body>

	<div class="confirmation-container">
		<div class="checkmark">✔</div>
		<h2>Order Placed Successfully!</h2>
		<p>
			Thank you for Ordering from <strong>Foodie Zone</strong> 🍔 <br>Your
			delicious food is being prepared.
		</p>
		<% Orders orders=(Orders)session.getAttribute("orders");
					
					%>

		<div class="order-details">
			<p>
				<strong>Order ID:</strong>
				<%= session.getAttribute("orderId") %></p>
			<p>
				<strong>Customer Name:</strong>
				<%= session.getAttribute("username") %></p>
			<p>
				<strong>Payment Mode:</strong>
				<%= orders.getPaymentMode()%></p>
			<p>
			<%
			    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			    String date = sdf.format(new java.util.Date());
			%>
			<p><strong>Order Date:</strong> <%= date %></p>

				<strong>Order Status:</strong> Confirmed ✅
			</p>
		</div>
			<h2>Visit Again🙏</h2>

		<a href="Cart.jsp" class="back-btn">← Back to Cart</a> <a
			href="index.jsp" class="home-btn">🏠 Go to Home</a>
	</div>

</body>
</html>

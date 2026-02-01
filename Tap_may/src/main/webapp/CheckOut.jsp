<%@page import="com.raju.DAOImpl.UserDAOImpl,com.raju.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout | Foodie App</title>
<link rel="stylesheet" href="Checkout.css">
</head>
<body>
	<div class="checkout-container">
		<h2 class="checkout-title">🍽️ Checkout</h2>

		<form action="checkout" method="post" class="checkout-form">
			<div class="form-group">
				<label for="name">Full Name</label>
				<input type="text" id="name" name="name" placeholder="Enter your name" required>
			</div>

			<div class="form-group">
				<label for="phone">Mobile Number</label>
				<input type="tel" id="phone" name="phone" placeholder="Enter your phone number" required pattern="[0-9]{10}">
			</div>

			<div class="form-group">
				<label for="address">Delivery Address</label>
				<textarea id="address" name="address" rows="3" placeholder="Enter your delivery address" required></textarea>
			</div>

			<div class="form-group">
				<label for="paymentmethod">Select Payment Method</label>
				<select id="paymentmethod" name="paymentmethod" required>
					<option value="">-- Select Payment Method --</option>
					<option value="COD">💵 Cash on Delivery</option>
					<option value="UPI">📱 UPI (Google Pay / PhonePe / Paytm)</option>
					<option value="Card">💳 Debit / Credit Card</option>
					<option value="NetBanking">🏦 Net Banking</option>
					<option value="Wallet">👛 Wallet (Amazon Pay / Paytm Wallet)</option>
				</select>
			</div>

			<button type="submit" class="place-order-btn">🛒 Place Order</button>
		</form>

		<a href="Cart.jsp" class="back-link">← Back to Cart</a>
	</div>
</body>
</html>

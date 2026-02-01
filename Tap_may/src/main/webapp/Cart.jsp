<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.raju.model.CartItem,com.raju.DAOImpl.Cart"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cart | Foodie App</title>
    <link rel="stylesheet" href="Cart.css" />
</head>
<body>
    <div class="cart-page">
        <!-- CART SECTION -->
        <div class="cart-container">
            <h2 class="cart-title">Your Cart</h2>

            <%
                Cart cart = (Cart) session.getAttribute("cart");
                Integer restaurantId = (Integer) session.getAttribute("restaurantId");

                if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
                    for (CartItem item : cart.getItems().values()) {
            %>

            <div class="cart-row">
                <div class="cart-left">
                    <p class="item-name"><%=item.getName()%></p>
                    <p class="item-price">Price: ₹<%=item.getPrice()%></p>
                    <p class="item-total">Subtotal: ₹<%=item.getPrice() * item.getQuantity()%></p>
                </div>

                <div class="cart-right">
                    <div class="qty-box">
                        <form action="cart" method="post">
                            <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
                            <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="quantity" value="<%=item.getQuantity() - 1%>">
                            <button class="qty-btn" <% if (item.getQuantity() == 1) { %>disabled<% } %>>−</button>
                        </form>

                        <span class="qty-display"><%=item.getQuantity()%></span>

                        <form action="cart" method="post">
                            <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
                            <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
                            <input type="hidden" name="action" value="update">
                            <input type="hidden" name="quantity" value="<%=item.getQuantity() + 1%>">
                            <button class="qty-btn">+</button>
                        </form>

                        <form action="cart" method="post">
                            <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
                            <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
                            <input type="hidden" name="action" value="remove">
                            <button class="remove-btn">Remove</button>
                        </form>
                    </div>
                </div>
            </div>

            <% 
                }
            } else {
            %>
            <p class="empty-cart">Your cart is empty. Add some delicious food!</p>
            <% } %>

            <div class="cart-actions">
                <a href="menu?restaurantId=<%=session.getAttribute("restaurantId")%>">
                    <button class="add-more">Add More Items</button>
                </a>
                <a href="CheckOut.jsp">
                    <button class="checkout">Proceed to Checkout</button>
                </a>
            </div>
        </div>

        <!-- PRICE SUMMARY SECTION -->
        <div class="price-summary">
            <h2>Price Summary</h2>
            <div class="summary-details">
                <p>Item Total <span>₹<%=(cart != null) ? cart.getTotlaPrice() : 0%></span></p>
                <p>Platform Fee <span>₹5</span></p>
                <p>Delivery Fee <span>₹25</span></p>
                <hr>
                <p class="grand-total">Grand Total <span>₹<%=(cart != null) ? cart.getTotlaPrice() + 30 : 0%></span></p>
            </div>
        </div>
    </div>
</body>
</html>

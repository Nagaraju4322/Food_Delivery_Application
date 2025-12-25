<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List,com.raju.model.Restaurant,com.raju.model.User,com.raju.DAOImpl.RestaurantDAOImpl"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>FoodZone | Bengaluru</title>
<link rel="stylesheet" href="home.css" />

</head>
<body>

	<%
	
	 // ✅ Load restaurants if not already set
    if (request.getAttribute("allRestaurants") == null) {
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        java.util.List<Restaurant> allRestaurants = restaurantDAO.getAllRestaurants();
        request.setAttribute("allRestaurants", allRestaurants);
    }

   
    // ✅ Get logged-in user
    User user = (User) session.getAttribute("user");
%>

	<!-- Header Section -->
	<header class="main-header">
		<div class="logo">🍴 FoodieZone</div>
		<div class="location">
			<span>Delivery To: Bengaluru, 560076</span>
		</div>


		<div class="menu-toggle" id="menu-toggle">☰</div>

		<nav class="navbar" id="navbar">
			<ul>
				<li><div class="search">
						<input type="text" class="search-input"
							placeholder="Search for restaurants or dishes" />
					</div></li>
				<li><a href="#home">Home</a></li>
				<li><a href="#restaurants">Restaurants</a></li>
				<li><a href="#offers">Offers</a></li>
				<li><a href="#contact">Contact</a></li>


				<%
                if (user == null) {
            %>
				<li><a href="Login.jsp?redirect=home">👤 Login</a></li>
				<%
                } else {
            %>
				<li class="welcome-text">Welcome, <%= user.getUserName() %> 👋
				</li>
				<li><a href="LogoutServlet" class="login-btn">👤 Logout</a></li>
				<%
				session.setAttribute("user", user);
                }
            %>
				<li><div class="user-action">
						<a href="Cart.jsp" class="cart-icon"> 🛒 <span
							class="cart-count"><span class="cart-count"> <%= (session.getAttribute("cartCount") == null)
        ? 0
        : session.getAttribute("cartCount") %>
							</span> </span>
						</a>
					</div></li>
			</ul>

		</nav>
	</header>


	<!-- Hero Section -->
	<section class="hero-section" id="home">
		<div class="hero-container">
			<h1>Delicious Food Items & Fast Delivery 🍔</h1>
			<p>Order from your favorite restaurants and enjoy delicious food
				delivered to your door! 😋</p>
			<a href="#restaurants" class="order-button">Order Now</a>
		</div>
	</section>
	
	
	
	<!-- ================= ONLY MENU ITEMS MODIFIED ================= -->
	<section class="popular-section" id="fooditems">
		<h2>Menu Items</h2>
		<div class="items">

			<%-- Item 1: Pizza (restaurantId = 1) --%>
			<% if (user == null) { %>
			<a href="Index.html">
			<% } else { %>
			<a href="menu?restaurantId=1">
			<% } %>
				<div class="item-card">
					<img src="https://www.simplyrecipes.com/thmb/KRw_r32s4gQeOX-d07NWY1OlOFk=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Simply-Recipes-Homemade-Pizza-Dough-Lead-Shot-1c-c2b1885d27d4481c9cfe6f6286a64342.jpg"
						alt="Pizza" />
					<h3>Delicious Pizza</h3>
					<p>⭐️⭐️⭐️⭐️☆</p>
					<p>Price ₹250</p>
				</div>
			</a>

			<%-- Item 2: Burger (restaurantId = 2) --%>
			<% if (user == null) { %>
			<a href="Index.html">
			<% } else { %>
			<a href="menu?restaurantId=2">
			<% } %>
				<div class="item-card">
					<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1d_GL2C5tE1UWerwP7pRdu7PunZ9LzuNoPjieaGx8kdu_lde68epPaZAqWWLlchleQzE&usqp=CAU"
						alt="Cheese Burger" />
					<h3>Cheese Burger</h3>
					<p>⭐️⭐️⭐️⭐️⭐️</p>
					<p>Price ₹300</p>
				</div>
			</a>

			<%-- Item 3: Biryani (restaurantId = 3) --%>
			<% if (user == null) { %>
			<a href="Index.html">
			<% } else { %>
			<a href="menu?restaurantId=4">
			<% } %>
				<div class="item-card">
					<img src="https://recipe30.com/wp-content/uploads/2023/03/chicken-Biryani.jpg"
						alt="Biryani" />
					<h3>Spicy Hyderabadi Biryani</h3>
					<p>⭐️⭐️⭐️⭐️☆</p>
					<p>Price ₹350</p>
				</div>
			</a>

			<%-- Item 4: Dosa / Idly (restaurantId = 4) --%>
			<% if (user == null) { %>
			<a href="Index.html">
			<% } else { %>
			<a href="menu?restaurantId=10">
			<% } %>
				<div class="item-card">
					<img src="https://pipingpotcurry.com/wp-content/uploads/2020/12/how-to-make-dosa-crispy-PipingPotCurry.jpg"
						alt="Masala Dosa" />
					<h3>Masala Dosa</h3>
					<p>⭐️⭐️⭐️⭐️☆</p>
					<p>Price ₹100</p>
				</div>
			</a>
			
			
			
			

			<%-- Item 5: KFC (restaurantId = 5) --%>
			<% if (user == null) { %>
			<a href="Index.html">
			<% } else { %>
			<a href="menu?restaurantId=12">
			<% } %>
				<div class="item-card">
					<img src="https://cdn.sanity.io/images/kbqq3e0r/production/8cab9a549a5bc09e4bcc391632d8640d495f4bd3-1200x667.png"
						alt="KFC" />
					<h3>Spicy KFC</h3>
					<p>⭐️⭐️⭐️⭐️☆</p>
					<p>Price ₹550</p>
				</div>
			</a>
			
			
			
			
			<%-- Item 6: Sushi (restaurantId = 3) --%>
			<% if (user == null) { %>
			<a href="Index.html">
			<% } else { %>
			<a href="menu?restaurantId=3">
			<% } %>
				<div class="item-card">
					<img src="https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0c/e2/1a/ca/mais-opcoes.jpg"
						alt="Masala Dosa" />
					<h3>Sushi</h3>
					<p>⭐️⭐️⭐️⭐️☆</p>
					<p>Price ₹150</p>
				</div>
			</a>

		</div>
	</section>
	
	<!-- Restaurants Section -->
	<section class="restaurants-section" id="restaurants">
		<h2>Famous Restaurants, Bengaluru</h2>
		<div class="restaurants-grid">
			<%
            List<Restaurant> allRestaurants = (List<Restaurant>) request.getAttribute("allRestaurants");
            if (allRestaurants != null) {
                for (Restaurant restaurant : allRestaurants) {
        %>
			<div class="restaurant-card">
				<%
                if (user == null) {
            %>
				<a href="Index.html?redirect=home"> <%
                } else {
            %> <a
					href="menu?restaurantId=<%= restaurant.getRestaurantId() %>"> <%
                }
            %>
						<div class="restaurant-img">
							<img src="<%= restaurant.getImagePath() %>"
								alt="<%= restaurant.getName() %>" />
							<div class="rating-badge"><%= restaurant.getRating() %></div>
							<div class="time-tag"><%= restaurant.getEta() %></div>
						</div>
						<div class="restaurant-info">
							<h3><%= restaurant.getName() %></h3>
							<p><%= restaurant.getCuisineType() %></p>
							<button class="view-menu-btn">View Menu</button>
						</div>
				</a>
			</div>
			<%
			session.setAttribute("user", user);
                }
            }
        %>
		</div>
	</section>

	<!-- Offers Section -->
	<section class="offers-section" id="offers">
		<h2>Special Offers & Deals 🎁</h2>
		<div class="offers-grid">
			<div class="offer-card">
				<img
					src="https://i.pinimg.com/736x/a5/77/a1/a577a1d30853d67ff3810a00d5d83dfa.jpg"
					alt="Pizza Offer" />
				<h3>Buy 1 Get 1 Free Pizza</h3>
				<p>Enjoy two pizzas at the price of one. Offer valid till
					weekend!</p>
				<button>Grab Offer</button>
			</div>

			<div class="offer-card">
				<img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM-L0yaMwC2UA7dqhADYPYTQMaGzRq3gHfaA&s"
					alt="Burger Offer" />
				<h3>Flat 30% Off on Burgers</h3>
				<p>Get your favorite burgers at unbeatable prices.</p>
				<button>Grab Offer</button>
			</div>

			<div class="offer-card">
				<img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIT1KHEPYQLBRhVybjDrWhimTHDQO2rW4RPA&s"
					alt="Chai Offer" />
				<h3>Free Chai with Snacks</h3>
				<p>Order any snack and get a hot cup of chai absolutely free!</p>
				<button>Grab Offer</button>
			</div>
		</div>
	</section>

	<!-- Contact Section -->
	<section class="contact-section" id="contact">
		<h2>📞 Contact Us</h2>
		<p style="text-align: center;">We’d love to hear from you! Send us your queries or feedback.</p>

		<form class="contact-form">
			<div class="form-group">
				<input type="text" placeholder="Your Name" required />
			</div>
			<div class="form-group">
				<input type="email" placeholder="Your Email" required />
			</div>
			<div class="form-group">
				<textarea placeholder="Your Message" rows="5" required></textarea>
			</div>
			<button type="submit">Send Message</button>
		</form>
	</section>

	<!-- Footer ---------------------------------- -->
	<footer class="footer-section">
		<div class="footer-container">
			<!-- Quick Links -->
			<div class="footer-column">
				<h3>Quick Links</h3>
				<ul>
					<li><a href="#fooditems">Menu</a></li>
					<li><a href="#desserts">Desserts</a></li>
					<li><a href="#restaurants">Restaurants</a></li>
					<li><a href="#offers">Offers</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>

			<!-- Support -->
			<div class="footer-column">
				<h3>Support</h3>
				<ul>
					<li><a href="#">Help Center</a></li>
					<li><a href="#">Track Order</a></li>
					<li><a href="#">Refund Policy</a></li>
					<li><a href="#">Terms & Conditions</a></li>
				</ul>
			</div>

			<!-- Contact Info -->
			<div class="footer-column">
				<h3>Contact Info</h3>
				<ul>
					<li>📞 +91 76719 22642</li>
					<li>✉️ contact@foodiezone.com</li>
					<li>📍 BTM Layout, Bengaluru, Karnataka</li>
				</ul>
			</div>
		</div>
		<div class="footer-bottom">
			<p>© 2025 FoodZone. All Rights Reserved | Designed with ❤️ by
				Raju</p>
		</div>
	</footer>

    <script>
        // Mobile Menu Toggle
        const menuToggle = document.getElementById('menu-toggle');
        const navbar = document.getElementById('navbar');

        menuToggle.addEventListener('click', () => {
            navbar.classList.toggle('active');
        });

        // Header Scroll Effect
        const header = document.querySelector('.main-header');
        window.addEventListener('scroll', () => {
            if (window.scrollY > 50) {
                header.classList.add('scrolled');
            } else {
                header.classList.remove('scrolled');
            }
        });
    </script>
</body>
</html>

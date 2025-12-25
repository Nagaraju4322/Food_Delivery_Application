<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>FoodZone | User Registration 🍕</title>

  <style>
    /* Global reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: "Poppins", sans-serif;
    }

    body {
      display: flex;
      height: 100vh;
      background: #fff;
    }

    .container {
      display: flex;
      width: 100%;
      height: 100%;
    }

    .left {
      flex: 1;
      background: linear-gradient(135deg, #ff7043, #ff9800, #ffb74d);
      color: white;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
      padding: 2rem;
      position: relative;
      overflow: hidden;
    }

    .left h1 {
      font-size: 2.6rem;
      margin-bottom: 1rem;
      text-shadow: 0 0 20px rgba(255, 255, 255, 0.6);
    }

    .left p {
      font-size: 1.15rem;
      max-width: 400px;
      line-height: 1.6;
    }

    .left::after {
      content: "🍕 🍔 🍩 🥗 🌮";
      position: absolute;
      bottom: 10%;
      font-size: 2rem;
      opacity: 0.2;
      animation: floatEmojis 8s infinite ease-in-out alternate;
    }

    @keyframes floatEmojis {
      from { transform: translateY(0); }
      to { transform: translateY(-15px); }
    }

    .right {
      flex: 1;
      display: flex;
      justify-content: center;
      align-items: center;
      background: linear-gradient(135deg, #fff, #fff5ec);
      padding: 2rem;
    }

    form {
      width: 100%;
      max-width: 420px;
      background: rgba(255, 255, 255, 0.8);
      border-radius: 18px;
      padding: 2.5rem 2.8rem;
      box-shadow: 0 8px 30px rgba(0, 0, 0, 0.15);
      backdrop-filter: blur(10px);
      transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    form:hover {
      transform: translateY(-6px);
      box-shadow: 0 10px 40px rgba(255, 112, 67, 0.4);
    }

    h2 { text-align: center; margin-bottom: 1.6rem; color: #333; font-size: 1.9rem; }

    label {
      display: block;
      font-weight: 600;
      color: #444;
      margin-bottom: 6px;
    }

    input[type="text"], input[type="password"], input[type="email"], input[type="number"] {
      width: 100%;
      padding: 0.8rem;
      border: 1px solid #ccc;
      border-radius: 10px;
      margin-bottom: 1rem;
      outline: none;
      font-size: 1rem;
      transition: all 0.3s;
    }

    input[type="submit"] {
      width: 100%;
      padding: 0.9rem;
      background: linear-gradient(to right, #ff7043, #ff9800);
      color: white;
      border: none;
      border-radius: 10px;
      font-weight: 600;
      cursor: pointer;
      transition: all 0.3s ease;
    }

    /* Error Message Box */
    .error-box {
      background: #ffe6e6;
      color: #d32f2f;
      padding: 12px;
      margin-bottom: 15px;
      text-align: center;
      border-left: 4px solid #d32f2f;
      border-radius: 6px;
      font-weight: 600;
    }

    @media (max-width: 768px) {
      .container { flex-direction: column; }
      .left { display: none; }
      .right { background: linear-gradient(to bottom right, #fff, #ffe0b2); }
    }
  </style>
</head>

<body>
  <div class="container">

    <div class="left">
      <h1>Join the FoodZone Family 🍔</h1>
      <p>Sign up today to discover mouth-watering dishes 🍕, sizzling flavors 🌮, and heavenly desserts 🍩 just for you!</p>
    </div>

    <div class="right">
      <form action="registerServlet" method="post">

        <% 
            String msg = (String) request.getAttribute("msg");
            if (msg != null) { 
        %>
          <div class="error-box"><%= msg %></div>
        <% } %>

        <h2>Create Your Account 🥗</h2>

        <label>👤 Full Name</label>
        <input type="text" name="name" placeholder="Enter your name" required />

        <label>🍴 Username</label>
        <input type="text" name="username" placeholder="Choose a username" required />

        <label>🔒 Password</label>
        <input type="password" name="password" placeholder="Enter your password" required />

        <label>📧 Email</label>
        <input type="email" name="email" placeholder="Enter your email" required />

        <label>📱 Phone</label>
        <input type="number" name="phone" placeholder="Enter your phone number" required />

        <label>🏠 Address</label>
        <input type="text" name="address" placeholder="Enter your address" required />

        <input type="hidden" name="role" value="customer" />

        <input type="submit" value="🍩 Register Now" />

        <p>Already have an account? <a href="Login.jsp">Login Here 🍔</a></p>

      </form>
    </div>

  </div>
</body>
</html>

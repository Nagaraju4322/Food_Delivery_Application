<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>FoodZone | Login 🍔</title>
  
  <style>
    /* Reset & Fonts */
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

    /* Split container */
    .container {
      display: flex;
      width: 100%;
      height: 100%;
    }

    /* Left side (Food message area) */
    .left {
      flex: 1;
      background: linear-gradient(to bottom right, #ff7043, #ff9800);
      color: #fff;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
      padding: 2rem;
      position: relative;
      overflow: hidden;
    }

    .left img {
      position: absolute;
      bottom: 0;
      width: 60%;
      opacity: 0.15;
    }

    .left h1 {
      font-size: 2.8rem;
      margin-bottom: 1rem;
    }

    .left p {
      font-size: 2rem;
      max-width: 420px;
      line-height: 1.6;
      margin-top: 0.5rem;
      color: lightblue;
    }

    /* Right side (login form) */
    .right {
      flex: 1;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: #f9f9f9;
      padding: 2rem;
    }

    .login-box {
      width: 100%;
      max-width: 380px;
      background: #fff;
      padding: 2.5rem;
      border-radius: 14px;
      box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
      transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .login-box:hover {
      transform: translateY(-5px);
      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15);
    }

    .login-box h2 {
      text-align: center;
      margin-bottom: 1.5rem;
      color: #333;
      font-size: 1.8rem;
    }

    .login-box label {
      display: block;
      margin-bottom: 0.5rem;
      color: #555;
      font-weight: 500;
    }

    .login-box input[type="text"],
    .login-box input[type="password"] {
      width: 100%;
      padding: 0.8rem;
      border: 1px solid #ccc;
      border-radius: 8px;
      margin-bottom: 1rem;
      outline: none;
      transition: border-color 0.3s;
    }

    .login-box input[type="text"]:focus,
    .login-box input[type="password"]:focus {
      border-color: #ff7043;
    }

    .login-box input[type="submit"] {
      width: 100%;
      padding: 0.9rem;
      background: linear-gradient(to right, #ff7043, #ff9800);
      color: white;
      font-size: 1rem;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: 0.3s;
    }

    .login-box input[type="submit"]:hover {
      background: linear-gradient(to right, #ff5722, #ff9800);
      transform: scale(1.03);
    }

    .login-box p {
      text-align: center;
      margin-top: 1rem;
      color: #666;
      font-size: 0.95rem;
    }

    .login-box a {
      color: #ff7043;
      text-decoration: none;
      font-weight: 500;
    }

    .login-box a:hover {
      text-decoration: underline;
    }

    /* Error message box */
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

    /* Responsive */
    @media (max-width: 768px) {
      .container {
        flex-direction: column;
      }
      .left {
        display: none;
      }
      .right {
        flex: none;
        height: 100%;
        background: linear-gradient(to bottom right, #fff, #ffe0b2);
      }
    }
  </style>
</head>

<body>
  <div class="container">

    <!-- Left section -->
    <div class="left">
      <h1>Welcome to FoodZone 🍕</h1>
      <p>Craving something delicious? 🥗  
      Your next favorite meal is just a login away. 🍔  
      Taste happiness, one bite at a time! 😋</p>
      <img src="https://cdn-icons-png.flaticon.com/512/706/706195.png" alt="Food Illustration" />
    </div>

    <!-- Right section (Login Form) -->
    <div class="right">
      <form class="login-box" action="callingServlet" method="post">

        <!-- JSP ERROR MESSAGE -->
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
        %>
            <div class="error-box"><%= msg %></div>
        <% 
            }
        %>

        <h2>Login to Continue 🌮</h2>

        <label for="username">👤 Username</label>
        <input type="text" id="username" name="username" placeholder="Enter your username" required />

        <label for="password">🔒 Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required />

        <input type="submit" value="🍩 Login Now" />

        <p>Don't have an account? <a href="Register.jsp">Register 🍱</a></p>
      </form>
    </div>

  </div>
</body>
</html>

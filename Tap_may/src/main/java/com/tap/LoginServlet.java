package com.tap;

import java.io.IOException;
import java.util.List;

import com.raju.DAOImpl.UserDAOImpl;
import com.raju.model.User;
import com.raju.DAOImpl.RestaurantDAOImpl;
import com.raju.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/callingServlet")
public class LoginServlet extends HttpServlet {

    int count = 3;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDAOImpl udi = new UserDAOImpl();

        // ✔ Get User details
        User user = udi.getUser(username);

        // ❌ USER NOT FOUND
        if (user == null) {
            req.setAttribute("msg", "❌ No user found with that username!");
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
            return;
        }

        String pwd = user.getPassword();

        // ❌ WRONG PASSWORD
        if (!pwd.equals(password)) {

            if (count > 0) {
                req.setAttribute("msg", "⚠️ Invalid Password. You have " + count + " attempts left.");
                count--;

                RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
                rd.forward(req, resp);
                return;
            } else {
                req.setAttribute("msg", "🚫 Attempts over! Please contact Admin.");
                RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
                rd.forward(req, resp);
                return;
            }
        }

        // ✅ CORRECT PASSWORD → LOGIN SUCCESS
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setAttribute("callingloginservlet", user);
        session.setAttribute("username", username);

        // Load Restaurant List
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        List<Restaurant> allRestaurants = restaurantDAO.getAllRestaurants();
        req.setAttribute("allRestaurants", allRestaurants);

        String redirect = req.getParameter("redirect");

        // Go to home
        if (redirect != null && redirect.equals("home")) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}

package com.tap;

import java.io.IOException;


import com.raju.DAOImpl.UserDAOImpl;
import com.raju.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	

    	
       String name = req.getParameter("name");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String role = req.getParameter("role");

        UserDAOImpl udi = new UserDAOImpl();

        User user = new User(name, userName, password, email, phone, address, role, null, null);

        int res = udi.addUser(user);

        // SUCCESS
        if (res == 1) {
            req.setAttribute("msg", "✅ Hey " + name + ", your registration was successful! Please login.");
            RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
            rd.forward(req, resp);
        }
        // FAILED
        else {
            req.setAttribute("msg", "❌ Something went wrong. Try again!");
            RequestDispatcher rd = req.getRequestDispatcher("Register.jsp");
            rd.forward(req, resp);
        }
        
        System.out.println(res);
    }
}

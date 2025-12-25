package com.tap;

import java.io.IOException;



import java.util.List;

import com.raju.DAOImpl.RestaurantDAOImpl;
import com.raju.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class RestaurantServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		RestaurantDAOImpl rdi = new RestaurantDAOImpl();
		List<Restaurant> allRestaurants = rdi.getAllRestaurants();
		
		for (Restaurant restaurant : allRestaurants) {
			System.out.println(restaurant);
		}
		
		req.setAttribute("allRestaurants", allRestaurants);
		

		RequestDispatcher req2 = req.getRequestDispatcher("index.jsp");
		req2.forward(req, resp);



	}

}

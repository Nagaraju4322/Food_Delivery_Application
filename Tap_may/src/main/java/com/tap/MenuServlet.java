package com.tap;

import java.io.IOException;
import java.util.List;

import com.raju.DAOImpl.MenuDaoImpl;
import com.raju.model.Menu;
import com.raju.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menu")
public class MenuServlet  extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		MenuDaoImpl mdi = new MenuDaoImpl();

		int resid = Integer.parseInt(req.getParameter("restaurantId"));

		System.out.println(resid);

		List<Menu> getAllMenusByRestaurant = mdi.GetAllMenusByRestaurant(resid);

		for (Menu menu : getAllMenusByRestaurant) {

			System.out.println(menu);

		}
		
		HttpSession session = req.getSession(false);
		User user = (session != null) ? (User) session.getAttribute("user") : null;

		if (user == null) {
		    resp.sendRedirect("index.html?redirect=home");
		    return;
		}


		req.setAttribute("getAllMenusByRestaurant", getAllMenusByRestaurant);
		RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		rd.forward(req, resp);	

	}

}

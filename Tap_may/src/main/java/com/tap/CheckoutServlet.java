package com.tap;

import java.io.IOException;


import com.raju.DAO.OrderItemDAO;
import com.raju.DAO.OrdersDAO;
import com.raju.DAOImpl.Cart;
import com.raju.DAOImpl.OrderItemDAOImpl;
import com.raju.DAOImpl.OrdersDAOImpl;
import com.raju.model.CartItem;
import com.raju.model.OrderItem;
import com.raju.model.Orders;
import com.raju.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet  extends HttpServlet {

	private OrdersDAO ordersDAO;
	private OrderItemDAO orderItemImpl;

	@Override
	public void init() throws ServletException {

		ordersDAO = new OrdersDAOImpl();
		orderItemImpl = new OrderItemDAOImpl();
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Cart cart	 = (Cart)session.getAttribute("cart");
		User user =(User)session.getAttribute("callingloginservlet");
		if(cart !=null && user !=null && !cart.getItems().isEmpty())
		{
			String paymentMethod = req.getParameter("paymentmethod");
			String address = req.getParameter("address");
			
			
			int userId = user.getUserId();
			int restaurantId = (int)session.getAttribute("restaurantId");
			String status = "Pending";
			System.out.println("UserId :"+userId);
			System.out.println("restaurantId : "+restaurantId);
			
			Orders orders = new Orders(userId, restaurantId, null, restaurantId, status, paymentMethod, address);
			
			


			float totalAmount = 0;
			for(CartItem item :cart.getItems().values())
			{
				totalAmount += item.getPrice()*item.getQuantity();

			}

			orders.setTotalAmount(totalAmount);
			
			int orderId = ordersDAO.addOrders(orders);
			

			for(CartItem item :cart.getItems().values())
			{
				int itemId = item.getItemId();
				double price = item.getPrice();
				int quantity = item.getQuantity();
				double totalPrice = price*quantity;
				OrderItem orderItem  = new OrderItem(orderId, itemId, quantity, totalPrice);
				orderItemImpl.addOrderItem(orderItem);

			}
			
			
			
			session.removeAttribute("cart");
			session.setAttribute("orders", orders);
			session.setAttribute("orderId", orderId);
			session.setAttribute("paymentMethod", paymentMethod);
			resp.sendRedirect("OrderConfirmation.jsp");




		}
		else
		{
			resp.sendRedirect("Cart.jsp");
		}

	}

}

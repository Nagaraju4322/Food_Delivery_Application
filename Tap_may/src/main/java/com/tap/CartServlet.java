package com.tap;

import java.io.IOException;
import com.raju.DAOImpl.Cart;
import com.raju.DAOImpl.MenuDaoImpl;
import com.raju.model.CartItem;
import com.raju.model.Menu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    HttpSession session = req.getSession();

	    Cart cart = (Cart) session.getAttribute("cart");
	    Integer oldRestaurantId = (Integer) session.getAttribute("restaurantId");

	    String action = req.getParameter("action");
	    String restaurantId = req.getParameter("restaurantId");

	    int newRestaurantId = 0;
	    if (restaurantId != null && !restaurantId.isEmpty()) {
	        newRestaurantId = Integer.parseInt(restaurantId);
	    }

	    // ✔️ Do NOT clear cart on restaurant switch
	    if (newRestaurantId != 0) {
	        session.setAttribute("restaurantId", newRestaurantId);
	    }

	    // Create cart if not exists
	    if (cart == null) {
	        cart = new Cart();
	        session.setAttribute("cart", cart);
	    }

	    // Do actions
	    if ("add".equals(action)) {
	        addItemToCart(req, cart);
	    } else if ("update".equals(action)) {
	        updateCartItem(req, cart);
	    } else if ("remove".equals(action)) {
	        removeCartItem(req, cart);
	    }

	    session.setAttribute("cart", cart);
	    resp.sendRedirect("Cart.jsp");
	}


    private void addItemToCart(HttpServletRequest req, Cart cart) {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            MenuDaoImpl impl = new MenuDaoImpl();
            Menu menuItem = impl.getMenu(itemId);

            if (menuItem != null) {
                CartItem item = new CartItem(menuItem.getMenuId(), menuItem.getItemName(), menuItem.getPrice(), quantity);
                cart.addCartItem(item);
                
                
             // 🔥 Update cart count in session
                HttpSession session = req.getSession();
                Integer cartCount = (Integer) session.getAttribute("cartCount");
                if (cartCount == null) cartCount = 0;

                cartCount += quantity;  // increase based on quantity
                session.setAttribute("cartCount", cartCount);

            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid parameters for addItemToCart");
        }
    }

    private void updateCartItem(HttpServletRequest req, Cart cart) {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            cart.updateCartItem(itemId, quantity);
        } catch (NumberFormatException e) {
            System.out.println("Invalid parameters for updateCartItem");
        }
    }

    private void removeCartItem(HttpServletRequest req, Cart cart) {
        try {
            int itemId = Integer.parseInt(req.getParameter("itemId"));
            cart.deleteCartItem(itemId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid parameters for removeCartItem");
        }
    }
}

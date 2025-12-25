package com.raju.helper;

import java.sql.Timestamp;
import java.util.List;

import com.raju.DAOImpl.OrderItemDAOImpl;
import com.raju.DAOImpl.OrdersDAOImpl;
import com.raju.DAOImpl.UserDAOImpl;
import com.raju.model.OrderItem;
import com.raju.model.Orders;
import com.raju.model.User;

public class Launch {

	public static void main(String[] args) {
		

        UserDAOImpl udi = new UserDAOImpl();

      udi.deleteUser(5);
		
		
		
	}

}

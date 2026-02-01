package com.raju.DAO;

import java.util.List;

import com.raju.model.Orders;

public interface OrdersDAO 
{
	
	int addOrders(Orders order);
	Orders getOrders(int id);
	void updateOrder(Orders order);
	void deleteOrders(int id);
	List<Orders> GetAllOrders();

}

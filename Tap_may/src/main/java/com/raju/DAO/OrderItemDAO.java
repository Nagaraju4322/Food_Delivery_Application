package com.raju.DAO;

import java.util.List;

import com.raju.model.OrderItem;

public interface OrderItemDAO 
{
	void addOrderItem(OrderItem oItem);
	OrderItem getOrderItem(int id);
	void updateOrderItem(OrderItem oItem);
	void deleteOrderItem(int id);
	List<OrderItem> getAllOrderItems();

}

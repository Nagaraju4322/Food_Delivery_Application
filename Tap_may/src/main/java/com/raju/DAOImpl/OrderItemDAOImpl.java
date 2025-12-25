package com.raju.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.raju.DAO.OrderItemDAO;
import com.raju.helper.DatabaseConnection;
import com.raju.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

	private static final String Insert_Query = "INSERT INTO `OrderItem`(`orderItemId`,`orderId`,`menuId`,`quantity`,`totalPrice`) VALUES(?,?,?,?,?)";
	private static final String Get_Query = "SELECT * FROM `OrderItem` WHERE `OrderItemId` = ?";
	private static final String Update_Query = "UPDATE `OrderItem` SET `orderId`=?,`menuId`=?,`quantity`=?,`totalPrice`= ?  WHERE orderItemId = ?";
	private static final String Delete_Query = "DELETE FROM `orderItem` WHERE `orderItemId` = ?";
	private static final String Get_All_OrderItems = "SELECT * FROM `OrderItem`";
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ADD ORDERITEM  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@Override
	public void addOrderItem(OrderItem oi) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Insert_Query);
			pstmt.setInt(1, oi.getOrderItemId());
			pstmt.setInt(2, oi.getOrderId());
			pstmt.setInt(3, oi.getMenuId());
			pstmt.setInt(4, oi.getQuantity());
			pstmt.setDouble(5, oi.getTotalPrice());
			
			int x = pstmt.executeUpdate();
			
			System.out.println(x+" Row Inserted");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  GET ORDERITEM  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public OrderItem getOrderItem(int id) 
	{
		 OrderItem orderItem=null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_Query);
			pstmt.setInt(1, id);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next())
			{
				orderItem = new OrderItem(
							resultSet.getInt("orderItemId")
							,resultSet.getInt("orderId")
							,resultSet.getInt("menuId")
							,resultSet.getInt("quantity")
							,resultSet.getFloat("totalPrice")
						);
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderItem;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  UPDATE ORDERITEM  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void updateOrderItem(OrderItem oItem) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Update_Query);
			pstmt.setInt(1, oItem.getOrderId());
			pstmt.setInt(2, oItem.getMenuId());
			pstmt.setInt(3, oItem.getQuantity());
			pstmt.setDouble(4, oItem.getTotalPrice());
			pstmt.setInt(5, oItem.getOrderItemId());
			
			int x = pstmt.executeUpdate();
			System.out.println(x+" Row Updated");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  DELETE ORDERITEM  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void deleteOrderItem(int id) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Delete_Query);
			
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			System.out.println(res+" Row Deleted");
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  GET ALL ORDERITEMS  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public List<OrderItem> getAllOrderItems() 
	{
		
		ArrayList<OrderItem> list = new ArrayList<OrderItem>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_All_OrderItems);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next())
			{
				OrderItem orderItem = new OrderItem(
							resultSet.getInt("orderItemId")
							,resultSet.getInt("orderId")
							,resultSet.getInt("menuId")
							,resultSet.getInt("quantity")
							,resultSet.getFloat("totalPrice")
						);
				list.add(orderItem);
			}
			
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

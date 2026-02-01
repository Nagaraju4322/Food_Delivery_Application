package com.raju.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.raju.DAO.OrdersDAO;
import com.raju.helper.DatabaseConnection;
import com.raju.model.Orders;

public class OrdersDAOImpl implements OrdersDAO 
{


	private static final String Add_Order = "INSERT INTO `orders` (`orderId`,`userId`,`restaurantId`,`orderDate`,`totalAmount`,`status`,`paymentMode`,address)"
			+"VALUES (?,?,?,?,?,?,?,?)";
	private static final String Get_Order = "SELECT * FROM `ORDERS` WHERE `ORDERID`= ?";
	private static final String Update_Order = "UPDATE `ORDERS` SET `userId` =?,`restaurantId`=?,`totalAmount`=?,`status`=?,`paymentMode`=? `address`= ? WHERE `orderId`=?" ;
	private static final String Delete_Order = "DELETE FROM `orders` WHERE `orderId`= ?";
	private static final String Get_All_Orders = "SELECT * FROM `orders`";
	private int orderId;

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ADD ORDERS  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@Override
	public int addOrders(Orders order) 
	{

		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Add_Order,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, order.getOrderId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setInt(3, order.getRestaurantId());
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setDouble(5, order.getTotalAmount());
			pstmt.setString(6, order.getStatus());
			pstmt.setString(7, order.getPaymentMode());
			pstmt.setString(8, order.getAddress());

			int x = pstmt.executeUpdate();
			ResultSet keys = pstmt.getGeneratedKeys();
			while(keys.next())
			{
				orderId = keys.getInt(1);
				
			}
			System.out.println(x+" Item  Ordered");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderId;

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> GET ORDERS  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public Orders getOrders(int id) 
	{
		Orders orders=null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_Order);
			pstmt.setInt(1, id);
			ResultSet Rset = pstmt.executeQuery();

			while (Rset.next()) 
			{
				orders = new Orders(Rset.getInt("OrderId")
						,Rset.getInt("UserId")
						,Rset.getInt("restaurantId")
						,Rset.getTimestamp("OrderDate")
						,Rset.getFloat("TotalAmount")
						,Rset.getString("Status")
						,Rset.getString("PaymentMode")
						,Rset.getString("address"));




			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orders;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  UPDATE ORDERS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void updateOrder(Orders order) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Update_Order);

			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getRestaurantId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getStatus());
			pstmt.setString(5, order.getPaymentMode());
			pstmt.setString(6, order.getAddress());
			pstmt.setInt(7, order.getOrderId());

			int x = pstmt.executeUpdate();

			System.out.println(x);





		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> DELETE ORDERS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void deleteOrders(int id) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Delete_Order);

			pstmt.setInt(1, id);
			int x = pstmt.executeUpdate();
			System.out.println(x+" Row deleted");






		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> GET ALL ORDERS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public List<Orders> GetAllOrders() 
	{
		ArrayList<Orders> list = new ArrayList<Orders>();

		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_All_Orders);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) 
			{
				Orders orders = new Orders(resultSet.getInt("OrderId")
						,resultSet.getInt("UserId")
						,resultSet.getInt("restaurantId")
						,resultSet.getTimestamp("OrderDate")
						,resultSet.getFloat("TotalAmount")
						,resultSet.getString("Status")
						,resultSet.getString("PaymentMode")
						,resultSet.getString("address"));


				list.add(orders); 


			}






		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return list;
	}

}

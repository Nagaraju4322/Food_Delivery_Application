package com.raju.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.raju.DAO.RestaurantDAO;
import com.raju.helper.DatabaseConnection;
import com.raju.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {

	private static final String Insert_Restaurant = "INSERT INTO `Restaurant` (`restaurantId`,`name`,`address`,`phone`,`rating`,`cuisineType`,`isActive`,`eta`,`adminUserId`,`imagePath`) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String Get_Restaurant = "SELECT * FROM `restaurant` where `restaurantId`= ? ";
	private static final String Update_Restaurant = "UPDATE `restaurant` SET `restaurantId`= ?,`name`= ?,`address`= ?,`phone`= ?,`rating`= ?,`cuisineType`= ?,`isActive`= ?,`eta`= ?,`adminUserId`= ?,`imagePath`= ?"
			+ "WHERE restaurantId= ?";
	private static final String Delete_Restaurant = "DELETE FROM `restaurant` WHERE `restaurantId`= ?";
	private static final String Get_All_restaurants = "SELECT * FROM restaurant ";




	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ADD RESTAURANT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@Override
	public void addRestaurant(Restaurant res) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Insert_Restaurant);
			pstmt.setInt(1, res.getRestaurantId());
			pstmt.setString(2, res.getName());
			pstmt.setString(3, res.getAddress());
			pstmt.setString(4, res.getPhone());
			pstmt.setFloat(5, res.getRating());
			pstmt.setString(6, res.getCuisineType());
			pstmt.setBoolean(7, res.getisActive());
			pstmt.setString(8, res.getEta());
			pstmt.setInt(9, res.getAdminUserId());
			pstmt.setString(10, res.getImagePath());

			int rowsAffected = pstmt.executeUpdate();
			System.out.println(rowsAffected+" Row Affected In Restaurant Table");

		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  GET RESTAURANT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public Restaurant getRestaurant(int id) 
	{
		Restaurant restaurant=null;

		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_Restaurant);

			pstmt.setInt(1, id);
			ResultSet resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				restaurant = new Restaurant(resultSet.getInt("restaurantId")
						,resultSet.getString("name")
						,resultSet.getString("address")
						,resultSet.getString("phone")
						,resultSet.getFloat("rating")
						,resultSet.getString("cuisineType")
						,resultSet.getBoolean("isActive")
						,resultSet.getString("eta")
						,resultSet.getInt("adminUserId")
						,resultSet.getString("imagePath"));
			}

		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

		return restaurant;
	}


	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  UPDATE RESTAURANT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	@Override
	public void updateRestaurant(Restaurant res) 
	{
		try 
		{
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Update_Restaurant);
			pstmt.setInt(1, res.getRestaurantId());
			pstmt.setString(2, res.getName());
			pstmt.setString(3, res.getPhone());
			pstmt.setString(4, res.getAddress());
			pstmt.setFloat(5, res.getRating());
			pstmt.setString(6, res.getCuisineType());
			pstmt.setBoolean(7, res.getisActive());
			pstmt.setString(8, res.getEta());
			pstmt.setInt(9, res.getAdminUserId());
			pstmt.setString(10, res.getImagePath());
			pstmt.setInt(11, res.getRestaurantId());

			int x = pstmt.executeUpdate();
			System.out.println(x+" Row Updated");





		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}


	}



	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  DELETE RESTAURANT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	@Override
	public void deleteRestaurant(int id) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Delete_Restaurant);
			pstmt.setInt(1, id);

			int x = pstmt.executeUpdate();
			System.out.println(x+"Row Deleted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  GET ALL RESTAURANTS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	@Override
	public List<Restaurant> getAllRestaurants() 
	{
		Restaurant restaurant=null;
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_All_restaurants);

			ResultSet resultSet = pstmt.executeQuery();

			while(resultSet.next())
			{
				restaurant = new Restaurant(resultSet.getInt("restaurantId")
						,resultSet.getString("name")
						,resultSet.getString("address")
						,resultSet.getString("phone")
						,resultSet.getFloat("rating")
						,resultSet.getString("cuisineType")
						,resultSet.getBoolean("isActive")
						,resultSet.getString("eta")
						,resultSet.getInt("adminUserId")
						,resultSet.getString("imagePath"));
				list.add(restaurant);


			}












		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

}

package com.raju.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.raju.DAO.MenuDAo;
import com.raju.helper.DatabaseConnection;
import com.raju.model.Menu;

public class MenuDaoImpl implements MenuDAo 
{



	private static final String Insert_Query = "INSERT INTO `menu`(`menuId`,`restaurantId`,`itemName`,`description`,`price`,`rating`,`isAvailable`,`imagePath`)VALUES (?,?,?,?,?,?,?,?)";
	private static final String Get_Menu = "SELECT * FROM `menu` WHERE `menuId` = ?";
	private static final String Update_Menu = "UPDATE `menu` SET `menuId`= ?,`restaurantId`= ?,`itemName`= ?,`description`= ?,`price`= ?,`rating`= ?,`isAvailable`= ?,`imagePath`= ?"
			+ "WHERE menuId = ? ";
	private static final String Delete_Menu = "DELETE FROM `menu` WHERE `menuId` = ?";
	private static final String Get_All_Menus = "SELECT * FROM `menu`";
	private static final String Get_All_Menus_By_Restaurant = "SELECT * FROM `menu` WHERE `restaurantId` = ?";

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ADD MENU   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@Override
	public void addMenu(Menu menu) 
	{
		try 
		{

			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Insert_Query);

			pstmt.setInt(1, menu.getMenuId());
			pstmt.setInt(2, menu.getRestaurantId());
			pstmt.setString(3, menu.getItemName());
			pstmt.setString(4, menu.getDescription());
			pstmt.setFloat(5, menu.getPrice());
			pstmt.setFloat(6, menu.getRating());
			pstmt.setBoolean(7, menu.getIsAvailable());
			pstmt.setString(8, menu.getImagePath());

			int x = pstmt.executeUpdate();
			System.out.println(x+" Row Inserted in Menu");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> GET MENU  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public Menu getMenu(int id) 
	{
		Menu menu=null;
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Get_Menu);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			while(result.next())
			{
				menu = new Menu(result.getInt("menuId")
						,result.getInt("restaurantId")
						,result.getString("itemName")
						,result.getString("Description")
						,result.getFloat("price")
						,result.getFloat("rating")
						,result.getBoolean("isAvailable")
						,result.getString("imagePath")
						);
			}
		} 
		catch (SQLException e) 
		{

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menu;
	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> UPDATE MENU  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void UpdateMenu(Menu menu) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Update_Menu);

			pstmt.setInt(1, menu.getMenuId());
			pstmt.setInt(2, menu.getRestaurantId());
			pstmt.setString(3, menu.getItemName());
			pstmt.setString(4, menu.getDescription());
			pstmt.setFloat(5, menu.getPrice());
			pstmt.setFloat(6, menu.getRating());
			pstmt.setBoolean(7, menu.getIsAvailable());
			pstmt.setString(8, menu.getImagePath());
			pstmt.setInt(9, menu.getMenuId());
			int res = pstmt.executeUpdate();
			System.out.println(res);



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  DELETE MENU >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void DeleteMenu(int id) 
	{

		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Delete_Menu);
			pstmt.setInt(1, id);
			int x = pstmt.executeUpdate();
			System.out.println(x+" Row Deleted ");



		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  GET ALL MENUS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public List<Menu> GetAllMenus() 
	{

		ArrayList<Menu> list = new ArrayList<Menu>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_All_Menus);

			ResultSet result = pstmt.executeQuery();

			while(result.next())
			{
				Menu  menu = new Menu(result.getInt("menuId")
						,result.getInt("restaurantId")
						,result.getString("itemName")
						,result.getString("Description")
						,result.getFloat("price")
						,result.getFloat("rating")
						,result.getBoolean("isAvailable")
						,result.getString("imagePath")
						);
				list.add(menu);

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}




	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  GET ALL MENUS  BY RESTAURANT   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>




	public List<Menu> GetAllMenusByRestaurant(int id)
	{
		ArrayList<Menu> list = new ArrayList<Menu>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_All_Menus_By_Restaurant);

			pstmt.setInt(1, id);

			ResultSet result = pstmt.executeQuery();

			while(result.next())
			{
				Menu  menu = new Menu(result.getInt("menuId")
						,result.getInt("restaurantId")
						,result.getString("itemName")
						,result.getString("Description")
						,result.getFloat("price")
						,result.getFloat("rating")
						,result.getBoolean("isAvailable")
						,result.getString("imagePath")
						);
				list.add(menu);

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}



}



































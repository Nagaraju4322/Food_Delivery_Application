package com.raju.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.raju.DAO.UserDAO;
import com.raju.helper.DatabaseConnection;
import com.raju.model.User;

public class UserDAOImpl implements UserDAO 
{
	private static final String Delete_User = "DELETE from `user` where `userid` = ?";

	private static final String Get_All_Users = "SELECT * FROM `user`";

	private static String Insert_User="INSERT INTO `user`(`name`,`username`,`password`,`email`,`phone`,`address`,"
			+ " `role`,`createddate`,`lastlogindate`) values (?,?,?,?,?,?,?,?,?)";

	private static String Get_User="SELECT * FROM `user` where `username`=?";

	private static String Update_User="UPDATE `user` SET `userid`= ?,`name`= ?,`username`= ?,`password`= ?,"
			+ "`email`= ?,`phone`= ?,`address`= ? where `userid` = ? ";

	private int x;



	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    INSERT USER    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@Override
	public int addUser(User user) 
	{
		int x=0;


		try(Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Insert_User);)
		{


			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhone());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getRole());
			preparedStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			preparedStatement.setTimestamp(9, new Timestamp(System.currentTimeMillis()));


			x = preparedStatement.executeUpdate();
			

		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(x);
		return x;
	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   GET USER   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public User getUser(String  username)  
	{
		User user=null;

		try
		{
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(Get_User);



			preparedStatement.setString(1,username);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next())
			{


				user=new User(res.getInt("userId"),res.getString("name")
						,res.getString("username")
						,res.getString("password")
						,res.getString("email")
						,res.getString("Phone")
						,res.getString("address")
						,res.getString("role")
						,res.getTimestamp("createddate")
						,res.getTimestamp("lastlogindate"));


			} 
		}
		catch (SQLException e) {

			e.printStackTrace();
		}

		return user;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>      UPDATE USER   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void updateUser(User user) 
	{
		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Update_User);

			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getAddress());
			pstmt.setInt(8, user.getUserId());







			int res = pstmt.executeUpdate();
			System.out.println(res);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   DELETE USER   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public void deleteUser(int id) {

		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Delete_User);

			pstmt.setInt(1, id);
			int x = pstmt.executeUpdate();
			System.out.println(x);



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>     GET ALL USERS  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Override
	public List<User> getAllUsers() 
	{
		ArrayList<User> list = new ArrayList<User>();
		User user=null;

		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(Get_All_Users);

			ResultSet resultSet = pstmt.executeQuery();



			while(resultSet.next())
			{


				user=new User(resultSet.getInt("userId")
						,resultSet.getString("name")
						,resultSet.getString("username")
						,resultSet.getString("password")
						,resultSet.getString("email")
						,resultSet.getString("Phone")
						,resultSet.getString("address")
						,resultSet.getString("role")
						,resultSet.getTimestamp("createddate")
						,resultSet.getTimestamp("lastlogindate"));


				list.add(user);


			} 

		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}


		return list;
	}

}

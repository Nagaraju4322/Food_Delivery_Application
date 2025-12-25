package com.raju.DAO;

import java.util.List;

import com.raju.model.User;

public interface UserDAO 
{
	int addUser(User u);
	User getUser(String username);
	void updateUser(User u);
	void deleteUser(int id);
	List<User> getAllUsers();

}

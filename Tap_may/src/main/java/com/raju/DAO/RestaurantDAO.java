package com.raju.DAO;

import java.util.List;

import com.raju.model.Restaurant;

public interface RestaurantDAO 
{
	
	
	void addRestaurant(Restaurant r);
	Restaurant getRestaurant(int id);
	void updateRestaurant(Restaurant r);
	void deleteRestaurant(int id);
	List<Restaurant> getAllRestaurants();


}

package com.raju.DAO;

import java.util.List;


import com.raju.model.Menu;

public interface MenuDAo 
{

	void addMenu(Menu menu);
	Menu getMenu(int id);
	void UpdateMenu(Menu menu);
	void DeleteMenu(int id);
	List<Menu> GetAllMenus();
	List<Menu> GetAllMenusByRestaurant(int id);

}

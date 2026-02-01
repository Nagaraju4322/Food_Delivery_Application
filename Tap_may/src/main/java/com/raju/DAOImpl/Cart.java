package com.raju.DAOImpl;

import java.util.HashMap;
import java.util.Map;

import com.raju.model.CartItem;

public class Cart {


	private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();

	public void addCartItem(CartItem cItem) 
	{
		if (items.containsKey(cItem.getItemId()))
		{
			CartItem existing = items.get(cItem.getItemId());
			existing.setQuantity(existing.getQuantity() + cItem.getQuantity());
		} else
		{
			items.put(cItem.getItemId(), cItem);
		}

	}

	public void updateCartItem(int id,int quantity) 
	{
		if(items.containsKey(id))
		{
			if(quantity<=0)
			{
				items.remove(id);
			}
			else
			{
				CartItem item=items.get(id);
				item.setQuantity(quantity);
			}
		}
	}

	public void deleteCartItem(int id) 
	{
		items.remove(id);
	}

	public Map<Integer, CartItem> getItems() 
	{

		return items;
	}

	public double getTotlaPrice() 
	{

		return items.values().stream().mapToDouble(item-> item.getPrice() * item.getQuantity()).sum();

	}

	private void clear()
	{
		items.clear();
	}



}



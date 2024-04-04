package com.customer.dao;

import java.util.List;

import com.customer.entity.Inventory;

public interface InventoryDao {
	Inventory createInventory(Inventory inventory);
	 Inventory getInventoryById(String inventoryID);
	 List<Inventory> getAllInventory();
	 void updateInventory(Inventory inventory);
	 void deleteInventory(Inventory inventory);
}

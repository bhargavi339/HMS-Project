package com.customers;

import java.util.List;
import java.util.Scanner;

import com.customer.dao.InventoryDao;
import com.customer.daoImpl.InventoryDaoImpl;
import com.customer.entity.Inventory;

public class InventoryOperations {
	static Scanner sc=new Scanner(System.in);
	static InventoryDao inventoryDao=new InventoryDaoImpl();
	static void inventoryDetails() {
		 System.out.println("Press 1: Add Inventory details");
		 System.out.println("Press 2: All Inventory details");
		 System.out.println("Press 3: Update Inventory details");
		 System.out.println("Press 4: Delete Inventory details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 Inventory inventory=inventoryInputs();
			Inventory savedInventory= inventoryDao.createInventory(inventory);
			System.out.println("Inventory "+savedInventory+"details added successfully");
			break;
		 case 2:
	         displayAllInventory();
	         break;
	     case 3:
	         updateInventory();
	         break;
	     case 4:
	    	 deleteInventory();
	     default:
	         System.out.println("Invalid choice");		
		 }		
		 }
	 
	 static Inventory inventoryInputs() {
		 sc.nextLine();
		 System.out.println("Enter GoodsID");
		 String goodsID=sc.nextLine();
		 
		 System.out.println("Enter Goods Name");
		 String goodsName=sc.nextLine();
		 
		 System.out.println("Enter Goods Quantity");
		 String goodsQuantity=sc.nextLine();
		 
	return new Inventory(goodsID,goodsName,goodsQuantity);
	 }
	 static void displayAllInventory() {
		    List<Inventory> inventory = inventoryDao.getAllInventory();
		    if (inventory.isEmpty()) {
		        System.out.println("No Inventory found.");
		    } else {
		        System.out.println("All Inventory:");
		        for (Inventory inventoryy : inventory) {
		            System.out.println("Goods ID: " +inventoryy.getGoodsID());
		            System.out.println("Goods Name: " + inventoryy.getGoodsName());
		            System.out.println("Goods Quantity: " + inventoryy.getGoodsQuantity());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateInventory() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter Inventory ID to update:");
		    String inventoryToUpdate = sc.nextLine();

		    
		    Inventory existingInventory = inventoryDao.getInventoryById(inventoryToUpdate);
		    if (existingInventory == null) {
		        System.out.println("Inventory with ID " + inventoryToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Inventory(Goods) Name Text(Leave blank to keep current: " + existingInventory.getGoodsName() + ")");
		    String goodsName = sc.nextLine();
		    if (!goodsName.isEmpty()) {
		        existingInventory.setGoodsName(goodsName);
		    }
		    
		    System.out.println("Enter new goods Quantity Text(Leave blank to keep current: " + existingInventory.getGoodsQuantity() + ")");
		    String goodsQuantity = sc.nextLine();
		    if (!goodsQuantity.isEmpty()) {
		        existingInventory.setGoodsQuantity(goodsQuantity);
		    }
		    
		    inventoryDao.updateInventory(existingInventory);
		    System.out.println("Inventory with Goods ID " + inventoryToUpdate + " updated successfully.");
		}
	 static void deleteInventory() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the goodsID (InventoryID) to delete: ");
		    String goodsID = sc.nextLine();


		    Inventory existingInventory = inventoryDao.getInventoryById(goodsID);

		    if (existingInventory == null) {
		        System.out.println("Inventory with ID " +goodsID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this Inventory ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	inventoryDao.deleteInventory(existingInventory);
		        System.out.println("Inventory deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

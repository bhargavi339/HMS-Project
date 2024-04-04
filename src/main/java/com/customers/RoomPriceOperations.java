package com.customers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.customer.dao.RoomPriceDao;
import com.customer.daoImpl.RoomPriceDaoImpl;
import com.customer.entity.RoomPrice;

public class RoomPriceOperations {
	static Scanner sc=new Scanner(System.in);
	static RoomPriceDao roomPriceDao=new RoomPriceDaoImpl();
	static void roomPriceDetails() {
		 System.out.println("Press 1: Add Room Price details");
		 System.out.println("Press 2: All Room Price details");
		 System.out.println("Press 3: Update Room Price details");
		 System.out.println("Press 4: Delete Room Price details");
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			RoomPrice roomPrice=roomPriceInputs();
			RoomPrice savedRoomPrice= roomPriceDao.createRoomPrice(roomPrice);
			System.out.println("Room Price "+savedRoomPrice+" added successfully");
			break;
		 case 2:
	         displayAllRoomPrices();
	         break;
	     case 3:
	         updateRoomPrice();
	         break;
	     case 4:
	    	 deleteRoomPrice();
	     default:
	         System.out.println("Invalid choice");		
		 }	
		 }
	 
	 static RoomPrice roomPriceInputs() {
		 sc.nextLine();
		 System.out.println("Enter GeneratedPriceID for Room");
		 String generatedPriceID=sc.nextLine();
		 
		 System.out.println("Enter price of room ");
		 double price=sc.nextDouble();
		 
		 sc.nextLine(); 
	     System.out.println("Enter Starting date of stay (YYYY-MM-DDTHH:MM):");
	     String startInput = sc.nextLine();
	     LocalDateTime startDate = LocalDateTime.parse(startInput);

	     System.out.println("Enter ending date of stay (YYYY-MM-DDTHH:MM):");
	     String endInput = sc.nextLine();
	     LocalDateTime endDate = LocalDateTime.parse(endInput);
		 
		 return new RoomPrice(generatedPriceID,price,startDate,endDate);
	 }
	 static void displayAllRoomPrices() {
		    List<RoomPrice> roomPrices = roomPriceDao.getAllRoomPrice();
		    if (roomPrices.isEmpty()) {
		        System.out.println("No RoomPrices found.");
		    } else {
		        System.out.println("All RoomPrices:");
		        for (RoomPrice roomPrice : roomPrices) {
		            System.out.println("generated Price ID: " + roomPrice.getGeneratedPriceID());
		            System.out.println("Price: " + roomPrice.getPrice());
		            System.out.println("Start Date(YYYY-MM-DDTHH:MM): " + roomPrice.getStartDate());
		            System.out.println("End Date(YYYY-MM-DDTHH:MM): " + roomPrice.getEndDate());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateRoomPrice() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter generated Price ID to update:");
		    String roomPriceToUpdate = sc.nextLine();

		    // Check if the hotel exists
		    RoomPrice existingRoomPrice = roomPriceDao.getRoomPriceById(roomPriceToUpdate);
		    if (existingRoomPrice == null) {
		        System.out.println("Hotel with ID " + roomPriceToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new price (leave blank to keep current): ");
		    String newPriceStr = sc.nextLine();
		    if (!newPriceStr.isBlank()) {
		        try {
		            double newPrice = Double.parseDouble(newPriceStr);
		            existingRoomPrice.setPrice(newPrice);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. Price not updated.");
		        }
		    }
		    
		    System.out.println("Enter new Start Date(YYYY-MM-DDTHH:MM): (leave blank to keep current): ");
		    String newStart = sc.nextLine();
		    if (!newStart.isBlank()) {
		        try {
		            LocalDateTime newStartDate = LocalDateTime.parse(newStart);
		            existingRoomPrice.setStartDate(newStartDate);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. StartDate not updated.");
		        }
		    }
		    
		    System.out.println("Enter new End Date(YYYY-MM-DDTHH:MM): (leave blank to keep current): ");
		    String newEnd = sc.nextLine();
		    if (!newEnd.isBlank()) {
		        try {
		            LocalDateTime newEndDate = LocalDateTime.parse(newEnd);
		            existingRoomPrice.setStartDate(newEndDate);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. End Date not updated.");
		        }
		    }
		    roomPriceDao.updateRoomPrice(existingRoomPrice);
		    System.out.println("Room Price with generated Price ID " + roomPriceToUpdate + " updated successfully.");
		}
	 static void deleteRoomPrice() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the generated price ID of the Room to delete: ");
		    String generatedPriceID = sc.nextLine();

		    RoomPrice existingRoomPrice = roomPriceDao.getRoomPriceById(generatedPriceID);

		    if (existingRoomPrice == null) {
		        System.out.println("RoomPrice with number " + generatedPriceID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this generated RoomPrice ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	roomPriceDao.deleteRoomPrice(existingRoomPrice);
		        System.out.println("Generated RoomPrice  deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

package com.customers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.customer.dao.CheckInDao;
import com.customer.daoImpl.CheckInDaoImpl;
import com.customer.entity.CheckIns;

public class CheckInOperations {
	static Scanner sc=new Scanner(System.in);
	static CheckInDao checkInDao=new CheckInDaoImpl();
	static void checkInDetails() {
		 System.out.println("Press 1: Add CheckIn details");
		 System.out.println("Press 2: All CheckIn details");
		 System.out.println("Press 3: Update CheckIn details");
		 System.out.println("Press 4: Delete CheckIn details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 CheckIns checkIn=checkInInputs();
			CheckIns savedCheckIn= checkInDao.createCheckIn(checkIn);
			System.out.println("CheckIn "+savedCheckIn+" details added successfully");
			break;
		 case 2:
	         displayAllCheckIns();
	         break;
	     case 3:
	         updateCheckIn();
	         break;
	     case 4:
	    	 deleteCheckIn();
	     default:
	         System.out.println("Invalid choice");		
		 }		
		 }
	 
	 static CheckIns checkInInputs() {
		 sc.nextLine();
		 System.out.println("Enter checkInID");
		 String checkInID=sc.nextLine();
		 
		 System.out.println("Enter checkIn Time:Date(YYYY-MM-DDTHH:MM)");
		 String inTime = sc.nextLine();
	     LocalDateTime checkInTimeStamp = LocalDateTime.parse(inTime);
		 
	return new CheckIns(checkInID,checkInTimeStamp);
	 }
	 static void displayAllCheckIns() {
		    List<CheckIns> checkIns = checkInDao.getAllcheckIns();
		    if (checkIns.isEmpty()) {
		        System.out.println("No CheckIns found.");
		    } else {
		        System.out.println("All CheckIns:");
		        for (CheckIns checkIn : checkIns) {
		            System.out.println("CheckIn ID: " +checkIn.getCheckInID());
		            System.out.println("CheckIn TimeStamp(YYYY-MM-DDTHH:MM): " + checkIn.getCheckInTimeStamp());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateCheckIn() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter CheckIn ID to update:");
		    String checkInToUpdate = sc.nextLine();

		    
		    CheckIns existingCheckIn = checkInDao.getCheckInById(checkInToUpdate);
		    if (existingCheckIn == null) {
		        System.out.println("CheckIn with ID " + checkInToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new CheckIn TimeStamp(YYYY-MM-DDTHH:MM): (leave blank to keep current): ");
		    String newCheckInDateStr = sc.nextLine();
		    if (!newCheckInDateStr.isBlank()) {
		        try {
		            LocalDateTime newCheckInDate = LocalDateTime.parse(newCheckInDateStr);
		            existingCheckIn.setCheckInTimeStamp(newCheckInDate);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. CheckIn time not updated.");
		        }
		    }
		    
		    checkInDao.updateCheckIn(existingCheckIn);
		    System.out.println("CheckIns with CheckIn ID " + checkInToUpdate + " updated successfully.");
		}
	 static void deleteCheckIn() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the CheckInID  to delete: ");
		    String checkInID = sc.nextLine();


		    CheckIns existingCheckIn = checkInDao.getCheckInById(checkInID);

		    if (existingCheckIn == null) {
		        System.out.println("CheckIn with ID " +checkInID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this CheckIn ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	checkInDao.deleteCheckIn(existingCheckIn);
		        System.out.println("CheckIn deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

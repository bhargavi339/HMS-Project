package com.customers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.customer.dao.CheckOutDao;
import com.customer.daoImpl.CheckOutDaoImpl;
import com.customer.entity.CheckOuts;

public class CheckOutOperations {
	static Scanner sc=new Scanner(System.in);
	static CheckOutDao checkOutDao=new CheckOutDaoImpl();
	static void checkOutDetails() {
		 System.out.println("Press 1: Add CheckOut details");
		 System.out.println("Press 2: All CheckOut details");
		 System.out.println("Press 3: Update CheckOut details");
		 System.out.println("Press 4: Delete CheckOut details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 CheckOuts checkOut=checkOutInputs();
			CheckOuts savedCheckOut= checkOutDao.createCheckOut(checkOut);
			System.out.println("CheckOut "+savedCheckOut+" details added successfully");
			break;
		 case 2:
	         displayAllCheckOuts();
	         break;
	     case 3:
	         updateCheckOut();
	         break;
	     case 4:
	    	 deleteCheckOut();
	     default:
	         System.out.println("Invalid choice");		
		 }		
		 }
	 
	 static CheckOuts checkOutInputs() {
		 sc.nextLine();
		 System.out.println("Enter checkOutID");
		 String checkOutID=sc.nextLine();
		 
		 System.out.println("Enter checkOut Time:Date(YYYY-MM-DDTHH:MM)");
		 String outTime = sc.nextLine();
	     LocalDateTime checkOutTimeStamp = LocalDateTime.parse(outTime);
		 
	return new CheckOuts(checkOutID,checkOutTimeStamp);
	 }
	 static void displayAllCheckOuts() {
		    List<CheckOuts> checkOuts = checkOutDao.getAllcheckOuts();
		    if (checkOuts.isEmpty()) {
		        System.out.println("No CheckOuts found.");
		    } else {
		        System.out.println("All CheckOuts:");
		        for (CheckOuts checkOut : checkOuts) {
		            System.out.println("CheckOut ID: " +checkOut.getCheckOutID());
		            System.out.println("CheckOut TimeStamp(YYYY-MM-DDTHH:MM): " + checkOut.getCheckOutTimeStamp());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateCheckOut() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter CheckOut ID to update:");
		    String checkOutToUpdate = sc.nextLine();

		    
		    CheckOuts existingCheckOut = checkOutDao.getCheckOutById(checkOutToUpdate);
		    if (existingCheckOut == null) {
		        System.out.println("CheckOut with ID " + checkOutToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new CheckOut TimeStamp(YYYY-MM-DDTHH:MM): (leave blank to keep current): ");
		    String newCheckOutDateStr = sc.nextLine();
		    if (!newCheckOutDateStr.isBlank()) {
		        try {
		            LocalDateTime newCheckOutDate = LocalDateTime.parse(newCheckOutDateStr);
		            existingCheckOut.setCheckOutTimeStamp(newCheckOutDate);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. CheckOut time not updated.");
		        }
		    }
		    
		    checkOutDao.updateCheckOut(existingCheckOut);
		    System.out.println("CheckOuts with CheckOut ID " + checkOutToUpdate + " updated successfully.");
		}
	 static void deleteCheckOut() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the CheckOutID  to delete: ");
		    String checkOutID = sc.nextLine();


		    CheckOuts existingCheckOut = checkOutDao.getCheckOutById(checkOutID);

		    if (existingCheckOut == null) {
		        System.out.println("CheckOut with ID " +checkOutID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this CheckOut ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	checkOutDao.deleteCheckOut(existingCheckOut);
		        System.out.println("CheckOut deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

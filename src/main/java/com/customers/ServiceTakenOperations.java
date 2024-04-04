package com.customers;

import java.util.List;
import java.util.Scanner;

import com.customer.dao.ServicesTakenDao;
import com.customer.daoImpl.ServicesTakenDaoImpl;
import com.customer.entity.ServicesTaken;

public class ServiceTakenOperations extends CustomerOperations{
	static Scanner sc=new Scanner(System.in);
	static ServicesTakenDao servicesTakenDao=new ServicesTakenDaoImpl();
	static void servicesTakenDetails() {
		 System.out.println("Press 1: Add Services Used details");
		 System.out.println("Press 2: All Services Used details");
		 System.out.println("Press 3: Update Services Used details");
		 System.out.println("Press 3: Delete Services Used details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 ServicesTaken servicesTaken=servicesTakenInputs();
			ServicesTaken savedServicesTaken= servicesTakenDao.createServicesTaken(servicesTaken);
			System.out.println("Service "+savedServicesTaken+" used successfully");
			break;
		 case 2:
	         displayAllServicesTaken();
	         break;
	     case 3:
	         updateServicesTaken();
	         break;
	     case 4:
	    	 deleteServicesTaken();
	     default:
	         System.out.println("Invalid choice");		
		 }		
		 }
	 
	 static ServicesTaken servicesTakenInputs() {
		 sc.nextLine();
		 System.out.println("Enter serviceID");
		 String serviceID=sc.nextLine();
		 
		 System.out.println("Enter service bill");
		 double serviceBill=sc.nextDouble();
		 
		 //Customers customer = customerInputs();
	return new ServicesTaken(serviceID,serviceBill);
	 }
	 static void displayAllServicesTaken() {
		    List<ServicesTaken> servicesTaken = servicesTakenDao.getAllServicesTaken();
		    if (servicesTaken.isEmpty()) {
		        System.out.println("No ServicesTaken found.");
		    } else {
		        System.out.println("All ServicesTaken:");
		        for (ServicesTaken servicesTakenn : servicesTaken) {
		            System.out.println("Service ID: " +servicesTakenn.getServiceID());
		            System.out.println("Service Bill: " + servicesTakenn.getServiceBill());
		            System.out.println("------------------------");
		        }
		    }
		}
	 
	 static void updateServicesTaken() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter service ID to update:");
		    String servicesTakenToUpdate = sc.nextLine();

		    
		    ServicesTaken existingServicesTaken = servicesTakenDao.getServicesTakenById(servicesTakenToUpdate);
		    if (existingServicesTaken == null) {
		        System.out.println("ServicesTaken with ID " + servicesTakenToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Service Bill (leave blank to keep current): ");
		    String newServiceBillStr = sc.nextLine();
		    if (!newServiceBillStr.isBlank()) {
		        try {
		            double serviceBill = Double.parseDouble(newServiceBillStr);
		            existingServicesTaken.setServiceBill(serviceBill);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. Service Bill not updated.");
		        }
		    }
		    
		    
		    servicesTakenDao.updateServicesTaken(existingServicesTaken);
		    System.out.println("ServicesTaken with Service ID " + servicesTakenToUpdate + " updated successfully.");
		}
	 static void deleteServicesTaken() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the ServicesID (that is used) to delete: ");
		    String serviceID = sc.nextLine();

	  
		    ServicesTaken existingServicesTaken = servicesTakenDao.getServicesTakenById(serviceID);

		    if (existingServicesTaken == null) {
		        System.out.println("ServicesTaken with ID " +serviceID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this serviceTaken ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	servicesTakenDao.deleteServicesTaken(existingServicesTaken);
		        System.out.println("ServicesTaken deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

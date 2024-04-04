package com.customers;

import java.util.List;
import java.util.Scanner;

import com.customer.dao.ServiceDao;
import com.customer.daoImpl.ServiceDaoImpl;
import com.customer.entity.Services;

public class ServiceOperations {
	static Scanner sc=new Scanner(System.in);
	static ServiceDao serviceDao=new ServiceDaoImpl();
	static void serviceDetails() {
		 System.out.println("Press 1: Add Service details");
		 System.out.println("Press 2: All Services details");
		 System.out.println("Press 3: Update Service details");
		 System.out.println("Press 4: Delete Service details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 Services service=serviceInputs();
			Services savedService= serviceDao.createService(service);
			System.out.println("Service "+savedService+" added successfully");
			break;
		 case 2:
	         displayAllServices();
	         break;
	     case 3:
	         updateService();
	         break;
	     case 4:
	    	 deleteService();
	     default:
	         System.out.println("Invalid choice");		
		 }		
		 }
	 
	 static Services serviceInputs() {
		 sc.nextLine();
		 System.out.println("Enter service serial Number");
		 int serviceSerialNumber=sc.nextInt();
		 
		 sc.nextLine();
		 System.out.println("Enter service name");
		 String serviceName=sc.nextLine();
		 
		 System.out.println("Enter Service Description");
		 String serviceDescription=sc.nextLine();
		 
		 System.out.println("Enter cost of service ");
		 double cost=sc.nextDouble(); 
		 return new Services(serviceSerialNumber,serviceName,serviceDescription,cost);
	 }
	 static void displayAllServices() {
		    List<Services> services = serviceDao.getAllServices();
		    if (services.isEmpty()) {
		        System.out.println("No Services found.");
		    } else {
		        System.out.println("All Services:");
		        for (Services service : services) {
		            System.out.println("Service Serial Number: " +service.getServiceSerialNumber());
		            System.out.println("Service Name: " + service.getServiceName());
		            System.out.println("Service Description: " + service.getServiceDescription());
		            System.out.println("Cost: " + service.getCost());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateService() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter Service Serial Number to update:");
		    String serviceToUpdate1 = sc.nextLine();
		    
		    int serviceToUpdate =Integer.parseInt(serviceToUpdate1);
		    
		    
		    sc.nextLine();
		    Services existingService = serviceDao.getServicesById(serviceToUpdate);
		    if (existingService== null) {
		        System.out.println("Service with Serial Number " + serviceToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Service Name(Leave blank to keep current: " + existingService.getServiceName() + ")");
		    String serviceName  = sc.nextLine();
		    if (!serviceName.isEmpty()) {
		        existingService.setServiceName(serviceName);
		    }
		    
		 
		    System.out.println("Enter new service Description(Leave blank to keep current: " + existingService.getServiceName() + ")");
		    String serviceDescription  = sc.nextLine();
		    if (!serviceDescription.isEmpty()) {
		        existingService.setServiceDescription(serviceDescription);
		    }
		    
		    System.out.println("Enter new Cost (leave blank to keep current): ");
		    String newCostStr = sc.nextLine();
		    if (!newCostStr.isBlank()) {
		        try {
		            double newCost = Double.parseDouble(newCostStr);
		            existingService.setCost(newCost);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. Cost not updated.");
		        }
		    }
		    
		    serviceDao.updateService(existingService);
		    System.out.println("services with service ID " + serviceToUpdate + " updated successfully.");
		}
	 static void deleteService() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the Service Serial Number  to delete: ");
		    String serviceID2 = sc.nextLine();
	        int serviceID=Integer.parseInt(serviceID2);
	        
		    Services existingService = serviceDao.getServicesById(serviceID);

		    if (existingService == null) {
		        System.out.println("Service with ID " + serviceID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this Service ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	serviceDao.deleteService(existingService);
		        System.out.println("Service deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

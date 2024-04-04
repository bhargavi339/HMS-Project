package com.customers;

import java.util.List;
import java.util.Scanner;
import com.customer.dao.CustomerDao;
import com.customer.dao.HotelDao;
import com.customer.daoImpl.CustomerDaoImpl;
import com.customer.daoImpl.HotelDaoImpl;
import com.customer.entity.Customers;
import com.customer.entity.Hotels;

public class CustomerOperations {
	static CustomerDao customerDao=new CustomerDaoImpl();
	static HotelDao hotelDao=new HotelDaoImpl();
	static Scanner sc=new Scanner(System.in);
	static void customerDetails() {
		 System.out.println("Press 1: Add Customer details");
		 System.out.println("Press 2: All Customer details");
		 System.out.println("Press 3: Update Customer details");
		 System.out.println("Press 4: Delete Customer details");
		 System.out.println("Press 5:  Book Hotel");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 Customers customer=customerInputs();
			Customers savedCustomer= customerDao.createCustomer(customer);
			System.out.println("Customer "+savedCustomer+" added successfully");
			break;
		 case 2:
	         displayAllCustomers();
	         break;
	     case 3:
	         updateCustomer();
	         break;
	     case 4:
	    	 deleteCustomer();
	     case 5:
	    	 bookHotel();
	     default:
	         System.out.println("Invalid choice");	
		 }
	 }
	 static Customers customerInputs() {
		 sc.nextLine();
		 System.out.println("Enter CustomerID Type ");
		 String customerID=sc.nextLine();
		 
		 System.out.println("Enter AdressProof Type ");
		 String adressProof=sc.nextLine();
		 
		 System.out.println("Enter Age of Customer");
		 int age=sc.nextInt();
		 sc.nextLine();
		 System.out.println("Enter First Name of Customer ");
		 String firstName=sc.nextLine();
		 
		 System.out.println("Enter Last Name of Customer ");
		 String lastName=sc.nextLine();
		 
		 System.out.println("Enter Pincode");
		 String pincode=sc.nextLine();
		 
		 System.out.println("Enter Mobile Number");
		 String mobileNumber=sc.nextLine();
		 
		 System.out.println("Enter Adress(Door Number,colony,Village,state)");
		 String adress=sc.nextLine();
		 
		 System.out.println("Enter Nationality ");
		 String Nationality=sc.nextLine();
		  
		 return new Customers(customerID,adressProof,age,firstName,lastName,pincode,mobileNumber,adress,Nationality);
	 }
	 static void displayAllCustomers() {
		    List<Customers> customers = customerDao.getAllCustomers();
		    if (customers.isEmpty()) {
		        System.out.println("No customers found.");
		    } else {
		        System.out.println("All Customers:");
		        for (Customers customer : customers) {
		            System.out.println("Customer ID: " + customer.getCustomerID());
		            System.out.println("First Name: " + customer.getFirstName());
		            System.out.println("Last Name: " + customer.getLastName());
		            System.out.println("Age: " + customer.getAge());
		            System.out.println("Mobile Number: " + customer.getMobileNumber());
		            System.out.println("Address: " + customer.getAdress());
		            System.out.println("Pincode: " + customer.getPincode());
		            System.out.println("Nationality: " + customer.getNationality());
		            System.out.println("Address Proof: " + customer.getAdressProof());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateCustomer() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the CustomerID of the Customer to update: ");
		    String customerID = sc.nextLine();

		    Customers existingCustomer = customerDao.getCustomerById(customerID);

		    if (existingCustomer == null) {
		        System.out.println("Customer with ID " + customerID + " not found.");
		        return;
		    }

		    System.out.println("Current Customer Details:");
		    System.out.println("Customer ID: " + existingCustomer.getCustomerID());
		    System.out.println("First Name: " + existingCustomer.getFirstName());
		    System.out.println("Last Name: " + existingCustomer.getLastName());
		    System.out.println("Age: " + existingCustomer.getAge());
		    System.out.println("Mobile Number: " + existingCustomer.getMobileNumber());
		    System.out.println("Address: " + existingCustomer.getAdress());
		    System.out.println("Pincode: " + existingCustomer.getPincode());
		    System.out.println("Nationality: " + existingCustomer.getNationality());
		    System.out.println("Address Proof: " + existingCustomer.getAdressProof());

		    System.out.println("Enter new first name (leave blank to keep current): ");
		    String newFirstName = sc.nextLine();
		    if (!newFirstName.isBlank()) {
		        existingCustomer.setFirstName(newFirstName);
		    }

		    System.out.println("Enter new last name (leave blank to keep current): ");
		    String newLastName = sc.nextLine();
		    if (!newLastName.isBlank()) {
		        existingCustomer.setLastName(newLastName);
		    }

		    System.out.println("Enter new age (leave blank to keep current): ");
		    String newAgeStr = sc.nextLine();
		    if (!newAgeStr.isBlank()) {
		        try {
		            int newAge = Integer.parseInt(newAgeStr);
		            existingCustomer.setAge(newAge);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid age format. Age not updated.");
		        }
		    }
	       
		    System.out.println("Enter new Mobile Number (leave blank to keep current): ");
		    String newMobileNumber = sc.nextLine();
		    if (!newMobileNumber.isBlank()) {
		        existingCustomer.setMobileNumber(newMobileNumber);
		    }
		    
		    System.out.println("Enter new Address (leave blank to keep current): ");
		    String newAddress = sc.nextLine();
		    if (!newAddress.isBlank()) {
		        existingCustomer.setAdress(newAddress);
		    }
		    
		    System.out.println("Enter new Pincode (leave blank to keep current): ");
		    String newPincode = sc.nextLine();
		    if (!newPincode.isBlank()) {
		        existingCustomer.setPincode(newPincode);
		    }
		    
		    System.out.println("Enter new Nationality (leave blank to keep current): ");
		    String newNationality = sc.nextLine();
		    if (!newFirstName.isBlank()) {
		        existingCustomer.setNationality(newNationality);
		    }
		    
		    System.out.println("Enter new AdressProof (leave blank to keep current): ");
		    String newAdressProof = sc.nextLine();
		    if (!newAdressProof.isBlank()) {
		        existingCustomer.setAdressProof(newAdressProof);
		    }
		    
		    customerDao.updateCustomer(existingCustomer);
		    System.out.println("Customer details updated successfully.");
		}
	 static void deleteCustomer() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the CustomerID of the Customer to delete: ");
		    String customerID = sc.nextLine();

		    Customers existingCustomer = customerDao.getCustomerById(customerID);

		    if (existingCustomer == null) {
		        System.out.println("Customer with ID " + customerID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this customer?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		        customerDao.deleteCustomer(existingCustomer);
		        System.out.println("Customer deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
	 static void bookHotel()
	 {
		 sc.nextLine(); 
		 System.out.println("Enter the HotelID to Book: ");
		 String hotelID=sc.nextLine(); 
		 Hotels existingHotel = hotelDao.getHotelById(hotelID);

		    if (existingHotel == null) {
		        System.out.println("Hotel with ID " + hotelID + " not found.");
		        return;
		    }
		    customerDao.bookHotel(existingHotel);
	 }
}

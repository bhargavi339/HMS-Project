package com.customers;

import java.util.List;
import java.util.Scanner;

import com.customer.dao.HotelDao;
import com.customer.daoImpl.HotelDaoImpl;
import com.customer.entity.Hotels;

public class HotelOperations {
	static Scanner sc=new Scanner(System.in);
	static HotelDao hotelDao=new HotelDaoImpl();
	static void hotelDetails() {
		 System.out.println("Press 1: Add Hotel details");
		 System.out.println("Press 2: All Hotels details");
		 System.out.println("Press 3: Update Hotel details");
		 System.out.println("Press 4: Delete Hotel details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			Hotels hotel=hotelInputs();
			Hotels savedHotel= hotelDao.createHotel(hotel);
			System.out.println("Hotel "+savedHotel+" added successfully");
			break;
		 case 2:
	         displayAllHotels();
	         break;
	     case 3:
	         updateHotel();
	         break;
	     case 4:
	    	 deleteHotel();
	     default:
	         System.out.println("Invalid choice");
		 }
	 }
	 static Hotels hotelInputs() {
		 sc.nextLine();
		 System.out.println("Enter HotelID the Hotel ");
		 String hotelID=sc.nextLine();
		 
		 System.out.println("Enter Name of the Hotel ");
		 String hotelName=sc.nextLine();
		 
		 System.out.println("Enter Location of Hotel");
		 String hotelLocation=sc.nextLine();
		 return new Hotels(hotelID,hotelName,hotelLocation);
	 }
	 static void displayAllHotels() {
		    List<Hotels> hotels = hotelDao.getAllHotels();
		    if (hotels.isEmpty()) {
		        System.out.println("No hotels found");
		    } else {
		        System.out.println("---- All Hotels ----");
		        for (Hotels hotel : hotels) {
		            System.out.println("Hotel ID: " + hotel.getHotelID());
		            System.out.println("Name: " + hotel.getHotelName());
		            System.out.println("Location: " + hotel.getHotelLocation());
		            System.out.println("--------------------");
		        }
		    }
		}
	 static void updateHotel() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter Hotel ID to update:");
		    String hotelIDToUpdate = sc.nextLine();

		    // Check if the hotel exists
		    Hotels existingHotel = hotelDao.getHotelById(hotelIDToUpdate);
		    if (existingHotel == null) {
		        System.out.println("Hotel with ID " + hotelIDToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Name of the Hotel (Leave blank to keep current: " + existingHotel.getHotelName() + ")");
		    String hotelName = sc.nextLine();
		    if (!hotelName.isEmpty()) {
		        existingHotel.setHotelName(hotelName);
		    }

		    System.out.println("Enter new Location of the Hotel (Leave blank to keep current: " + existingHotel.getHotelLocation() + ")");
		    String hotelLocation = sc.nextLine();
		    if (!hotelLocation.isEmpty()) {
		        existingHotel.setHotelLocation(hotelLocation);
		    }

		    // Update the hotel
		    hotelDao.updateHotel(existingHotel);
		    System.out.println("Hotel with ID " + hotelIDToUpdate + " updated successfully.");
		}
	 
	 static void deleteHotel() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the HotelID of the Hotel to delete: ");
		    String hotelID = sc.nextLine();

		    Hotels existingHotel = hotelDao.getHotelById(hotelID);

		    if (existingHotel == null) {
		        System.out.println("Hotel with ID " + hotelID + " not found.");
		        return;
		    }
		    System.out.println("Are you sure you want to delete this hotel?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		        hotelDao.deleteHotel(existingHotel);
		        System.out.println("Hotel deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
	 
}

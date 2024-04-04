package com.customers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.customer.dao.BookingDao;
import com.customer.daoImpl.BookingDaoImpl;
import com.customer.entity.Bookings;

public class BookingOperations {
	static Scanner sc=new Scanner(System.in);
	 static BookingDao bookingDao=new BookingDaoImpl();
	static void bookingDetails() {
		 System.out.println("Press 1: Add Booking details");
		 System.out.println("Press 2: All Bookings details");
		 System.out.println("Press 3: Update Booking details");
		 System.out.println("Press 4: Delete Booking details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 Bookings booking=bookingInputs();
			Bookings savedBooking= bookingDao.createBooking(booking);
			System.out.println("Booking "+savedBooking+" added successfully");
			break;
		 case 2:
	         displayAllBookings();
	         break;
	     case 3:
	         updateBooking();
	         break;
	     case 4:
	    	 deleteBooking();
	     default:
	         System.out.println("Invalid choice");		
		 }		
		 }
	 
	 static Bookings bookingInputs() {
		 sc.nextLine();
		 System.out.println("Enter BookingID");
		 String bookingID=sc.nextLine();
		 
		 System.out.println("Enter Time:Date of booking (YYYY-MM-DDTHH:MM)");
		 String bookingTime = sc.nextLine();
		 LocalDateTime bookingTimeStamp = LocalDateTime.parse(bookingTime);
		 
		 System.out.println("Enter Booking Method");
		 String bookingMode=sc.nextLine();
		 
	return new Bookings(bookingID,bookingTimeStamp,bookingMode);
	 }
	 static void displayAllBookings() {
		    List<Bookings> bookings = bookingDao.getAllBookings();
		    if (bookings.isEmpty()) {
		        System.out.println("No Bookings found.");
		    } else {
		        System.out.println("All Bookings:");
		        for (Bookings booking : bookings) {
		            System.out.println("Booking ID: " +booking.getBookingID());
		            System.out.println("Booking Time Stamp(YYYY-MM-DDTHH:MM): " + booking.getBookingTimeStamp());
		            System.out.println("Booking Mode: " + booking.getBookingMode());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateBooking() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter Booking ID to update:");
		    String bookingToUpdate = sc.nextLine();

		    
		    Bookings existingBooking = bookingDao.getBookingById(bookingToUpdate);
		    if (existingBooking == null) {
		        System.out.println("Booking with ID " + bookingToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Booking Date(YYYY-MM-DDTHH:MM): (leave blank to keep current): ");
		    String newBookingDateStr = sc.nextLine();
		    if (!newBookingDateStr.isBlank()) {
		        try {
		            LocalDateTime newBookingDate = LocalDateTime.parse(newBookingDateStr);
		            existingBooking.setBookingTimeStamp(newBookingDate);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. Booking Date not updated.");
		        }
		    }
		    
		    System.out.println("Enter new Booking mode (Leave blank to keep current: " + existingBooking.getBookingMode() + ")");
		    String bookingMode = sc.nextLine();
		    if (!bookingMode.isEmpty()) {
		        existingBooking.setBookingMode(bookingMode);
		    }
		    
		    bookingDao.updateBooking(existingBooking);
		    System.out.println("Bookings with booking ID " + bookingToUpdate + " updated successfully.");
		}
	 static void deleteBooking() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the BookingID  to delete: ");
		    String bookingID = sc.nextLine();
	 
	     
		    Bookings existingBooking = bookingDao.getBookingById(bookingID);

		    if (existingBooking == null) {
		        System.out.println("Booking with ID " +bookingID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this Booking ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	bookingDao.deleteBooking(existingBooking);
		        System.out.println("Booking deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

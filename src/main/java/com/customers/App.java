package com.customers;

import java.util.Scanner;

public class App {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	while(true) {
	System.out.println("Press the number to get the details accordingly\n"
			+ "1.Customer Details\n 2.Hotel Details \n 3.Employee Details\n"
			+ "4.Room Details\n 5.Room Price Details\n"
			+ "6.Payment Details\n 7.Services Details\n"
			+ "8.Bookings Details\n 9.Services Taken Details\n"
			+ "10.Feedback Details\n 11.CheckIn Details\n"
			+ "12.CheckOut Details\n 13.Inventory Details\n"
			+ "-1.To EXIT");
	System.out.println("Enter your choice:");
	int choice=sc.nextInt();
	if(choice==-1) {
		System.out.println("Exiting the loop...");
		break;
	}
	switch(choice) {
	case 1:
		CustomerOperations.customerDetails();
		break;
	case 2:
		HotelOperations.hotelDetails();
		break;
	case 3:
		EmployeeOperations.employeeDetails();
		break;
	case 4:
		RoomOperations.roomDetails();
		break;
	case 5:
		RoomPriceOperations.roomPriceDetails();
		break;
	case 6:
		PaymentOperations.paymentDetails();
		break;
	case 7:
		ServiceOperations.serviceDetails();
		break;
	case 8:
		BookingOperations.bookingDetails();
		break;
	case 9:
		ServiceTakenOperations.servicesTakenDetails();
		break;
	case 10:
		FeedbackOperations.feedbackDetails();
		break;
	case 11:
		CheckInOperations.checkInDetails();
		break;
	case 12:
		CheckOutOperations.checkOutDetails();
		break;
	case 13:
		InventoryOperations.inventoryDetails();
		break;
	default:
		System.out.println("Invalid Choice");	
	}
	}
	sc.close();
}


}

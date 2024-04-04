package com.customers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.customer.dao.PaymentDao;
import com.customer.daoImpl.PaymentDaoImpl;
import com.customer.entity.Payments;

public class PaymentOperations {
	static Scanner sc=new Scanner(System.in);
	static PaymentDao paymentDao=new PaymentDaoImpl();
	static void paymentDetails() {
		 System.out.println("Press 1: Add Payment details");
		 System.out.println("Press 2: All Payment details");
		 System.out.println("Press 3: Update Payment details");
		 System.out.println("Press 4: Delete Payment details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 Payments payment=paymentInputs();
			Payments savedPayment= paymentDao.createPayment(payment);
			System.out.println("Payment "+savedPayment+" added successfully");
			break;
		 case 2:
	         displayAllPayments();
	         break;
	     case 3:
	         updatePayment();
	         break;
	     case 4:
	    	 deletePayment();
	     default:
	         System.out.println("Invalid choice");		
		 }		
		 }
	 
	 static Payments paymentInputs() {
		 sc.nextLine();
		 System.out.println("Enter PaymentID");
		 String paymentID=sc.nextLine();
		 
		 System.out.println("Enter Date of Payment(YYYY-MM-DDTHH:MM)");
		 String payDate = sc.nextLine();
		 LocalDateTime paymentDate = LocalDateTime.parse(payDate);
		 
		 System.out.println("Enter payment Method");
		 String paymentMethod=sc.nextLine();
		 
		 System.out.println("Enter payment Amount ");
		 double paymentAmount=sc.nextDouble(); 
	return new Payments(paymentID,paymentDate,paymentMethod,paymentAmount);
	 }
	 static void displayAllPayments() {
		    List<Payments> payments = paymentDao.getAllPayments();
		    if (payments.isEmpty()) {
		        System.out.println("No Payments found.");
		    } else {
		        System.out.println("All Payments:");
		        for (Payments payment : payments) {
		            System.out.println("Payment ID: " + payment.getPaymentID());
		            System.out.println("Payment Date(YYYY-MM-DDTHH:MM): " + payment.getPaymentDate());
		            System.out.println("Payment Method:" + payment.getPaymentMethod());
		            System.out.println("Payment Amount: " + payment.getPaymentAmount());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updatePayment() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter Payment ID to update:");
		    String paymentToUpdate = sc.nextLine();

		    
		    Payments existingPayment = paymentDao.getPaymentById(paymentToUpdate);
		    if (existingPayment == null) {
		        System.out.println("Payment with ID " + paymentToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Payment Date(YYYY-MM-DDTHH:MM): (leave blank to keep current): ");
		    String newPaymentDateStr = sc.nextLine();
		    if (!newPaymentDateStr.isBlank()) {
		        try {
		            LocalDateTime newPaymentDate = LocalDateTime.parse(newPaymentDateStr);
		            existingPayment.setPaymentDate(newPaymentDate);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. Payment Date not updated.");
		        }
		    }
		    
		    System.out.println("Enter new Payment Method (Leave blank to keep current: " + existingPayment.getPaymentMethod() + ")");
		    String paymentMethod = sc.nextLine();
		    if (!paymentMethod.isEmpty()) {
		        existingPayment.setPaymentMethod(paymentMethod);
		    }
		    
		    System.out.println("Enter new PaymentAmount (leave blank to keep current): ");
		    String newPaymentAmountStr = sc.nextLine();
		    if (!newPaymentAmountStr.isBlank()) {
		        try {
		            double newPaymentAmount = Double.parseDouble(newPaymentAmountStr);
		            existingPayment.setPaymentAmount(newPaymentAmount);
		        } catch (NumberFormatException e) {
		            System.out.println("Invalid  format. PaymentAmount not updated.");
		        }
		    }
		    
		    paymentDao.updatePayment(existingPayment);
		    System.out.println("Payments with Payment ID " + paymentToUpdate + " updated successfully.");
		}
	 static void deletePayment() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the Payment ID to delete: ");
		    String PaymentID = sc.nextLine();

		    Payments existingPayment = paymentDao.getPaymentById(PaymentID);

		    if (existingPayment == null) {
		        System.out.println("Payment with ID " + PaymentID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this Payment ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	paymentDao.deletePayment(existingPayment);
		        System.out.println("Payment deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

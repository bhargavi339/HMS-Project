package com.customers;

import java.util.List;
import java.util.Scanner;

import com.customer.dao.FeedbackDao;
import com.customer.daoImpl.FeedbackDaoImpl;
import com.customer.entity.Feedback;

public class FeedbackOperations {
	static Scanner sc=new Scanner(System.in);
	static FeedbackDao feedbackDao=new FeedbackDaoImpl();
	static void feedbackDetails() {
		 System.out.println("Press 1: Add Feedback details");
		 System.out.println("Press 2: All Feedback details");
		 System.out.println("Press 3: Update Feedback details");
		 System.out.println("Press 4: Delete Feedback details");
		 
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 Feedback feedback=feedbackInputs();
			Feedback savedFeedback= feedbackDao.createFeedback(feedback);
			System.out.println("Feedback "+savedFeedback+" added successfully");
			break;
		 case 2:
	         displayAllFeedbacks();
	         break;
	     case 3:
	         updateFeedback();
	         break;
	     case 4:
	    	 deleteFeedback();
	     default:
	         System.out.println("Invalid choice");		
		 }		
		 }
	 
	 static Feedback feedbackInputs() {
		 sc.nextLine();
		 System.out.println("Enter FeedbackID");
		 String feedbackID=sc.nextLine();
		 
		 System.out.println("Enter feedback");
		 String feedbackText=sc.nextLine();
		 
	return new Feedback(feedbackID,feedbackText);
	 }
	 static void displayAllFeedbacks() {
		    List<Feedback> feedbacks = feedbackDao.getAllFeedbacks();
		    if (feedbacks.isEmpty()) {
		        System.out.println("No Feedback found.");
		    } else {
		        System.out.println("All Feedback:");
		        for (Feedback feedback : feedbacks) {
		            System.out.println("Feedback ID: " +feedback.getFeedbackID());
		            System.out.println("Feedback Text: " + feedback.getFeedbackText());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateFeedback() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter Feedback ID to update:");
		    String feedbackToUpdate = sc.nextLine();

		    
		    Feedback existingFeedback = feedbackDao.getFeedbackById(feedbackToUpdate);
		    if (existingFeedback == null) {
		        System.out.println("Feedback with ID " + feedbackToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Feedback Text(Leave blank to keep current: " + existingFeedback.getFeedbackText() + ")");
		    String feedbackText = sc.nextLine();
		    if (!feedbackText.isEmpty()) {
		        existingFeedback.setFeedbackText(feedbackText);
		    }
		    
		    feedbackDao.updateFeedback(existingFeedback);
		    System.out.println("Feedback with FeedbackID " + feedbackToUpdate + " updated successfully.");
		}
	 static void deleteFeedback() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the FeedbackID  to delete: ");
		    String feedbackID = sc.nextLine();


		    Feedback existingFeedback = feedbackDao.getFeedbackById(feedbackID);

		    if (existingFeedback == null) {
		        System.out.println("Feedback with ID " +feedbackID + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this Feedback ID?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	feedbackDao.deleteFeedback(existingFeedback);
		        System.out.println("Feedback deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

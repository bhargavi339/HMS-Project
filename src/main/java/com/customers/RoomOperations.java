package com.customers;

import java.util.List;
import java.util.Scanner;

import com.customer.dao.RoomDao;
import com.customer.daoImpl.RoomDaoImpl;
import com.customer.entity.Rooms;

public class RoomOperations {
	static Scanner sc=new Scanner(System.in);
	static RoomDao roomDao=new RoomDaoImpl();
	static void roomDetails() {
		 System.out.println("Press 1: Add Room details");
		 System.out.println("Press 2: All Rooms details");
		 System.out.println("Press 3: Update Room details");
		 System.out.println("Press 4: Delete Room details");
		 int choice=sc.nextInt();
		 switch(choice) {
		 case 1:
			 Rooms room=roomInputs();
			Rooms savedRoom= roomDao.createRoom(room);
			System.out.println("Room "+savedRoom+" added successfully");
			break;
		 case 2:
	         displayAllRooms();
	         break;
	     case 3:
	         updateRoom();
	         break;
	     case 4:
	    	 deleteRoom();
	     default:
	         System.out.println("Invalid choice");		
		 }
	 }
	 static Rooms roomInputs() {
		 sc.nextLine();
		 System.out.println("Enter Room Number");
		 String roomNumber=sc.nextLine();
		 
		 System.out.println("Enter status of room");
		 String roomStatus=sc.nextLine();
		 
		 System.out.println("Enter Room Type");
		 String roomType=sc.nextLine();
		 return new Rooms(roomNumber,roomStatus,roomType);
	 }
	 static void displayAllRooms() {
		    List<Rooms> rooms = roomDao.getAllRooms();
		    if (rooms.isEmpty()) {
		        System.out.println("No rooms found.");
		    } else {
		        System.out.println("All Rooms:");
		        for (Rooms room : rooms) {
		            System.out.println("Room Number: " + room.getRoomNumber());
		            System.out.println("Room Status: " + room.getRoomStatus());
		            System.out.println("Room Type: " + room.getRoomType());
		            System.out.println("------------------------");
		        }
		    }
		}
	 static void updateRoom() {
		    sc.nextLine(); // Consume newline character
		    System.out.println("Enter Room Number to update:");
		    String roomNumberToUpdate = sc.nextLine();

		    Rooms existingRoom = roomDao.getRoomById(roomNumberToUpdate);
		    if (existingRoom == null) {
		        System.out.println("Room with Number" + roomNumberToUpdate + " not found.");
		        return;
		    }

		    System.out.println("Enter new Room Status(Leave blank to keep current: " + existingRoom.getRoomStatus() + ")");
		    String roomStatus = sc.nextLine();
		    if (!roomStatus.isEmpty()) {
		    	existingRoom.setRoomStatus(roomStatus);
		    }

		    System.out.println("Enter new Room Type (Leave blank to keep current: " + existingRoom.getRoomType() + ")");
		    String roomType = sc.nextLine();
		    if (!roomType.isEmpty()) {
		    	existingRoom.setRoomType(roomType);
		    }

		   
		    roomDao.updateRoom(existingRoom);
		    System.out.println("Room with Number " + roomNumberToUpdate + " updated successfully.");
		}
	 static void deleteRoom() {
		    sc.nextLine(); // Consume the leftover newline
		    System.out.println("Enter the RoomNumber of the Room to delete: ");
		    String roomNumber = sc.nextLine();

		    Rooms existingRoom = roomDao.getRoomById(roomNumber);

		    if (existingRoom == null) {
		        System.out.println("Room with number " + roomNumber + " not found.");
		        return;
		    }

		    System.out.println("Are you sure you want to delete this Room?");
		    System.out.println("1. Yes");
		    System.out.println("2. No");

		    int deleteChoice = sc.nextInt();
		    if (deleteChoice == 1) {
		    	roomDao.deleteRoom(existingRoom);
		        System.out.println("Room deleted successfully.");
		    } else {
		        System.out.println("Deletion cancelled.");
		    }
		}
}

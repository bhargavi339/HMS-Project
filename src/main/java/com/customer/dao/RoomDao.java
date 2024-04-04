package com.customer.dao;

import java.util.List;

import com.customer.entity.Rooms;

public interface RoomDao {
	Rooms createRoom(Rooms room);
	 Rooms getRoomById(String roomID);
	 List<Rooms> getAllRooms();
	 void updateRoom(Rooms room);
	 void deleteRoom(Rooms room);
}

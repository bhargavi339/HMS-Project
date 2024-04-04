package com.customer.dao;

import java.util.List;

import com.customer.entity.RoomPrice;

public interface RoomPriceDao {
	RoomPrice createRoomPrice(RoomPrice roomPrice );
	 RoomPrice getRoomPriceById(String roomPriceID);
	 List<RoomPrice> getAllRoomPrice();
	 void updateRoomPrice(RoomPrice roomPrice);
	 void deleteRoomPrice(RoomPrice roomPrice);
}

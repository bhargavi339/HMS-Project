package com.customer.dao;

import java.util.List;

import com.customer.entity.Hotels;

public interface HotelDao {
	 Hotels createHotel(Hotels hotel);
	 Hotels getHotelById(String hotelID);
	List<Hotels> getAllHotels();
	void updateHotel(Hotels hotel);
	void deleteHotel(Hotels hotel);
	//
}

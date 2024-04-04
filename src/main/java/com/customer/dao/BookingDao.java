package com.customer.dao;

import java.util.List;

import com.customer.entity.Bookings;
	public interface BookingDao {
		Bookings createBooking(Bookings booking);
		 Bookings getBookingById(String bookingID);
		 List<Bookings> getAllBookings();
		 void updateBooking(Bookings booking);
		 void deleteBooking(Bookings booking);
}

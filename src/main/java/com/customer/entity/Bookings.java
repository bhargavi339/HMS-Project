package com.customer.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Bookings {
	@Id	
	private String bookingID;
	@Column(length=30)
	private LocalDateTime bookingTimeStamp;
	@Column(length=30)
	private String bookingMode;
	@ManyToOne(cascade=CascadeType.ALL)
	private Customers customers;
	@ManyToMany(mappedBy="bookings",cascade=CascadeType.ALL)
	private Set<Rooms> rooms;
	public Bookings(Set<Rooms> rooms) {
		super();
		this.rooms = rooms;
	}
	public Set<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Rooms> rooms) {
		this.rooms = rooms;
	}
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public LocalDateTime getBookingTimeStamp() {
		return bookingTimeStamp;
	}
	public void setBookingTimeStamp(LocalDateTime bookingTimeStamp) {
		this.bookingTimeStamp = bookingTimeStamp;
	}
	public String getBookingMode() {
		return bookingMode;
	}
	public void setBookingMode(String bookingMode) {
		this.bookingMode = bookingMode;
	}
	public Bookings(String bookingID, LocalDateTime bookingTimeStamp, String bookingMode) {
		super();
		this.bookingID = bookingID;
		this.bookingTimeStamp = bookingTimeStamp;
		this.bookingMode = bookingMode;
	}
	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bookings [bookingID=" + bookingID + ", bookingTimeStamp=" + bookingTimeStamp + ", bookingMode="
				+ bookingMode + ", customers=" + customers + ", rooms=" + rooms + "]";
	}
	
	
}

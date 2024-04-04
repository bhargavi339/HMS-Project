package com.customer.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Rooms {
	@Id	
	private String roomNumber;
	@Column(length=30)
	private String roomStatus;
	@Column(length=30)
	private String roomType;
	@ManyToOne(cascade=CascadeType.ALL)
	private Hotels hotel;
	@OneToOne(cascade=CascadeType.ALL)
	private RoomPrice roomPrice;
	@ManyToMany(mappedBy="rooms",cascade=CascadeType.ALL)
	private Set<Customers> customers;
	@ManyToMany(mappedBy="rooms",cascade=CascadeType.ALL)
	private Set<Payments> payments;
	public Rooms(String roomNumber, String roomStatus, String roomType, Hotels hotel, RoomPrice roomPrice,
			Set<Customers> customers, Set<Payments> payments, Set<Bookings> bookings) {
		super();
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
		this.roomType = roomType;
		this.hotel = hotel;
		this.roomPrice = roomPrice;
		this.customers = customers;
		this.payments = payments;
		this.bookings = bookings;
	}
	public Set<Payments> getPayments() {
		return payments;
	}
	public void setPayments(Set<Payments> payments) {
		this.payments = payments;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="rooms_bookings",
	           joinColumns=@JoinColumn(name="roomNumber"),
	           inverseJoinColumns=@JoinColumn(name="bookingID"))
	private Set<Bookings> bookings;
	public Rooms(Set<Customers> customers) {
		super();
		this.customers = customers;
	}
	public Rooms(String roomNumber, String roomStatus, String roomType, Hotels hotel, RoomPrice roomPrice,
			Set<Customers> customers, Set<Bookings> bookings) {
		super();
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
		this.roomType = roomType;
		this.hotel = hotel;
		this.roomPrice = roomPrice;
		this.customers = customers;
		this.bookings = bookings;
	}
	public Set<Bookings> getBookings() {
		return bookings;
	}
	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}
	public Set<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customers> customers) {
		this.customers = customers;
	}
	public Rooms(String roomNumber, String roomStatus, String roomType, Hotels hotel, RoomPrice roomPrice) {
		super();
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
		this.roomType = roomType;
		this.hotel = hotel;
		this.roomPrice = roomPrice;
	}
	public RoomPrice getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(RoomPrice roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Rooms(String roomNumber, String roomStatus, String roomType, Hotels hotel) {
		super();
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
		this.roomType = roomType;
		this.hotel = hotel;
	}
	public Hotels getHotel() {
		return hotel;
	}
	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Rooms(String roomNumber, String roomStatus, String roomType) {
		super();
		this.roomNumber = roomNumber;
		this.roomStatus = roomStatus;
		this.roomType = roomType;
	}
	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Rooms [roomNumber=" + roomNumber + ", roomStatus=" + roomStatus + ", roomType=" + roomType + ", hotel="
				+ hotel + ", roomPrice=" + roomPrice + ", customers=" + customers + ", payments=" + payments
				+ ", bookings=" + bookings + "]";
	}
	
}

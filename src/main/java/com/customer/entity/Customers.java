package com.customer.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customers {
@Id	
private String customerID;
@Column(length=30)
private String adressProof;
@Column(length=30)
private int age;
@Column(length=10)
private String firstName;
@Column(length=30)
private String lastName;
@Column(length=30)
private String pincode;
@Column(length=20)
private String mobileNumber;
@Column(length=100)
private String adress;
@Column(length=30)
private String nationality;
@ManyToOne(cascade=CascadeType.ALL)
private Hotels hotel;

public List<Bookings> getBookings() {
	return bookings;
}
public void setBookings(List<Bookings> bookings) {
	this.bookings = bookings;
}

@OneToOne(mappedBy = "customers",cascade=CascadeType.ALL)
private Feedback feedback;
@OneToMany(cascade=CascadeType.ALL)
private List<Bookings> bookings;
public Customers(Feedback feedback) {
	super();
	this.feedback = feedback;
}
public Feedback getFeedback() {
	return feedback;
}
public void setFeedback(Feedback feedback) {
	this.feedback = feedback;
}

@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name="customers_rooms",
           joinColumns=@JoinColumn(name="customerID"),
           inverseJoinColumns=@JoinColumn(name="roomID"))
private Set<Rooms> rooms;
@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name="customers_checkIns",
           joinColumns=@JoinColumn(name="customerID"),
           inverseJoinColumns=@JoinColumn(name="checkInID"))
private Set<CheckIns> checkIns;
@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name="customers_checkOuts",
           joinColumns=@JoinColumn(name="customerID"),
           inverseJoinColumns=@JoinColumn(name="checkOutID"))
private Set<CheckOuts> checkOuts;
@OneToMany(cascade=CascadeType.ALL)
private List<ServicesTaken> servicesTaken;


public Customers(String customerID, String adressProof, int age, String firstName, String lastName, String pincode,
		String mobileNumber, String adress, String nationality, Hotels hotel, Feedback feedback,
		List<Bookings> bookings, Set<Rooms> rooms, Set<CheckIns> checkIns, Set<CheckOuts> checkOuts,
		List<ServicesTaken> servicesTaken, List<Payments> payments) {
	super();
	this.customerID = customerID;
	this.adressProof = adressProof;
	this.age = age;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pincode = pincode;
	this.mobileNumber = mobileNumber;
	this.adress = adress;
	this.nationality = nationality;
	this.hotel = hotel;
	this.feedback = feedback;
	this.bookings = bookings;
	this.rooms = rooms;
	this.checkIns = checkIns;
	this.checkOuts = checkOuts;
	this.servicesTaken = servicesTaken;
	this.payments = payments;
}
public List<ServicesTaken> getServicesTaken() {
	return servicesTaken;
}
public void setServicesTaken(List<ServicesTaken> servicesTaken) {
	this.servicesTaken = servicesTaken;
}
public Customers(String customerID, String adressProof, int age, String firstName, String lastName, String pincode,
		String mobileNumber, String adress, String nationality, Hotels hotel, Feedback feedback, Set<Rooms> rooms,
		Set<CheckIns> checkIns, Set<CheckOuts> checkOuts, List<Payments> payments) {
	super();
	this.customerID = customerID;
	this.adressProof = adressProof;
	this.age = age;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pincode = pincode;
	this.mobileNumber = mobileNumber;
	this.adress = adress;
	this.nationality = nationality;
	this.hotel = hotel;
	this.feedback = feedback;
	this.rooms = rooms;
	this.checkIns = checkIns;
	this.checkOuts = checkOuts;
	this.payments = payments;
}
public Set<CheckIns> getCheckIns() {
	return checkIns;
}
public void setCheckIns(Set<CheckIns> checkIns) {
	this.checkIns = checkIns;
}
public Set<CheckOuts> getCheckOuts() {
	return checkOuts;
}
public void setCheckOuts(Set<CheckOuts> checkOuts) {
	this.checkOuts = checkOuts;
}
@OneToMany(cascade=CascadeType.ALL)
private List<Payments> payments;

public Customers(String customerID, String adressProof, int age, String firstName, String lastName, String pincode,
		String mobileNumber, String adress, String nationality, Hotels hotel, Set<Rooms> rooms,
		List<Payments> payments) {
	super();
	this.customerID = customerID;
	this.adressProof = adressProof;
	this.age = age;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pincode = pincode;
	this.mobileNumber = mobileNumber;
	this.adress = adress;
	this.nationality = nationality;
	this.hotel = hotel;
	this.rooms = rooms;
	this.payments = payments;
}
public List<Payments> getPayments() {
	return payments;
}
public void setPayments(List<Payments> payments) {
	this.payments = payments;
}
public Customers(String customerID, String adressProof, int age, String firstName, String lastName, String pincode,
		String mobileNumber, String adress, String nationality, Hotels hotel, Set<Rooms> rooms) {
	super();
	this.customerID = customerID;
	this.adressProof = adressProof;
	this.age = age;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pincode = pincode;
	this.mobileNumber = mobileNumber;
	this.adress = adress;
	this.nationality = nationality;
	this.hotel = hotel;
	this.rooms = rooms;
}
public Set<Rooms> getRooms() {
	return rooms;
}
public void setRooms(Set<Rooms> rooms) {
	this.rooms = rooms;
}
public Customers(String customerID, String adressProof, int age, String firstName, String lastName, String pincode,
		String mobileNumber, String adress, String nationality, Hotels hotel) {
	super();
	this.customerID = customerID;
	this.adressProof = adressProof;
	this.age = age;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pincode = pincode;
	this.mobileNumber = mobileNumber;
	this.adress = adress;
	this.nationality = nationality;
	this.hotel = hotel;
}
public Hotels getHotel() {
	return hotel;
}
public void setHotel(Hotels hotel) {
	this.hotel = hotel;
}
public String getCustomerID() {
	return customerID;
}
public void setCustomerID(String customerID) {
	this.customerID = customerID;
}
public String getAdressProof() {
	return adressProof;
}
public void setAdressProof(String adressProof) {
	this.adressProof = adressProof;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getNationality() {
	return nationality;
}
public void setNationality(String nationality) {
	this.nationality = nationality;
}
public Customers(String customerID, String adressProof, int age, String firstName, String lastName, String pincode,
		String mobileNumber, String adress, String nationality) {
	super();
	this.customerID = customerID;
	this.adressProof = adressProof;
	this.age = age;
	this.firstName = firstName;
	this.lastName = lastName;
	this.pincode = pincode;
	this.mobileNumber = mobileNumber;
	this.adress = adress;
	this.nationality = nationality;
}
public Customers() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Customers [customerID=" + customerID + ", adressProof=" + adressProof + ", age=" + age + ", firstName="
			+ firstName + ", lastName=" + lastName + ", pincode=" + pincode + ", mobileNumber=" + mobileNumber
			+ ", adress=" + adress + ", nationality=" + nationality + ", hotel=" + hotel + ", feedback=" + feedback
			+ ", bookings=" + bookings + ", rooms=" + rooms + ", checkIns=" + checkIns + ", checkOuts=" + checkOuts
			+ ", servicesTaken=" + servicesTaken + ", payments=" + payments + "]";
}



}

package com.customer.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Payments {
	@Id	
	private String paymentID;
	@Column(length=30)
	private LocalDateTime paymentDate;
	@Column(length=30)
	private String paymentMethod;
	@Column(length=30)
	private double paymentAmount;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Customers> customers;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="payments_rooms",
	           joinColumns=@JoinColumn(name="paymentID"),
	           inverseJoinColumns=@JoinColumn(name="roomNo"))
	private Set<Rooms> rooms;
	public Payments(String paymentID, LocalDateTime paymentDate, String paymentMethod, double paymentAmount,
			List<Customers> customers, Set<Rooms> rooms) {
		super();
		this.paymentID = paymentID;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.paymentAmount = paymentAmount;
		this.customers = customers;
		this.rooms = rooms;
	}
	public Set<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Rooms> rooms) {
		this.rooms = rooms;
	}
	public Payments(String paymentID, LocalDateTime paymentDate, String paymentMethod, double paymentAmount,
			List<Customers> customers) {
		super();
		this.paymentID = paymentID;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.paymentAmount = paymentAmount;
		this.customers = customers;
	}
	public List<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Payments(String paymentID, LocalDateTime paymentDate, String paymentMethod, double paymentAmount) {
		super();
		this.paymentID = paymentID;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.paymentAmount = paymentAmount;
	}
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Payments [paymentID=" + paymentID + ", paymentDate=" + paymentDate + ", paymentMethod=" + paymentMethod
				+ ", paymentAmount=" + paymentAmount + ", customers=" + customers + ", rooms=" + rooms + "]";
	}
	
	
}

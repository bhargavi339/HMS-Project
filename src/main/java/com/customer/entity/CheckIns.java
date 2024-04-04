package com.customer.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class CheckIns {
	@Id	
	private String checkInID;
	@Column(length=30)
	private LocalDateTime checkInTimeStamp;
	@ManyToMany(mappedBy="checkIns",cascade=CascadeType.ALL)
	private Set<Customers> customers;
	public CheckIns(String checkInID, LocalDateTime checkInTimeStamp, Set<Customers> customers) {
		super();
		this.checkInID = checkInID;
		this.checkInTimeStamp = checkInTimeStamp;
		this.customers = customers;
	}
	public Set<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customers> customers) {
		this.customers = customers;
	}
	public String getCheckInID() {
		return checkInID;
	}
	public void setCheckInID(String checkInID) {
		this.checkInID = checkInID;
	}
	public LocalDateTime getCheckInTimeStamp() {
		return checkInTimeStamp;
	}
	public void setCheckInTimeStamp(LocalDateTime checkInTimeStamp) {
		this.checkInTimeStamp = checkInTimeStamp;
	}
	public CheckIns(String checkInID, LocalDateTime checkInTimeStamp) {
		super();
		this.checkInID = checkInID;
		this.checkInTimeStamp = checkInTimeStamp;
	}
	public CheckIns() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CheckIns [checkInID=" + checkInID + ", checkInTimeStamp=" + checkInTimeStamp + ", customers="
				+ customers + "]";
	}
	
}

package com.customer.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class CheckOuts {
@Id	
private String checkOutID;
@Column(length=30)
private LocalDateTime checkOutTimeStamp;
@ManyToMany(mappedBy="checkOuts",cascade=CascadeType.ALL)
private Set<Customers> customers;
public CheckOuts(String checkOutID, LocalDateTime checkOutTimeStamp, Set<Customers> customers) {
	super();
	this.checkOutID = checkOutID;
	this.checkOutTimeStamp = checkOutTimeStamp;
	this.customers = customers;
}
public Set<Customers> getCustomers() {
	return customers;
}
public void setCustomers(Set<Customers> customers) {
	this.customers = customers;
}
@Override
public String toString() {
	return "CheckOuts [checkOutID=" + checkOutID + ", checkOutTimeStamp=" + checkOutTimeStamp + ", customers="
			+ customers + "]";
}
public CheckOuts() {
	super();
	// TODO Auto-generated constructor stub
}
public CheckOuts(String checkOutID, LocalDateTime checkOutTimeStamp) {
	super();
	this.checkOutID = checkOutID;
	this.checkOutTimeStamp = checkOutTimeStamp;
}
public String getCheckOutID() {
	return checkOutID;
}
public void setCheckOutID(String checkOutID) {
	this.checkOutID = checkOutID;
}
public LocalDateTime getCheckOutTimeStamp() {
	return checkOutTimeStamp;
}
public void setCheckOutTimeStamp(LocalDateTime checkOutTimeStamp) {
	this.checkOutTimeStamp = checkOutTimeStamp;
}

}

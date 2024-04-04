package com.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
@Entity
public class ServicesTaken {
	@Id	
	private String serviceID;
	@Column(length=30)
	private double serviceBill;
	@ManyToOne(cascade=CascadeType.ALL)
	private Customers customers;
	@ManyToOne(cascade=CascadeType.ALL)
	private Services services;
	
	public ServicesTaken(Services services) {
		super();
		this.services = services;
	}
	public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}
	public ServicesTaken(String serviceID, double serviceBill) {
		super();
		this.serviceID = serviceID;
		this.serviceBill = serviceBill;
		
	}
	public ServicesTaken(String serviceID, double serviceBill, Customers customers, Services services) {
		super();
		this.serviceID = serviceID;
		this.serviceBill = serviceBill;
		this.customers = customers;
		this.services = services;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "ServicesTaken [serviceID=" + serviceID + ", serviceBill=" + serviceBill + ", customers=" + customers
				+ ", services=" + services + "]";
	}
	public ServicesTaken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServicesTaken(double serviceBill) {
		super();
		this.serviceBill = serviceBill;
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	public double getServiceBill() {
		return serviceBill;
	}
	public void setServiceBill(double serviceBill) {
		this.serviceBill = serviceBill;
	}
}

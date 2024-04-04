package com.customer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Services {
	@Id	
	private int serviceSerialNumber;
	@Column(length=30)
	private String serviceName;
	@Column(length=200)
	private String serviceDescription;
	@Column(length=30)
	private double cost;
	@ManyToOne(cascade=CascadeType.ALL)
	private Hotels hotels;
	@OneToMany(cascade=CascadeType.ALL)
	private List<ServicesTaken> servicesTaken;
	public Services(List<ServicesTaken> servicesTaken) {
		super();
		this.servicesTaken = servicesTaken;
	}
	public List<ServicesTaken> getServicesTaken() {
		return servicesTaken;
	}
	public void setServicesTaken(List<ServicesTaken> servicesTaken) {
		this.servicesTaken = servicesTaken;
	}
	public Services(Hotels hotels) {
		super();
		this.hotels = hotels;
	}
	public Hotels getHotels() {
		return hotels;
	}
	public void setHotels(Hotels hotels) {
		this.hotels = hotels;
	}
	@Override
	public String toString() {
		return "Services [serviceSerialNumber=" + serviceSerialNumber + ", serviceName=" + serviceName
				+ ", serviceDescription=" + serviceDescription + ", cost=" + cost + ", hotels=" + hotels
				+ ", servicesTaken=" + servicesTaken + "]";
	}
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Services(int serviceSerialNumber, String serviceName, String serviceDescription, double cost) {
		super();
		this.serviceSerialNumber = serviceSerialNumber;
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.cost = cost;
	}
	public int getServiceSerialNumber() {
		return serviceSerialNumber;
	}
	public void setServiceSerialNumber(int serviceSerialNumber) {
		this.serviceSerialNumber = serviceSerialNumber;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}

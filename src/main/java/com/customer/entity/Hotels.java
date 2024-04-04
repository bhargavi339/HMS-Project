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
import javax.persistence.OneToMany;
@Entity
public class Hotels {
	@Id	
	private String hotelID;
	@Column(length=30)
	private String hotelName;
	@Column(length=30)
	private String hotelLocation;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="hotels_inventory",
	           joinColumns=@JoinColumn(name="hotelID"),
	           inverseJoinColumns=@JoinColumn(name="goodsID"))
	private Set<Inventory> inventory;
	
	public Hotels(String hotelID, String hotelName, String hotelLocation, Set<Inventory> inventory,
			List<Employees> employees, List<Customers> customers, List<Rooms> rooms) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.inventory = inventory;
		this.employees = employees;
		this.customers = customers;
		this.rooms = rooms;
	}
	public Set<Inventory> getInventory() {
		return inventory;
	}
	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}
	public Hotels(String hotelID, String hotelName, String hotelLocation, List<Employees> employees) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.employees = employees;
	}
	public List<Employees> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	@OneToMany(cascade=CascadeType.ALL)
	private List<Employees> employees;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Services> services;
	public List<Services> getServices() {
		return services;
	}
	public Hotels(String hotelID, String hotelName, String hotelLocation, Set<Inventory> inventory,
			List<Employees> employees, List<Services> services, List<Customers> customers, List<Rooms> rooms) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.inventory = inventory;
		this.employees = employees;
		this.services = services;
		this.customers = customers;
		this.rooms = rooms;
	}
	public void setServices(List<Services> services) {
		this.services = services;
	}
	@OneToMany(cascade=CascadeType.ALL)
	private List<Customers> customers;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Rooms> rooms;
	
	
	public Hotels(List<Rooms> rooms) {
		super();
		this.rooms = rooms;
	}
	public List<Rooms> getRooms() {
		return rooms;
	}
	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}
	public Hotels(String hotelID, String hotelName, String hotelLocation, List<Employees> employees,
			List<Customers> customers) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.employees = employees;
		this.customers = customers;
	}
	public List<Customers> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	public Hotels(String hotelID, String hotelName, String hotelLocation) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
	}
	public Hotels() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Hotels [hotelID=" + hotelID + ", hotelName=" + hotelName + ", hotelLocation=" + hotelLocation
				+ ", inventory=" + inventory + ", employees=" + employees + ", services=" + services + ", customers="
				+ customers + ", rooms=" + rooms + "]";
	}
	
}

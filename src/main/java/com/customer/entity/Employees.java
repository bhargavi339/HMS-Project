package com.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Employees {
	@Id	
	private String employeeID;
	@Column(length=30)
	private String employeeName;
	@Column(length=30)
	private String jobDescription;
	@Column(length=30)
	private String mobileNumber;
	@Column(length=30)
	private String adress;
	@Column(length=30)
	private int age;
	@Column(length=30)
	private double salary;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Hotels hotel;
	public Employees(String employeeID, String employeeName, String jobDescription, String mobileNumber, String adress,
			int age, double salary, Hotels hotel) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.jobDescription = jobDescription;
		this.mobileNumber = mobileNumber;
		this.adress = adress;
		this.age = age;
		this.salary = salary;
		this.hotel = hotel;
	}
	public Hotels getHotel() {
		return hotel;
	}
	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employees(String employeeID, String employeeName, String jobDescription, String mobileNumber, String adress,
			int age, double salary) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.jobDescription = jobDescription;
		this.mobileNumber = mobileNumber;
		this.adress = adress;
		this.age = age;
		this.salary = salary;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employees [employeeID=" + employeeID + ", employeeName=" + employeeName + ", jobDescription="
				+ jobDescription + ", mobileNumber=" + mobileNumber + ", adress=" + adress + ", age=" + age
				+ ", salary=" + salary + ", hotel=" + hotel + "]";
	}
	
}

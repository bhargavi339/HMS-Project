package com.customer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Feedback {
	@Id	
	private String feedbackID;
	@Column(length=200)
	private String feedbackText;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customers customers;
	public Feedback(Customers customers) {
		super();
		this.customers = customers;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public String getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(String feedbackID) {
		this.feedbackID = feedbackID;
	}
	public String getFeedbackText() {
		return feedbackText;
	}
	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}
	public Feedback(String feedbackID, String feedbackText) {
		super();
		this.feedbackID = feedbackID;
		this.feedbackText = feedbackText;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Feedback [feedbackID=" + feedbackID + ", feedbackText=" + feedbackText + ", customers=" + customers
				+ "]";
	}
	
}

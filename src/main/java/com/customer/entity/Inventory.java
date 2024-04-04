package com.customer.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Inventory {
	@Id	
	private String goodsID;
	@Column(length=30)
	private String goodsName;
	@Column(length=30)
	private String goodsQuantity;
	@ManyToMany(mappedBy="inventory",cascade=CascadeType.ALL)
	private Set<Hotels> hotels;
	public Inventory(Set<Hotels> hotels) {
		super();
		this.hotels = hotels;
	}
	public Set<Hotels> getHotels() {
		return hotels;
	}
	public void setHotels(Set<Hotels> hotels) {
		this.hotels = hotels;
	}
	public String getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(String goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}
	public Inventory(String goodsID, String goodsName, String goodsQuantity) {
		super();
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.goodsQuantity = goodsQuantity;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Inventory [goodsID=" + goodsID + ", goodsName=" + goodsName + ", goodsQuantity=" + goodsQuantity
				+ ", hotels=" + hotels + "]";
	}
	
}

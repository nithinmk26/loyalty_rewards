package com.digital.order.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "order_details")
public class Order {
	
	public enum paymentmode{
		CASH , CARD , UPI 
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="order_id")
	private int orderId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id",referencedColumnName = "order_id")
	private List<Items> itemList;
	
	@CreationTimestamp
	private LocalDateTime orderedDate;
	
	@Column(name = "num_of_items")
	private int numOfItems;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Enumerated(EnumType.STRING)
	private paymentmode paymentMode ;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	public int getNumOfItems() {
		return numOfItems;
	}

	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public paymentmode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(paymentmode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Order(int orderId, String userId, String userName, List<Items> itemList, LocalDateTime orderedDate,
			int numOfItems, double totalPrice, paymentmode paymentMode) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.userName = userName;
		this.itemList = itemList;
		this.orderedDate = orderedDate;
		this.numOfItems = numOfItems;
		this.totalPrice = totalPrice;
		this.paymentMode = paymentMode;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}

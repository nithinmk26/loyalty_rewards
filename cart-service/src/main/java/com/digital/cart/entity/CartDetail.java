package com.digital.cart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cart_detail")
public class CartDetail {
	
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "cart_value")
	private double cartValue;
	
	@Column(name = "delivery_charges")
	private double deliveryCharges;
	
	@Column(name = "number_of_items")
	private int numOfItemsInCart;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id",referencedColumnName = "cart_id")
	private List<Item> itemList;

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/** 
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the cartValue
	 */
	public double getCartValue() {
		return cartValue;
	}

	/**
	 * @param cartValue the cartValue to set
	 */
	public void setCartValue(double cartValue) {
		this.cartValue = cartValue;
	}

	/**
	 * @return the deliveryCharges
	 */
	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	/**
	 * @param deliveryCharges the deliveryCharges to set
	 */
	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	/**
	 * @return the numOfItemsInCart
	 */
	public int getNumOfItemsInCart() {
		return numOfItemsInCart;
	}

	/**
	 * @param numOfItemsInCart the numOfItemsInCart to set
	 */
	public void setNumOfItemsInCart(int numOfItemsInCart) {
		this.numOfItemsInCart = numOfItemsInCart;
	}

	/**
	 * @return the itemList
	 */
	public List<Item> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public CartDetail() {
		super();
	}

	public CartDetail(int cartId, String userId, String userName, double cartValue, double deliveryCharges,
			int numOfItemsInCart, List<Item> itemList) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.userName = userName;
		this.cartValue = cartValue;
		this.deliveryCharges = deliveryCharges;
		this.numOfItemsInCart = numOfItemsInCart;
		this.itemList = itemList;
	}

	
}
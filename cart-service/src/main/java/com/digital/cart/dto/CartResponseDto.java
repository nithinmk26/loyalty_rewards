package com.digital.cart.dto;

import java.util.List;

public class CartResponseDto {
	
	private int cartId;
	
	private int userId;
	
	private String userName;	
	
	private double cartValue;
	
	private double deliveryCharges;
	
	private int numOfItemsInCart;
	
	private List<ItemDto> itemList;

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
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
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
	public List<ItemDto> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(List<ItemDto> itemList) {
		this.itemList = itemList;
	}
	
	

}

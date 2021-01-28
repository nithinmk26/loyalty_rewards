package com.digital.order.dto;

import java.util.List;

public class CartResponseDto {
	
	private int cartId;
	
	private String userId;

	private String userName;	
	
	private double cartValue;
	
	private double deliveryCharges;
	
	private int numOfItemsInCart;
	
	private List<ItemDto> itemList;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public double getCartValue() {
		return cartValue;
	}

	public void setCartValue(double cartValue) {
		this.cartValue = cartValue;
	}

	public double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public int getNumOfItemsInCart() {
		return numOfItemsInCart;
	}

	public void setNumOfItemsInCart(int numOfItemsInCart) {
		this.numOfItemsInCart = numOfItemsInCart;
	}

	public List<ItemDto> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDto> itemList) {
		this.itemList = itemList;
	}
	
	

}

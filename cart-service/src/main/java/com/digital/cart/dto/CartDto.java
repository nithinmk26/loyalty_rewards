package com.digital.cart.dto;

import java.util.List;

public class CartDto {
	
	private int cartId;

	private String userId;

	
	private String userName;	
	
	private List<ItemDto> itemList;

	/**
<<<<<<< HEAD
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
	
	public String getUserId() {
	return userId;
	}

	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

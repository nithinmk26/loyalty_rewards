package com.digital.cart.dto;

import java.util.List;

public class CartDto {
	
	private int userId;
	
	private String userName;	
	
	private List<ItemDto> itemList;

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

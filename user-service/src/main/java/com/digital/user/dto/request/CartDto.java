package com.digital.user.dto.request;

import java.util.List;

public class CartDto {
	
	private String userId;
	
	private String userName;	
	
	private List<ItemDto> itemList;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public CartDto setUserId(String userId) {
		this.userId = userId;
		return this;
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
	public CartDto setUserName(String userName) {
		this.userName = userName;
		return this;
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
	public CartDto setItemList(List<ItemDto> itemList) {
		this.itemList = itemList;
		return this;
	}

	
}

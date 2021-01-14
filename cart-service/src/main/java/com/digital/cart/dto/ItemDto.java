package com.digital.cart.dto;

import java.util.List;

import com.digital.cart.entity.Item;

public class ItemDto {
	
	private int id;
	
	private int productId;
	
	private String name;
	
	private String description;
	
	private String returnWithin;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the returnWithin
	 */
	public String getReturnWithin() {
		return returnWithin;
	}

	/**
	 * @param returnWithin the returnWithin to set
	 */
	public void setReturnWithin(String returnWithin) {
		this.returnWithin = returnWithin;
	}
	
	

}

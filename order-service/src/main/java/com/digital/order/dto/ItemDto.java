package com.digital.order.dto;

public class ItemDto {
	
	
	private int id;
	
	private int productId;
	
	private String name;
	
	private int quantity;
	
	private String description;
	
	private String returnWithin;
	
	private double productPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReturnWithin() {
		return returnWithin;
	}

	public void setReturnWithin(String returnWithin) {
		this.returnWithin = returnWithin;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	

}

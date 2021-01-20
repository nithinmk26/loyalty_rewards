package com.digital.productservice.dto;

public class ProductDto {
	
	private String name;
	
	private String licenseNum;
	
	private double price;
	
	private int quantity;
	
	private String description;
	
	private String manufactureDate;
	
	private String returnwithin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getReturnwithin() {
		return returnwithin;
	}

	public void setReturnwithin(String returnwithin) {
		this.returnwithin = returnwithin;
	}

	
	
}
package com.digital.productservice.dto;

import javax.persistence.Column;

public class HouseHoldDto {
	
	private String name;
	
	private String licenseNum;
	
	private double price;
	
	private int quantity;
	
	private String description;

	private String manufactureDate;
	
	private String returnwithin;
	
	private String brand ;

	private String type;

	public HouseHoldDto(String name, String licenseNum, double price, int quantity, String description,
			String manufactureDate, String returnwithin, String brand, String type) {
		super();
		this.name = name;
		this.licenseNum = licenseNum;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.returnwithin = returnwithin;
		this.brand = brand;
		this.type = type;
	}

	public HouseHoldDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

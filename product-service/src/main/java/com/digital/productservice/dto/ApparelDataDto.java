package com.digital.productservice.dto;

import javax.persistence.Column;

public class ApparelDataDto {
	
	private String name;
	
	private String licenseNum;
	
	private double price;
	
	private int quantity;
	
	private String description;
	
	private String manufactureDate;
	
	private String returnwithin;
	
	private String brand ;
	
	private String type;

	private String size ;
	
	private String gender ;

	private String colour;

	public ApparelDataDto(String name, String licenseNum, double price, int quantity, String description,
			String manufactureDate, String returnwithin, String brand, String type, String size, String gender,
			String colour) {
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
		this.size = size;
		this.gender = gender;
		this.colour = colour;
	}

	public ApparelDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
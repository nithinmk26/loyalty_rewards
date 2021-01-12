package com.digital.productservice.dto;

import javax.persistence.Column;

public class ElectronicAppliancesDto {
	
	private String name;
	
	private String licenseNum;
	
	private double price;
	
	private int quantity;
	
	private String description;
	
	private String manufactureDate;
	
	private String returnwithin;
	
	private String brand; 
	
	private String model; 

	private String manufacturedby; 

	private String design ;

	public ElectronicAppliancesDto(String name, String licenseNum, double price, int quantity, String description,
			String manufactureDate, String returnwithin, String brand, String model, String manufacturedby,
			String design) {
		super();
		this.name = name;
		this.licenseNum = licenseNum;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.returnwithin = returnwithin;
		this.brand = brand;
		this.model = model;
		this.manufacturedby = manufacturedby;
		this.design = design;
	}

	public ElectronicAppliancesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

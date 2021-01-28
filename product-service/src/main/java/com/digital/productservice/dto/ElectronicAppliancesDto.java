package com.digital.productservice.dto;

public class ElectronicAppliancesDto extends ProductDto{

	private String brand; 
	
	private String model; 

	private String manufacturedby; 

	private String design ;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturedby() {
		return manufacturedby;
	}

	public void setManufacturedby(String manufacturedby) {
		this.manufacturedby = manufacturedby;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	
	
}

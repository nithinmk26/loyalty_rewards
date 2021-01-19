/**
 * 
 */
package com.digital.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Loyalty_digiTeam
 *
 */
@Entity
@Table(name = "electronic_appliances_details")
public class ElectronicAppliancesData extends Product {

	@Column(name = "electric_brand")
	private String brand; 

	@Column(name = "electric_model")
	private String model; 

	@Column(name = "electric_item_manufacturedby")
	private String manufacturedby; 

	@Column(name = "electric_design")
	private String design ;

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the manufacturedby
	 */
	public String getManufacturedby() {
		return manufacturedby;
	}

	/**
	 * @param manufacturedby the manufacturedby to set
	 */
	public void setManufacturedby(String manufacturedby) {
		this.manufacturedby = manufacturedby;
	}

	/**
	 * @return the design
	 */
	public String getDesign() {
		return design;
	}

	/**
	 * @param design the design to set
	 */
	public void setDesign(String design) {
		this.design = design;
	}

	/**
	 * @param id
	 * @param name
	 * @param licenseNum
	 * @param price
	 * @param quantity
	 * @param description
	 * @param manufactureDate
	 * @param returnwithin
	 * @param brand
	 * @param model
	 * @param manufacturedby
	 * @param design
	 */
	public ElectronicAppliancesData(int id, String name, String licenseNum, double price, int quantity,
			String description, String manufactureDate, String returnwithin, String brand, String model,
			String manufacturedby, String design) {
		super();
		this.brand = brand;
		this.model = model;
		this.manufacturedby = manufacturedby;
		this.design = design;
	}

	/**
	 * 
	 */
	public ElectronicAppliancesData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param licenseNum
	 * @param price
	 * @param quantity
	 * @param description
	 * @param manufactureDate
	 * @param returnwithin
	 */
	public ElectronicAppliancesData(int id, String name, String licenseNum, double price, int quantity,
			String description, String manufactureDate, String returnwithin) {
		super(id, name, licenseNum, price, quantity, description, manufactureDate, returnwithin);
		// TODO Auto-generated constructor stub
	}



}

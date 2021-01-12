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
@Table(name = "apparel_details")
public class ApparelData extends Product{
	
	@Column(name = "apparel_brand")
	private String brand ;
	
	@Column(name = "apparel_type")
	private String type;
	
	@Column(name = "apparel_size")
	private String size ;
	
	@Column(name = "apparel_gender")
	private String gender ;
	
	@Column(name = "apparel_colour")
	private String colour;

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
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
	 * @param type
	 * @param size
	 * @param gender
	 * @param colour
	 */
	public ApparelData(int id, String name, String licenseNum, double price, int quantity, String description,
			String manufactureDate, String returnwithin, String brand, String type, String size, String gender,
			String colour) {
		super();
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.gender = gender;
		this.colour = colour;
	}

	/**
	 * 
	 */
	public ApparelData() {
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
	public ApparelData(int id, String name, String licenseNum, double price, int quantity, String description,
			String manufactureDate, String returnwithin) {
		super(id, name, licenseNum, price, quantity, description, manufactureDate, returnwithin);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}

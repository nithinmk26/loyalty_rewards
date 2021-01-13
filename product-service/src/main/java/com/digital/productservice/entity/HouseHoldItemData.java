package com.digital.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Loyalty_digiTeam
 *
 */
@Entity
@Table(name = "house_hold_item_data")
public class HouseHoldItemData extends Product{

	@Column(name = "item_brand")
	private String brand ;

	@Column(name = "item_type")
	private String type;

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
	 * @param brand
	 * @param type
	 */
	public HouseHoldItemData(String brand, String type) {
		super();
		this.brand = brand;
		this.type = type;
	}

	/**
	 * 
	 */
	public HouseHoldItemData() {
		super();
		// TODO Auto-generated constructor stub
	}




}

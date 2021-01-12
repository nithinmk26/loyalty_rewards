/**
 * 
 */
package com.digital.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Loyalty_digiTeam
 *
 */
@Entity
@Table(name = "product_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int id;
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "product_license_num")
	private String licenseNum;
	
	@Column(name = "product_price")
	private double price;
	
	@Column(name = "product_quantity")
	private int quantity;
	
	@Column(name = "product_description")
	private String description;
	
	@Column(name = "product_mfd_date")
	private String manufactureDate;
	
	@Column(name = "product_return_within")
	private String returnwithin;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the licenseNum
	 */
	public String getLicenseNum() {
		return licenseNum;
	}
	/**
	 * @param licenseNum the licenseNum to set
	 */
	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @return the manufactureDate
	 */
	public String getManufactureDate() {
		return manufactureDate;
	}
	/**
	 * @param manufactureDate the manufactureDate to set
	 */
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	/**
	 * @return the returnwithin
	 */
	public String getReturnwithin() {
		return returnwithin;
	}
	/**
	 * @param returnwithin the returnwithin to set
	 */
	public void setReturnwithin(String returnwithin) {
		this.returnwithin = returnwithin;
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
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
	public Product(int id, String name, String licenseNum, double price, int quantity, String description,
			String manufactureDate, String returnwithin) {
		super();
		this.id = id;
		this.name = name;
		this.licenseNum = licenseNum;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.manufactureDate = manufactureDate;
		this.returnwithin = returnwithin;
	}
	
	public Product() {
		super();
	}
	
	
	
	
	

}

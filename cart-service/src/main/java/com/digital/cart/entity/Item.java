/**
 * 
 */
package com.digital.cart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author M1056182
 *
 */
@Entity
@Table(name = "item_list")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int id;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "prodcut_description")
	private String description;
	
	@Column(name = "return_within")
	private String returnWithin;
	
	

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * @return the returnWithin
	 */
	public String getReturnWithin() {
		return returnWithin;
	}

	/**
	 * @param returnWithin the returnWithin to set
	 */
	public void setReturnWithin(String returnWithin) {
		this.returnWithin = returnWithin;
	}
	
	
	
}

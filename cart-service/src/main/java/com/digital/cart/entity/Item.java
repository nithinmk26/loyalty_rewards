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
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "prodcut_description")
	private String description;
	
	@Column(name = "return_within")
	private String returnWithin;
	
	@Column(name = "product_price")
	private double productPrice;
	

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
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

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

	@Override
	public String toString() {
		return "Item [id=" + id + ", productId=" + productId + ", quantity=" + quantity + ", name=" + name
				+ ", description=" + description + ", returnWithin=" + returnWithin + ", productPrice=" + productPrice
				+ "]";
	}
	
	
	
}

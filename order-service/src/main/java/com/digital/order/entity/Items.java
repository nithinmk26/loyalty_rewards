package com.digital.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemList")
public class Items {
	
	@Id
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReturnWithin() {
		return returnWithin;
	}

	public void setReturnWithin(String returnWithin) {
		this.returnWithin = returnWithin;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Items(int id, int productId, int quantity, String name, String description, String returnWithin,
			double productPrice) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.name = name;
		this.description = description;
		this.returnWithin = returnWithin;
		this.productPrice = productPrice;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
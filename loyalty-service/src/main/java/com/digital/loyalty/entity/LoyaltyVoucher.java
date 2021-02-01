package com.digital.loyalty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loyalty_voucher")
public class LoyaltyVoucher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voucher_id")
	private int id;
	
	@Column(name = "voucher_description")
    private String description;
	
	@Column(name = "engagement_name")
    private String engagementName;
	
	@Column(name = "voucher_country")
    private String country;
	
	@Column(name = "voucher_validity")
    private int voucherValidity;
	
	@Column(name = "discount_in_percentage")
    private int discountInPercent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEngagementName() {
		return engagementName;
	}

	public void setEngagementName(String engagementName) {
		this.engagementName = engagementName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getVoucherValidity() {
		return voucherValidity;
	}

	public void setVoucherValidity(int voucherValidity) {
		this.voucherValidity = voucherValidity;
	}

	public int getDiscountInPercent() {
		return discountInPercent;
	}

	public void setDiscountInPercent(int discountInPercent) {
		this.discountInPercent = discountInPercent;
	}

	public LoyaltyVoucher(int id, String description, String engagementName, String country, int voucherValidity,
			int discountInPercent) {
		super();
		this.id = id;
		this.description = description;
		this.engagementName = engagementName;
		this.country = country;
		this.voucherValidity = voucherValidity;
		this.discountInPercent = discountInPercent;
	}

	public LoyaltyVoucher() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

package com.digital.loyalty.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "engagement_detail")
public class EngagementDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "engagement_id")
	private int id;
	
	@Column(name = "engagement_description")
    private String description;
	
	@Column(name = "engagement_name")
    private String engagementName;
	
	@Column(name = "engagement_country")
    private String country;
	
	@Column(name = "voucher_code")
    private String voucherCode;
	
	@Column(name = "voucher_validity")
    private String voucherValidity;
	
	@Column(name = "discount_in_percentage")
    private int discountInPercent;
	
	@Column(name = "assigned_date")
    private LocalDate assignedDate ;

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

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getVoucherValidity() {
		return voucherValidity;
	}

	public void setVoucherValidity(String voucherValidity) {
		this.voucherValidity = voucherValidity;
	}

	public int getDiscountInPercent() {
		return discountInPercent;
	}

	public void setDiscountInPercent(int discountInPercent) {
		this.discountInPercent = discountInPercent;
	}

	public LocalDate getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}

	public EngagementDetail(int id, String description, String engagementName, String country, String voucherCode,
			String voucherValidity, int discountInPercent, LocalDate assignedDate) {
		super();
		this.id = id;
		this.description = description;
		this.engagementName = engagementName;
		this.country = country;
		this.voucherCode = voucherCode;
		this.voucherValidity = voucherValidity;
		this.discountInPercent = discountInPercent;
		this.assignedDate = assignedDate;
	}

	public EngagementDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

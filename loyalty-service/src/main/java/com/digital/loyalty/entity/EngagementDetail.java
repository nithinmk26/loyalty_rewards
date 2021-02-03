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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDate voucherValidity;
	
	@Column(name = "discount_in_percentage")
    private int discountInPercent;
	
	@Column(name = "assigned_date")
    private LocalDate assignedDate ;
	
	//make it bidirectioanal and dleete expired vocher from user
	
	
	public int getId() {
		return id;
	}

	public EngagementDetail setId(int id) {
		this.id = id;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public EngagementDetail setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getEngagementName() {
		return engagementName;
	}

	public EngagementDetail setEngagementName(String engagementName) {
		this.engagementName = engagementName;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public EngagementDetail setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public EngagementDetail setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
		return this;
	}

	public LocalDate getVoucherValidity() {
		return voucherValidity;
	}


	public EngagementDetail setVoucherValidity(LocalDate voucherValidity) {
		this.voucherValidity = voucherValidity;
		return this;
	}

	public int getDiscountInPercent() {
		return discountInPercent;
	}

	public EngagementDetail setDiscountInPercent(int discountInPercent) {
		this.discountInPercent = discountInPercent;
		return this;
	}

	public LocalDate getAssignedDate() {
		return assignedDate;
	}

	public EngagementDetail setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
		return this;
	}

	public EngagementDetail(int id, String description, String engagementName, String country, String voucherCode,
			LocalDate voucherValidity, int discountInPercent, LocalDate assignedDate) {
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
	}
	
	
}

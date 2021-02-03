package com.digital.loyalty.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "loyalty_member")
public class LoyaltyMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_id")
	private int serialId;
	
	@Column(name = "loyalty_member_id")
	private String memberId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "loyalty_points")
	private double loyaltyPoints;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@OneToOne
	@JoinColumn(name = "tier_id")
	private TierLevel tier;
	
	@Column(name = "country")
	private String country;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDate modifiedDate;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 @JoinTable(name = "loyalty_member_engagements", 
     joinColumns = { @JoinColumn(name = "serial_id") }, 
     inverseJoinColumns = { @JoinColumn(name = "engagement_id") })
	private List<EngagementDetail> engagementDetail;

	public int getSerialId() {
		return serialId;
	}

	public LoyaltyMember setSerialId(int serialId) {
		this.serialId = serialId;
		return this;
	}

	public String getMemberId() {
		return memberId;
	}

	public LoyaltyMember setMemberId(String memberId) {
		this.memberId = memberId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public LoyaltyMember setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getName() {
		return name;
	}

	public LoyaltyMember setName(String name) {
		this.name = name;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public LoyaltyMember setEmail(String email) {
		this.email = email;
		return this;
	}

	public double getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public LoyaltyMember setLoyaltyPoints(double loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
		return this;
	}

	public TierLevel getTier() {
		return tier;
	}

	public LoyaltyMember setTier(TierLevel tier) {
		this.tier = tier;
		return this;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public LoyaltyMember setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public LoyaltyMember setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}	

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public LoyaltyMember setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public LoyaltyMember setCountry(String country) {
		this.country = country;
		return this;
	}

	/**
	 * @return the engagementDetail
	 */
	public List<EngagementDetail> getEngagementDetail() {
		return engagementDetail;
	}

	/** 
	 * @param engagementDetail the engagementDetail to set
	 */
	public LoyaltyMember setEngagementDetail(List<EngagementDetail> engagementDetail) {
		this.engagementDetail = engagementDetail;
		return this;
	}



	
	

}

package com.digital.loyalty.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@ManyToMany
	 @JoinTable(name = "loyalty_member_engagements", 
     joinColumns = { @JoinColumn(name = "serial_id") }, 
     inverseJoinColumns = { @JoinColumn(name = "engagement_id") })
	private List<EngagementDetail> engagementDetail;

	public int getSerialId() {
		return serialId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(double loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public TierLevel getTier() {
		return tier;
	}

	public void setTier(TierLevel tier) {
		this.tier = tier;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<EngagementDetail> getEngagementDetails() {
		return engagementDetail;
	}

	public void setEngagementDetails(List<EngagementDetail> engagementDetail) {
		this.engagementDetail = engagementDetail;
	}

	public LoyaltyMember(int serialId, String memberId, String userId, String name, String email, double loyaltyPoints,
			TierLevel tier, LocalDate createdDate, LocalDate modifiedDate, List<EngagementDetail> engagementDetail) {
		super();
		this.serialId = serialId;
		this.memberId = memberId;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.loyaltyPoints = loyaltyPoints;
		this.tier = tier;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.engagementDetail = engagementDetail;
	}

	public LoyaltyMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

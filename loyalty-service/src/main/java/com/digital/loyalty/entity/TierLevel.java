package com.digital.loyalty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tier_level")
public class TierLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tier_id")
	private int id;
	
	@Column(name = "tier_name")
	private String tierName;
	
	@Column(name = "tier_level")
	private String tierLevel;
	
	@Column(name = "lower_bound_tier_value")
	private int lowerBoundTierValue;
	
	@Column(name = "upper_bound_tier_value")
	private int upperBoundTierValue;
	
	@Column(name = "tier_country")
	private String country;
	

}

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
	private int levelOftheTier;
	
	@Column(name = "lower_bound_tier_value")
	private int lowerBoundTierValue;
	
	@Column(name = "upper_bound_tier_value")
	private int upperBoundTierValue;
	
	@Column(name = "tier_country")
	private String country;

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
	 * @return the tierName
	 */
	public String getTierName() {
		return tierName;
	}

	/**
	 * @param tierName the tierName to set
	 */
	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

	/**
	 * @return the levelOftheTier
	 */
	public int getLevelOftheTier() {
		return levelOftheTier;
	}

	/**
	 * @param levelOftheTier the levelOftheTier to set
	 */
	public void setLevelOftheTier(int levelOftheTier) {
		this.levelOftheTier = levelOftheTier;
	}

	/**
	 * @return the lowerBoundTierValue
	 */
	public int getLowerBoundTierValue() {
		return lowerBoundTierValue;
	}

	/**
	 * @param lowerBoundTierValue the lowerBoundTierValue to set
	 */
	public void setLowerBoundTierValue(int lowerBoundTierValue) {
		this.lowerBoundTierValue = lowerBoundTierValue;
	}

	/**
	 * @return the upperBoundTierValue
	 */
	public int getUpperBoundTierValue() {
		return upperBoundTierValue;
	}

	/**
	 * @param upperBoundTierValue the upperBoundTierValue to set
	 */
	public void setUpperBoundTierValue(int upperBoundTierValue) {
		this.upperBoundTierValue = upperBoundTierValue;
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
	public void setCountry(String country) {
		this.country = country;
	}
	
}

package com.digital.loyalty.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loyalty_rewards")
public class LoyaltyRewards {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rewards_id")
	private int id;
	
	@Column(name = "reward_description")
    private String description;
	
	@Column(name = "rewards_in_percentage")
    private int rewardsInPercent;
	
	@Column(name = "engagement_name")
    private String engagementName;
	
	@Column(name = "reward_country")
    private String country;

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

	public int getRewardsInPercent() {
		return rewardsInPercent;
	}

	public void setRewardsInPercent(int rewardsInPercent) {
		this.rewardsInPercent = rewardsInPercent;
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

	public LoyaltyRewards(int id, String description, int rewardsInPercent, String engagementName, String country) {
		super();
		this.id = id;
		this.description = description;
		this.rewardsInPercent = rewardsInPercent;
		this.engagementName = engagementName;
		this.country = country;
	}

	public LoyaltyRewards() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

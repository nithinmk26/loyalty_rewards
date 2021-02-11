package com.digital.user.dto.request;

import java.time.LocalDate;

public class UserProfileRequestLoyaltyMember {
	
	private String userId;
	
	private String userName;
	
	private String userEmail;
	
	private String country;
	
	private String dateOfBirth;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public UserProfileRequestLoyaltyMember setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public UserProfileRequestLoyaltyMember setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public UserProfileRequestLoyaltyMember setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public UserProfileRequestLoyaltyMember setCountry(String country) {
		this.country = country;
		return this;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public UserProfileRequestLoyaltyMember setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}
	
	

}

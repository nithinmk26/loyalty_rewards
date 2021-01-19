package com.digital.user.service;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.digital.user.dto.request.UserProfileUpdateDto;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;

public interface UserService {


	String updateProfile(OAuth2User oAuth2User, UserProfileUpdateDto userProfileUpdateDto) throws LoyaltyRewardsGlobalAppException ;

	String isProfileUptoDate(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException;

	
	
}

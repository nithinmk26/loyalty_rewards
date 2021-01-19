package com.digital.user.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.digital.user.dto.request.UserProfileUpdateDto;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;
import com.digital.user.service.UserService;

@Service
public class UserFacade {
	
	@Autowired
	private UserService userService;

	public String updateProfile(OAuth2User oAuth2User, UserProfileUpdateDto userProfileUpdateDto) throws LoyaltyRewardsGlobalAppException {
		return userService.updateProfile(oAuth2User,userProfileUpdateDto);
	}

	public String varifyProfile(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException {
		return userService.isProfileUptoDate(oAuth2User);
		
	}

}

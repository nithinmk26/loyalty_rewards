package com.digital.user.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.digital.user.dto.request.CartResponseDto;
import com.digital.user.dto.request.ItemDto;
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

	public String addToCart(OAuth2User oAuth2User, List<ItemDto> itemList) throws LoyaltyRewardsGlobalAppException {
		return userService.addToCart(oAuth2User,itemList);
	}

	public String deleteCartDetails(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException {
		return userService.deleteCartDetails(oAuth2User);
	}

	public String deleteItemInCartDetails(OAuth2User oAuth2User, int productId) throws LoyaltyRewardsGlobalAppException {
		return userService.deleteItemInCartDetails(oAuth2User,productId);
	}

	public CartResponseDto getCartByUserId(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException {
		return userService.getCartByUserId(oAuth2User);
	}


}

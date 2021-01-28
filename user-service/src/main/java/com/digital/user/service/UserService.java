package com.digital.user.service;

import java.util.List;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.digital.user.dto.request.CartResponseDto;
import com.digital.user.dto.request.ItemDto;
import com.digital.user.dto.request.UserProfileUpdateDto;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;

public interface UserService {


	String updateProfile(OAuth2User oAuth2User, UserProfileUpdateDto userProfileUpdateDto) throws LoyaltyRewardsGlobalAppException ;

	String isProfileUptoDate(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException;

	String addToCart(OAuth2User oAuth2User, List<ItemDto> itemList) throws LoyaltyRewardsGlobalAppException;

	String deleteCartDetails(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException;

	CartResponseDto getCartByUserId(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException;

	String deleteItemInCartDetails(OAuth2User oAuth2User, int productId) throws LoyaltyRewardsGlobalAppException;

	
	
}

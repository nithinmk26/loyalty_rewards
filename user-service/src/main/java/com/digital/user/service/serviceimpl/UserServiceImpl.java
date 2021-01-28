package com.digital.user.service.serviceimpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.digital.user.dao.UserDao;
import com.digital.user.dto.request.CartDto;
import com.digital.user.dto.request.CartResponseDto;
import com.digital.user.dto.request.ItemDto;
import com.digital.user.dto.request.UserProfileUpdateDto;
import com.digital.user.entity.UserInformation;
import com.digital.user.exception.CartServiceProxyAppException;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;
import com.digital.user.exception.ProfileUpdatedException;
import com.digital.user.proxy.CartServiceProxy;
import com.digital.user.service.UserService;

import feign.FeignException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Autowired
	private CartServiceProxy cartServiceProxy;


	@Override
	public String updateProfile(OAuth2User oAuth2User, UserProfileUpdateDto userProfileUpdateDto) throws LoyaltyRewardsGlobalAppException  {
		Optional<UserInformation> userInfo = userDao.fetchUserByUserId(oAuth2User.getName());
		if (userInfo.isPresent()) {
			userInfo.get().setUserAddress(userProfileUpdateDto.getUserAddress());
			userInfo.get().setUserPhoneNumber(userProfileUpdateDto.getUserPhoneNumber());
			userInfo.get().setLastLoggedIn(userInfo.get().getLoggedInTime());
			userInfo.get().setLoggedInTime(LocalDate.now());
			userDao.updateUserProfile(userInfo.get());
		}
		else {
			UserInformation newUser = new UserInformation();
			newUser.setUserId(oAuth2User.getName());
			newUser.setUserAddress(userProfileUpdateDto.getUserAddress());
			newUser.setUserPhoneNumber(userProfileUpdateDto.getUserPhoneNumber());
			newUser.setEmailVarified(oAuth2User.getAttribute("email_verified"));
			newUser.setFirstName(oAuth2User.getAttribute("given_name"));
			newUser.setLastName(oAuth2User.getAttribute("family_name"));
			newUser.setUserName(oAuth2User.getAttribute("name"));
			newUser.setUserEmail(oAuth2User.getAttribute("email"));
			newUser.setLastLoggedIn(null);
			newUser.setLoggedInTime(LocalDate.now());
			userDao.saveUser(newUser);
		}
		return "User Profile SuccessFully Updated...!";
	}

	public String isProfileUptoDate(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException  {
		Optional<UserInformation> userInfo = userDao.fetchUserByUserId(oAuth2User.getName());
		userInfo.orElseThrow(()->new ProfileUpdatedException("First You need to update the profile then procced ..!")).getFirstName();
		if (userInfo.get().getUserPhoneNumber() == 0L) {
			throw new ProfileUpdatedException("Please update your Phone Number.. then proceed");
		}

		return "User Profile up to date.!";

	}

	@Override
	public String addToCart(OAuth2User oAuth2User, List<ItemDto> itemList) throws LoyaltyRewardsGlobalAppException {
		isProfileUptoDate(oAuth2User);
		CartDto cartDto = new CartDto().setUserId(oAuth2User.getName()).setUserName(oAuth2User.getAttribute("family_name")).setItemList(itemList);
		try {
			return cartServiceProxy.addToCart(cartDto).getBody();
		}
		catch (FeignException e) {
			throw new CartServiceProxyAppException(e.contentUTF8());
		}
	}

	@Override
	public String deleteCartDetails(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException {
		try {
			return cartServiceProxy.deleteCartDetails(oAuth2User.getName()).getBody();
		}
		catch (FeignException e) {
			throw new CartServiceProxyAppException(e.contentUTF8());
		}
	}

	@Override
	public CartResponseDto getCartByUserId(OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException {
		try {
			return cartServiceProxy.getCartByUserId(oAuth2User.getName()).getBody();
		}
		catch (FeignException e) {
			throw new CartServiceProxyAppException(e.contentUTF8());
		}
		
	}

	@Override
	public String deleteItemInCartDetails(OAuth2User oAuth2User, int productId) throws LoyaltyRewardsGlobalAppException {
		try {
			return cartServiceProxy.deleteItemInCartDetails(oAuth2User.getName(), productId).getBody();
		}
		catch (FeignException e) {
			throw new CartServiceProxyAppException(e.contentUTF8());
		}
	}

	

}

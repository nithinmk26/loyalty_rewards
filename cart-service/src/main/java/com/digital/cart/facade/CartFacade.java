/**
 * 
 */
package com.digital.cart.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dto.CartDto;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;
import com.digital.cart.exception.LoyaltyRewardsGlobalAppException;
import com.digital.cart.service.ICartService;
import com.digital.cart.utility.UtilityMethods;

/**
 * @author Loyalty_Digiteam
 *
 */
@Service
public class CartFacade {
	
	@Autowired
	private ICartService cartService;

//<<<<<<< HEAD
//	public CartDto addToCart(CartDto cartDto) throws CartPersistingException, CartFetchingException {
//		CartDetail cartDetail = UtilityMethods.convertCartDtotoEntity(cartDto);
//		CartDto cartDtoObj = UtilityMethods.convertCartToDto(cartService.addToCart(cartDetail));
//		return cartDtoObj;
//	}
	
	public String deleteCartDetails(int userId) throws CartPersistingException {
		return cartService.deleteServiceCartDetails(userId);
	}

	public String addToCart(CartDto cartDto) throws LoyaltyRewardsGlobalAppException {
		CartDetail cartDetail = UtilityMethods.convertCartDtotoEntity(cartDto);
		String message = cartService.addToCart(cartDetail);
		return message;

	}
	
	public String deleteItemInCartDetails(int userId , int itemId) throws LoyaltyRewardsGlobalAppException {
		return cartService.deleteItemInCartDetails(userId , itemId);
	}
	
	
	

}

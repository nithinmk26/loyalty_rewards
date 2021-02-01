package com.digital.cart.facade;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dto.CartDto;
import com.digital.cart.dto.CartResponseDto;
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
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public String deleteCartDetails(String userId) throws CartPersistingException {
		return cartService.deleteServiceCartDetails(userId);
	}

	public String addToCart(CartDto cartDto) throws LoyaltyRewardsGlobalAppException {
		CartDetail cartDetail = UtilityMethods.convertCartDtotoEntity(cartDto);
		return cartService.addToCart(cartDetail);
 		

	}
	
	public String deleteItemInCartDetails(String userId , int productId) throws LoyaltyRewardsGlobalAppException {
		return cartService.deleteItemInCartDetails(userId , productId);
	}

	public CartResponseDto getCartByUserId(String userId) throws CartFetchingException {
		CartDetail cartDetail = cartService.getCartByUserId(userId);
		return UtilityMethods.convertCartToDto(cartDetail);
	}
	  
}

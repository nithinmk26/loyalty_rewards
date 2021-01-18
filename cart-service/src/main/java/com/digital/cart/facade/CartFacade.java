/**
 * 
 */
package com.digital.cart.facade;

import java.util.List;

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
//		CartDetail cartDetail = modelMapper.map(cartDto, CartDetail.class);
		CartDetail cartDetail = UtilityMethods.convertCartDtotoEntity(cartDto);
		return cartService.addToCart(cartDetail);
 		

	}
	
	public String deleteItemInCartDetails(String userId , int itemId) throws LoyaltyRewardsGlobalAppException {
		return cartService.deleteItemInCartDetails(userId , itemId);
	}

	public CartResponseDto getCartByUserId(String userId) throws CartFetchingException {
		CartDetail cartDetail = cartService.getCartByUserId(userId);
		return UtilityMethods.convertCartToDto(cartDetail);
	}
	  
	
	

}

/**
 * 
 */
package com.digital.cart.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dto.CartDto;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartPersistingException;
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

	public CartDto addToCart(CartDto cartDto) throws CartPersistingException {
		CartDetail cartDetail = UtilityMethods.convertCartDtotoEntity(cartDto);
		cartService.addToCart(cartDetail);
		return null;
	}
	
	
	

}

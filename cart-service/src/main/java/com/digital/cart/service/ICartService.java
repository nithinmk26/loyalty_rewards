package com.digital.cart.service;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;
import com.digital.cart.exception.LoyaltyRewardsGlobalAppException;

/**
 * @author Loyalty_Digiteam
 *
 *
package com.digital.cart.service;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;
import com.digital.cart.exception.LoyaltyRewardsGlobalAppException;


/**
 * @author Loyalty_Digiteam
 *
 */
public interface ICartService {


	//CartDetail addToCart(CartDetail cartDetail)throws CartPersistingException, CartFetchingException ;
	
	String deleteServiceCartDetails(String userId) throws CartPersistingException;

	String addToCart(CartDetail cartDetail) throws LoyaltyRewardsGlobalAppException;

	String deleteItemInCartDetails(String userId , int itemId) throws CartPersistingException , CartFetchingException;

	CartDetail getCartByUserId(String userId) throws CartFetchingException;
}

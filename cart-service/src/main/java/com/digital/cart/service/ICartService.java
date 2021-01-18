/**
 * 
 */
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
	
	String deleteServiceCartDetails(int userId) throws CartPersistingException;

	String addToCart(CartDetail cartDetail) throws LoyaltyRewardsGlobalAppException;

	String deleteItemInCartDetails(int userId , int itemId) throws CartPersistingException , CartFetchingException;

	CartDetail getCartByUserId(int userId) throws CartFetchingException;
}

/**
 * 
 */
package com.digital.cart.service;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.LoyaltyRewardsGlobalAppException;

/**
 * @author Loyalty_Digiteam
 *
 */
public interface ICartService {

	String addToCart(CartDetail cartDetail) throws LoyaltyRewardsGlobalAppException;

}

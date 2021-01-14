/**
 * 
 */
package com.digital.cart.service;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartPersistingException;

/**
 * @author Loyalty_Digiteam
 *
 */
public interface ICartService {

	CartDetail addToCart(CartDetail cartDetail) throws CartPersistingException;

}

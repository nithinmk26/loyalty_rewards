package com.digital.cart.dao;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartPersistingException;

public interface ICartDao {
	
	CartDetail createCart(CartDetail cartDetail) throws CartPersistingException;

	CartDetail getUsercartByUserId(int userId);

}

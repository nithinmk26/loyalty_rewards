package com.digital.cart.dao;

import java.util.Optional;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;

public interface ICartDao {
	
	CartDetail createCart(CartDetail cartDetail) throws CartPersistingException;

	Optional<CartDetail> getUsercartByUserId(int userId) throws CartFetchingException;

	CartDetail updateExistingCart(Optional<CartDetail> existedCart) throws CartPersistingException;

}

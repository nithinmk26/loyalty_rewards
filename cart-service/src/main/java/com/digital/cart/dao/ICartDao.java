package com.digital.cart.dao;

import java.util.Optional;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;

public interface ICartDao {
	
	CartDetail createCart(CartDetail cartDetail) throws CartPersistingException;
	
	boolean deleteCartByUserId(int userId) throws CartPersistingException;
	
	Optional<CartDetail> getUsercartByUserId(int userId) throws CartFetchingException;

	CartDetail updateExistingCart(CartDetail existedCart) throws CartPersistingException;
	
	String  deleteItemByCartUserId(int itemId , Optional<CartDetail> cart) throws CartPersistingException;
	

}

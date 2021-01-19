package com.digital.cart.dao;


import java.util.Optional;

import com.digital.cart.entity.CartDetail;
import java.util.List;
import java.util.Optional;

import com.digital.cart.entity.CartDetail;
import com.digital.cart.entity.Item;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;

public interface ICartDao {
	
	CartDetail createCart(CartDetail cartDetail) throws CartPersistingException;

	CartDetail updateExistingCart(Optional<CartDetail> existedCart) throws CartPersistingException;
	
	boolean deleteCartByUserId(String userId) throws CartPersistingException;
	
	Optional<CartDetail> getUsercartByUserId(String userId) throws CartFetchingException;

	CartDetail updateExistingCart(CartDetail existedCart) throws CartPersistingException;
	
	CartDetail  deleteItemByCartUserId(int productId , CartDetail cart) throws CartPersistingException;

	void updateItemsInCart(List<Item> itemListToUpdate);

}

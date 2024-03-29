package com.digital.cart.dao.daoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dao.ICartDao;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;
import com.digital.cart.repository.CartRepository;

@Service
public class CartDaoImpl implements ICartDao{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartDetail createCart(CartDetail cartDetail) throws CartPersistingException {
		try {
		 return cartRepository.save(cartDetail);
		}
		catch (Exception e) {
			throw new CartPersistingException("Failed to save the cart Details..!");
		}
	}

	@Override
	public Optional<CartDetail> getUsercartByUserId(int userId) throws CartFetchingException {
		
		try {
			return cartRepository.findByUserId(userId);
			}
			catch (Exception e) {
				throw new CartFetchingException("Failed to save the cart Details..!");
			}
	}

	@Override
	public CartDetail updateExistingCart(Optional<CartDetail> existedCart) throws CartPersistingException {
		try {
			return cartRepository.saveAndFlush(existedCart.get());
			}
			catch (Exception e) {
				throw new CartPersistingException("Failed to save the cart Details..!");
			}
	}

}

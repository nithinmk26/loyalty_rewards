package com.digital.cart.dao.daoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dao.ICartDao;
import com.digital.cart.dto.ItemDto;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.entity.Item;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;
import com.digital.cart.repository.CartRepository;
import com.digital.cart.repository.ItemDetailsRepository;


@Service
public class CartDaoImpl implements ICartDao{

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemDetailsRepository itemRepository;

	private static final String FAIL_MSG = "Failed to save the cart Details..!";

	@Override
	public CartDetail createCart(CartDetail cartDetail) throws CartPersistingException {
		try {
			return cartRepository.save(cartDetail);
		}
		catch (Exception e) {
			throw new CartPersistingException(FAIL_MSG);
		}
	}

	@Override
	public Optional<CartDetail> getUsercartByUserId(int userId) throws CartFetchingException {

		try {
			return cartRepository.findByUserId(userId);
		}
		catch (Exception e) {
			throw new CartFetchingException(FAIL_MSG);
		}
	}

	@Override
	public CartDetail updateExistingCart(CartDetail existedCart) throws CartPersistingException {
		try {
			return cartRepository.saveAndFlush(existedCart);
		}
		catch (Exception e) {
			throw new CartPersistingException(FAIL_MSG);
		}

	}

	@Override
	public boolean deleteCartByUserId(int userId) throws CartPersistingException {
		Boolean value = false;
		try {
			Optional<CartDetail> cart = cartRepository.findByUserId(userId);
			if(cart.isPresent())
			{
				cartRepository.delete(cart.get());;
				value = true;
			}
		}
		catch (Exception e) {
			throw new CartPersistingException(FAIL_MSG);
		}
		return value;

	}

	@Override
	public CartDetail deleteItemByCartUserId(int itemId , CartDetail cartdetail) throws CartPersistingException {
	try{
		for (Item item : cartdetail.getItemList()) {
		if(item.getId() == itemId)
		{
			cartdetail.getItemList().remove(item);
			itemRepository.deleteById(itemId);
	}
	}}catch(Exception e)
	{
		throw new CartPersistingException(FAIL_MSG);
	}
		return cartdetail;

	}
}

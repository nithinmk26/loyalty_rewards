/**
 * 
 */
package com.digital.cart.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dao.ICartDao;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartPersistingException;
import com.digital.cart.service.ICartService;

/**
 * @author 	
 *
 */
@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private ICartDao cartDao;

	@Override
	public CartDetail addToCart(CartDetail cartDetail) throws CartPersistingException {
		CartDetail existedCart = cartDao.getUsercartByUserId(cartDetail.getUserId());
		cartDao.createCart(cartDetail);
		return null;
	}

}

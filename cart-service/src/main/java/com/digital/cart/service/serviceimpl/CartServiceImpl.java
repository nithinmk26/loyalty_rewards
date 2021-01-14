/**
 * 
 */
package com.digital.cart.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dao.ICartDao;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.CartFetchingException;
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
	public CartDetail addToCart(CartDetail cartDetail) throws CartPersistingException, CartFetchingException {
		CartDetail existedCart = cartDao.getUsercartByUserId(cartDetail.getUserId());
		return cartDao.createCart(cartDetail);
	}

	@Override
	public String deleteServiceCartDetails(int userId) throws CartPersistingException {
		Boolean value  = cartDao.deleteCartByUserId(userId);
		if(value == true) {
			return "Deleted the cart details successfully";
		}else {
			throw new CartPersistingException("No such UserId");
		}
	
	}
	

}

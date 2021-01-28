/**
 * 
 */
package com.digital.cart.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dao.ICartDao;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.exception.LoyaltyRewardsGlobalAppException;
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
	public String addToCart(CartDetail cartDetail) throws LoyaltyRewardsGlobalAppException {
		Optional<CartDetail> existedCart = cartDao.getUsercartByUserId(cartDetail.getUserId());
		if(!existedCart.isPresent()) {
		cartDetail = calculationOfDeliveryAndCartValue(cartDetail);
		cartDao.createCart(cartDetail);
		return "Cart Details Successfully Saved in DB...!";
		}
		else {
			double cartValue = cartDetail.getItemList().stream().mapToDouble(
					item->
						 item.getProductPrice() * item.getQuantity()
								).sum();
			existedCart.get().getItemList().addAll(cartDetail.getItemList());
			existedCart.get().setNumOfItemsInCart(existedCart.get().getItemList().size());
			existedCart.get().setDeliveryCharges(cartDetail.getNumOfItemsInCart() * 10.0);
			existedCart.get().setDeliveryCharges(existedCart.get().getDeliveryCharges() + cartValue);			
			cartDao.updateExistingCart(existedCart);
			return "Cart Details SuccessFully Updated in DB...!";
		}
		
	}
	
	public CartDetail calculationOfDeliveryAndCartValue(CartDetail cartDetail) {
		cartDetail.setNumOfItemsInCart(cartDetail.getItemList().size());
		cartDetail.setDeliveryCharges(cartDetail.getNumOfItemsInCart() * 10.0);
		double cartValue = cartDetail.getItemList().stream().mapToDouble(
				item->
					 item.getProductPrice() * item.getQuantity()
							).sum();
		cartDetail.setCartValue(cartValue);
		return cartDetail;
	}

}

/**
 * 
 */
package com.digital.cart.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dao.ICartDao;
import com.digital.cart.entity.CartDetail;
import com.digital.cart.entity.Item;
import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;
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
			existedCart = updateCartItemsIntoExistingCart(cartDetail,existedCart);	
			CartDetail cartdetailobj = calculationOfDeliveryAndCartValue(existedCart.get());
			cartDao.updateExistingCart(cartdetailobj);
			return "Cart Details SuccessFully Updated in DB...!";
		}

	} 
	
	public Optional<CartDetail> updateCartItemsIntoExistingCart(CartDetail newCartItems, Optional<CartDetail> existingCarItems) {
		for (Item itemInNewCart : newCartItems.getItemList()) {
			boolean isExists = false;
			for (Item itemInExistingCart : existingCarItems.get().getItemList()) {
				if(itemInNewCart.getProductId() == itemInExistingCart.getProductId()) {
					itemInExistingCart.setQuantity(itemInExistingCart.getQuantity() + itemInNewCart.getQuantity());
					isExists = true;
				}
			}
			if(!isExists)
				existingCarItems.get().getItemList().add(itemInNewCart);
		}
		return existingCarItems;
		
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

	@Override
	public String deleteServiceCartDetails(int userId) throws CartPersistingException {
		if(cartDao.deleteCartByUserId(userId)) 
			return "Deleted the cart details successfully";
		else
			throw new CartPersistingException("No such UserId");

	}

	@Override
	public String deleteItemInCartDetails(int userId, int itemId) throws CartPersistingException, CartFetchingException {
		Optional<CartDetail> cart = cartDao.getUsercartByUserId(userId);
		String msg = "";
		if(cart.isPresent())
		{
			for (Item item : cart.get().getItemList()) {
				if(item.getId() == itemId)
				{
					if(item.getQuantity() == 1)
					{
						cartDao.deleteItemByCartUserId(itemId ,cart);
					}
					else {
						item.setQuantity(item.getQuantity()-1);
						CartDetail cartdetailobj = calculationOfDeliveryAndCartValue(cart.get());
						cartDao.updateExistingCart(cartdetailobj);
					}
				}
			}

		}
		else {
			throw new CartPersistingException("No Such userID / Item ID");
		}

		return "Successfully deleted items from cart";

	}

	@Override
	public CartDetail getCartByUserId(int userId) throws CartFetchingException {
		Optional<CartDetail> cart = cartDao.getUsercartByUserId(userId);
		cart.orElseThrow(()->new CartFetchingException("Unable to find the cart for specified user ID...!"));
		return cart.get();
	}
}

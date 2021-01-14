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

	//	public CartDetail addToCart(CartDetail cartDetail) throws CartPersistingException, CartFetchingException {
	//		CartDetail existedCart = cartDao.getUsercartByUserId(cartDetail.getUserId());
	//		return cartDao.createCart(cartDetail);

	public String addToCart(CartDetail cartDetail) throws LoyaltyRewardsGlobalAppException {
		Optional<CartDetail> existedCart = cartDao.getUsercartByUserId(cartDetail.getUserId());
		if(!existedCart.isPresent()) {
			cartDetail = calculationOfDeliveryAndCartValue(cartDetail);
			cartDao.createCart(cartDetail);
			return "Cart Details Successfully Saved in DB...!";
		}
		else {
			//			double cartValue = cartDetail.getItemList().stream().mapToDouble(
			//					item->
			//						 item.getProductPrice() * item.getQuantity()
			//								).sum();
			//			
			//			
			//			existedCart.get().setDeliveryCharges(cartDetail.getNumOfItemsInCart() * 10.0);
			//			existedCart.get().setDeliveryCharges(existedCart.get().getDeliveryCharges() + cartValue);			
			existedCart.get().getItemList().addAll(cartDetail.getItemList());
			existedCart.get().setNumOfItemsInCart(existedCart.get().getItemList().size());
			CartDetail cartdetailobj = calculationOfDeliveryAndCartValue(existedCart.get());
			cartDao.updateExistingCart(cartdetailobj);
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

	@Override
	public String deleteServiceCartDetails(int userId) throws CartPersistingException {
		Boolean value  = cartDao.deleteCartByUserId(userId);
		if(value == true) {
			return "Deleted the cart details successfully";
		}else {
			throw new CartPersistingException("No such UserId");
		}

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
}

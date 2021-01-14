/**
 * 
 */
package com.digital.cart.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.repository.CartRepository;
import com.digital.cart.service.ICartService;

/**
 * @author Loyalty_Digiteam
 *
 */
@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private CartRepository cartRepository;

}

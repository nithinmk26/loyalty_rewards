package com.digital.cart.dao.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.cart.dao.ICartDao;
import com.digital.cart.repository.CartRepository;

@Service
public class CartDaoImpl implements ICartDao{
	
	@Autowired
	private CartRepository cartRepository;

}

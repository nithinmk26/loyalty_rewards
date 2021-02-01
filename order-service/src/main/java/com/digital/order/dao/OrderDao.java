package com.digital.order.dao;

import com.digital.order.dto.CartResponseDto;
import com.digital.order.entity.Order;

public interface OrderDao {

	public Order addToOrder(Order order);
	
	
}

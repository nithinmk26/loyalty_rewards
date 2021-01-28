package com.digital.order.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.order.dao.OrderDao;
import com.digital.order.entity.Order;
import com.digital.order.repository.OrderRepository;

@Service
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order addToOrder(Order order) {
		return orderRepository.save(order);
	}

}

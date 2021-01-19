package com.digital.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.order.dao.OrderDao;
import com.digital.order.dto.CartResponseDto;
import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.entity.Order;
import com.digital.order.entity.Order.paymentmode;
import com.digital.order.service.IOrderService;
import com.digital.order.utilitymethods.UtilityMethods;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public String addToOrder(Order orderDetail) {
		orderDetail.setPaymentMode(paymentmode.CASH);
		  Order order= orderDao.addToOrder(orderDetail);
	  return "added successfully";
	}
	
	public value checkPayment(PaymentDto paymentDto)
	{
		boolean value = false ;
		int numberOfDigits = String.valueOf(paymentDto.getCardNumber()).length();
		System.out.println(numberOfDigits);
		int cvvnum = String.valueOf(paymentDto.getCvv()).length();
		if(numberOfDigits == 16 && cvvnum == 3)
		{
			value = true;
		}
			
			return value ;
		
	}

	@Override
	public boolean checkPayment(UpiPaymentDto upiPayment) {
		boolean value = false ;
		int numberOfDigits = String.valueOf(upiPayment.getPhonenumber()).length();
		if(numberOfDigits == 10)
		{
			value = true;
		}
			
			return value ;
	}

}

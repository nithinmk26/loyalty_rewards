package com.digital.order.service;

import com.digital.order.dto.CartResponseDto;
import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.entity.Order;

public interface IOrderService {
	
	public String addToOrder(Order orderdetail);
	
	public boolean checkPayment(UpiPaymentDto upiPayment);
	
	public boolean checkPayment(PaymentDto paymentDto);

}

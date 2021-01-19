package com.digital.order.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import com.digital.order.dto.CartResponseDto;
import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.entity.Order;
import com.digital.order.service.IOrderService;
import com.digital.order.utilitymethods.UtilityMethods;

@Service
public class OrderFacade {
	
	@Autowired
	private IOrderService orderService;
	
	public String addToOrder(CartResponseDto cartDto)
	{
		Order orderdetail = UtilityMethods.convertCartDtotoEntity(cartDto);
		return orderService.addToOrder(orderdetail);
	}
	
	public boolean checkPayment(PaymentDto paymentDto)
	{
		return orderService.checkPayment(paymentDto);
	}
	
	public boolean checkPayment(UpiPaymentDto upiPayment)
	{
		return orderService.checkPayment(upiPayment);
	}

}

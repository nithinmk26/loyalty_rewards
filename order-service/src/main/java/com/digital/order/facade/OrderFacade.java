package com.digital.order.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import com.digital.order.dto.CartResponseDto;
import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.entity.Order;
import com.digital.order.entity.Order.paymentmode;
import com.digital.order.exception.LoyaltyRewardsGlobalAppException;
import com.digital.order.service.IOrderService;
import com.digital.order.utilitymethods.UtilityMethods;

@Service
public class OrderFacade {
	
	@Autowired
	private IOrderService orderService;
	
	public String orderByCash(String userId) throws LoyaltyRewardsGlobalAppException
	{
		return orderService.orderByCash(userId);
	}
	
	public String orderByCard(PaymentDto paymentDto , String userId) throws LoyaltyRewardsGlobalAppException
	{
		return orderService.orderByCard( paymentDto,userId);
	}
	
	public String orderByUpi(UpiPaymentDto upiPayment , String userId) throws LoyaltyRewardsGlobalAppException
	{
		return orderService.orderByUpi(upiPayment , userId);
	}

}

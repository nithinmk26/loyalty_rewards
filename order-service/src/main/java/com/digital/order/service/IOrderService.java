package com.digital.order.service;

import com.digital.order.dto.CartResponseDto;
import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.entity.Order;
import com.digital.order.exception.LoyaltyRewardsGlobalAppException;

public interface IOrderService {
	
	public String orderByCash(String userId) throws LoyaltyRewardsGlobalAppException ;
	
	 public String orderByCard(PaymentDto paymentDto , String userId) throws LoyaltyRewardsGlobalAppException ;
	
	 public String orderByUpi(UpiPaymentDto upiPaymentDto , String userId) throws LoyaltyRewardsGlobalAppException ;

}

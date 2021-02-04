package com.digital.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.digital.order.dao.OrderDao;
import com.digital.order.dto.CartResponseDto;
import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.dto.VoucherUserDto;
import com.digital.order.entity.Order;
import com.digital.order.entity.Order.paymentmode;
import com.digital.order.exception.LoyaltyRewardsGlobalAppException;
import com.digital.order.exception.OrderPaymentException;
import com.digital.order.exception.OrderPersistanceException;
import com.digital.order.proxy.CartProxy;
import com.digital.order.proxy.LoyaltyProxy;
import com.digital.order.service.IOrderService;
import com.digital.order.utilitymethods.UtilityMethods;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CartProxy cartProxy;
	
	@Autowired
	private LoyaltyProxy loyaltyProxy;

	@Value("${loyalty.utilization.discount}")
	private int loyaltyRewardsUtilizationDiscounts;

	@Override
	public String orderByCash(String userId , String voucherCode) throws OrderPersistanceException   {
		try{
			CartResponseDto cartResponsedto = cartProxy.getCartByUserId(userId).getBody();
		int voucherDiscountPercentage = checkVoucherValidityAndFetchVoucher(voucherCode, userId);
			//get voucher discount and apply to order price 
		VoucherUserDto voucherUserDto = new VoucherUserDto();
		voucherUserDto.setUserId(userId);
		voucherUserDto.setVoucherCode(voucherCode);
		double availableLoyaltypoints = fetchUserLoyaltyPoints(userId);
		Order orderDetail = UtilityMethods.convertCartDtotoEntity(cartResponsedto);
		orderDetail.setTotalPrice(orderDetail.getTotalPrice()-((voucherDiscountPercentage*orderDetail.getTotalPrice())/100));
		double loyaltyUtilizablePoints = (loyaltyRewardsUtilizationDiscounts*orderDetail.getTotalPrice())/100;
		if(availableLoyaltypoints < loyaltyUtilizablePoints)
		{
		orderDetail.setTotalPrice(orderDetail.getTotalPrice() - availableLoyaltypoints);
		voucherUserDto.setUtilizedLoyaltyPoints(availableLoyaltypoints);
		}
		else {
		orderDetail.setTotalPrice(orderDetail.getTotalPrice() - loyaltyUtilizablePoints);
		voucherUserDto.setUtilizedLoyaltyPoints(loyaltyUtilizablePoints);
		}
		orderDetail.setPaymentMode(paymentmode.CASH);
		voucherUserDto.setOrderAmount(orderDetail.getTotalPrice());
		  Order order= orderDao.addToOrder(orderDetail);
		 //send the voucherUserDto to the kafka 
		}catch(Exception e)
		{
			throw new OrderPersistanceException("Couldnt order the product !! Try again ...");
		}
	  return "added successfully";
	}
	
	public String orderByCard(PaymentDto paymentDto , String userId , String voucherCode) throws OrderPersistanceException 
	{
		String value = "" ;
		try{
			int numberOfDigits = String.valueOf(paymentDto.getCardNumber()).length();
		System.out.println(numberOfDigits);
		int cvvnum = String.valueOf(paymentDto.getCvv()).length();
		if(numberOfDigits == 16 && cvvnum == 3)
		{
			CartResponseDto cartResponsedto = cartProxy.getCartByUserId(userId).getBody();
			Order orderDetail = UtilityMethods.convertCartDtotoEntity(cartResponsedto);
			
			orderDetail.setPaymentMode(paymentmode.CARD);
			 Order order= orderDao.addToOrder(orderDetail);
				value = "Order placed succesfully";
		}
		else {
			throw new OrderPaymentException("Incorrect card Details ....Check and try again!!");
		}
		return value;
	}catch(Exception e)
		{
		throw new OrderPersistanceException("Order Couldnt be placed , Try again !!!");
		}
		
	}

	@Override
	public String orderByUpi(UpiPaymentDto upiPaymentDto , String userId , String voucherCode) throws OrderPersistanceException   {
		String value = "" ;
		try{int numberOfDigits = String.valueOf(upiPaymentDto.getPhonenumber()).length();
		if(numberOfDigits == 10)
		{
			CartResponseDto cartResponsedto = cartProxy.getCartByUserId(userId).getBody();
			Order orderDetail = UtilityMethods.convertCartDtotoEntity(cartResponsedto);
			orderDetail.setPaymentMode(paymentmode.UPI);
			 orderDetail = orderDao.addToOrder(orderDetail);
			value = "Order placed succesfully";
		}else {
			throw new OrderPaymentException("Incorrect UPI Details ....Check and try again!!");
		}
		return value;
	}catch(Exception e)
		{
		throw new OrderPersistanceException("Order Couldnt be placed , Try again !!!");
		}
	}
	
	public double fetchUserLoyaltyPoints(String userId)
	{
		return  loyaltyProxy.fetchUserLoyaltyPoints(userId).getBody();
	}
	
	public  int checkVoucherValidityAndFetchVoucher(String voucherCode , String userId) throws LoyaltyRewardsGlobalAppException
	{
		return loyaltyProxy.validateVocherCode(userId , voucherCode).getBody();
	}
	
	

	
	
	
}

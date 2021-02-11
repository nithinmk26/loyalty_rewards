package com.digital.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.exception.LoyaltyRewardsGlobalAppException;
import com.digital.order.facade.OrderFacade;

@RestController
@RequestMapping("/order")
public class OrderUserController {
	
	@Autowired
	private OrderFacade orderFacade;
	
	@PostMapping("/paycash/{userId}")
	public ResponseEntity<String> orderByCash(@PathVariable String userId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(orderFacade.orderByCash(userId, null),HttpStatus.OK);
	}
	
	
	@PostMapping("/paycard/{userId}")
	public ResponseEntity<String> orderByCard(@RequestBody PaymentDto paymentDto,@PathVariable String userId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(orderFacade.orderByCard(paymentDto, userId, null),HttpStatus.OK);
	}
	
	@PostMapping("/payupi/{userId}")
	public ResponseEntity<String> orderByUpi(@RequestBody UpiPaymentDto upiPaymentDto,@PathVariable String userId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(orderFacade.orderByUpi(upiPaymentDto, userId, null),HttpStatus.OK);
	}
	

}

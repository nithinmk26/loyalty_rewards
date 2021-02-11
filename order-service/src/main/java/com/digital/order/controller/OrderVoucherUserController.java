package com.digital.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.order.dto.PaymentDto;
import com.digital.order.dto.UpiPaymentDto;
import com.digital.order.exception.LoyaltyRewardsGlobalAppException;
import com.digital.order.facade.OrderFacade;

@RequestMapping("/order")
@RestController
public class OrderVoucherUserController {
	
	@Autowired
    private OrderFacade orderFacade;
	
	@PostMapping("/payCash​​​​​​​")
	public ResponseEntity<String> orderByCash(@RequestParam String userId, @RequestParam String voucherCode) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(orderFacade.orderByCash(userId, voucherCode),HttpStatus.OK);
	}
	
	@PostMapping("/payCard/{​​​​​​​userId}/​​​​​​​{​​​​​​​voucherCode}​​​​​​​​​​​​​​")
	public ResponseEntity<String> checkpayment(@RequestBody PaymentDto paymentDto , @PathVariable String userId , @PathVariable String voucherCode) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(orderFacade.orderByCard(paymentDto , userId ,voucherCode),HttpStatus.OK);
	}
	
	@PostMapping("/payUpi/{​​​​​​​userId}/​​​​​​​{​​​​​​​voucherCode}​​​​​​​​​​​​​​")
	public ResponseEntity<String> checkpayment(@RequestBody UpiPaymentDto upiPayment , @PathVariable String userId , @PathVariable String voucherCode) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(orderFacade.orderByUpi(upiPayment , userId ,voucherCode),HttpStatus.OK);
	}

}

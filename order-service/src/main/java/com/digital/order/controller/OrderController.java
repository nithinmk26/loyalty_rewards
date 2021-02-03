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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderFacade orderFacade;
	
	@PostMapping("/{userId}/{voucherCode}")
	@ApiOperation(value = "ordering prodcuts by cash")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added items to the cart"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> OrderByCash(@PathVariable String userId , @PathVariable String voucherCode) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(orderFacade.orderByCash(userId),HttpStatus.OK);
	}
	
	@PostMapping("/{userId}/{voucherCode}")
	@ApiOperation(value = "ordering prodcuts by cash")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added items to the cart"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> checkpayment(@RequestBody PaymentDto paymentDto , @PathVariable String userId , @PathVariable String voucherCode) throws LoyaltyRewardsGlobalAppException {
		return new ResponseEntity<>(orderFacade.orderByCard(paymentDto , userId),HttpStatus.OK);
	}
	
	@PostMapping("/{userId}/{voucherCode}")
	@ApiOperation(value = "ordering prodcuts by cash")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added items to the cart"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> checkpayment(@RequestBody UpiPaymentDto upiPayment , @PathVariable String userId , @PathVariable String voucherCode) throws LoyaltyRewardsGlobalAppException {
		return new ResponseEntity<>(orderFacade.orderByUpi(upiPayment , userId), HttpStatus.OK);
	}
	
	
	
	

}

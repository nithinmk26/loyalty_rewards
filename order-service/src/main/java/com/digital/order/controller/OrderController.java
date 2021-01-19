package com.digital.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.order.dto.CartResponseDto;
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
	
	@PostMapping("/add")
	@ApiOperation(value = "ordering items from The user Cart....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added items to the cart"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> addToCart(@RequestBody CartResponseDto cartDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(orderFacade.addToOrder(cartDto),HttpStatus.OK);
	}
	
	@PostMapping("/pay")
	public boolean checkpayment(@RequestBody PaymentDto paymentDto) {
		System.out.println(paymentDto.getCardName());
		return orderFacade.checkPayment(paymentDto);
	}
	
	@PostMapping("/pay")
	public boolean checkpayment(@RequestBody UpiPaymentDto upiPayment) {
		return orderFacade.checkPayment(upiPayment);
	}
	
	 

}

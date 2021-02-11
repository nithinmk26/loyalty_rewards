package com.digital.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digital.order.dto.CartResponseDto;
import com.digital.order.exception.LoyaltyRewardsGlobalAppException;

@FeignClient(value = "loyalty-cart-service")
public interface CartProxy {

	@GetMapping("cart/{userId}")
	public ResponseEntity<CartResponseDto> getCartByUserId(@PathVariable String userId) throws LoyaltyRewardsGlobalAppException;
	
	@DeleteMapping("cart/{userId}")
	public ResponseEntity<String> deleteCartDetails(@PathVariable String userId) throws LoyaltyRewardsGlobalAppException;
}

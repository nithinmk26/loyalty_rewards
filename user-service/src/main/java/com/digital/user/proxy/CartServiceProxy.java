package com.digital.user.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digital.user.dto.request.CartDto;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;

@FeignClient(value = "loyalty-cart-service")
public interface CartServiceProxy {
	
	@PostMapping("/cart/")
	public ResponseEntity<String> addToCart(@RequestBody CartDto cartDto) throws LoyaltyRewardsGlobalAppException;


}

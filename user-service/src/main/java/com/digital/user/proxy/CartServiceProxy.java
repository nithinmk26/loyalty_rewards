package com.digital.user.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digital.user.dto.request.CartDto;
import com.digital.user.dto.request.CartResponseDto;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;

@FeignClient(value = "loyalty-cart-service")
public interface CartServiceProxy {
	
	@PostMapping("/cart/")
	public ResponseEntity<String> addToCart(@RequestBody CartDto cartDto) throws LoyaltyRewardsGlobalAppException;

	@DeleteMapping("/cart/{userId}")
	public ResponseEntity<String> deleteCartDetails(@PathVariable String userId) throws LoyaltyRewardsGlobalAppException;
	
	@DeleteMapping("/cart/{userId}/product/{productId}")
	public ResponseEntity<String> deleteItemInCartDetails(@PathVariable String userId , @PathVariable int productId) throws LoyaltyRewardsGlobalAppException;
	
	@GetMapping("/cart/{userId}")
	public ResponseEntity<CartResponseDto> getCartByUserId(@PathVariable String userId) throws LoyaltyRewardsGlobalAppException;
	
}

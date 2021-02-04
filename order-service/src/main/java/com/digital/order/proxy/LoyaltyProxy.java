package com.digital.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "loyalty-service")
public interface LoyaltyProxy {
	
	@GetMapping("/{userId}")
	public ResponseEntity<Double> fetchUserLoyaltyPoints(@PathVariable String userId);
	
	@GetMapping("/{userId}/{vocherCode}")
	public ResponseEntity<Boolean> validateVocherCode(@PathVariable String userId, @PathVariable String vocherCode);

}

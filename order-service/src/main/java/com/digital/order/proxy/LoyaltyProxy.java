package com.digital.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "loyalty-service")
public interface LoyaltyProxy {
	
	@GetMapping("/{userId}")
    public double fetchUserLoyaltyPoints(String userId);

}

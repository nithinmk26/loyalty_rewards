package com.digital.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "loyalty-service")
public interface LoyaltyProxy {
	
	@GetMapping("/{userId}")
    public double fetchUserLoyaltyPoints(@PathVariable String userId);
	
	@GetMapping("/{userId}/{vouchercode}")
	public boolean checkVoucherValidity(@PathVariable String userId , @PathVariable String voucherCode);
	

}

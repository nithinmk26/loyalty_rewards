package com.digital.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.digital.order.exception.LoyaltyRewardsGlobalAppException;

@FeignClient(value = "loyalty-product-service")
public interface ProductProxy {
	
	@PutMapping("product/{productId}/{quantity}")
	public void updateProductByIdAndQuantity(@PathVariable int productId,@PathVariable int quantity) throws LoyaltyRewardsGlobalAppException;

}

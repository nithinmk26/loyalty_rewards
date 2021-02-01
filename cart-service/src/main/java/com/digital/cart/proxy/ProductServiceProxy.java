package com.digital.cart.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.digital.cart.dto.ItemDto;
import com.digital.cart.exception.LoyaltyRewardsGlobalAppException;

@FeignClient(value = "loyalty-product-service")
public interface ProductServiceProxy {
	
	
	@PostMapping("product/avilability")
	public ResponseEntity<Boolean> getAllProductAvailability(@RequestBody List<ItemDto> productItemModel) throws LoyaltyRewardsGlobalAppException;


}

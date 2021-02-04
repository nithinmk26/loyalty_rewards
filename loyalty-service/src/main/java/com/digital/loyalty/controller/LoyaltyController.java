package com.digital.loyalty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.loyalty.dto.request.OrderDetails;
import com.digital.loyalty.dto.request.UserProfileDto;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.exception.LoyaltyRewardsGlobalAppException;
import com.digital.loyalty.service.ILoyaltyService;

@RestController
@RequestMapping("/loyalty")
public class LoyaltyController {
	
	@Autowired
	private ILoyaltyService loyaltyService;
	
	@PostMapping("/memCreation")
	public String loyaltyMemberCreation(@RequestBody UserProfileDto userProfileDto) throws Exception {
		return loyaltyService.loyaltyMemberCreation(userProfileDto);
	}
	
	@PostMapping("/bdayVocher")
	public String generateBdayVocher() throws Exception{
		return loyaltyService.generateBdayVocher();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Double> fetchUserLoyaltyPoints(@PathVariable String userId) {
		return new ResponseEntity<>(loyaltyService.fetchUserLoyaltyPoints(userId),HttpStatus.OK);
		
	}
	
	@GetMapping("/{userId}/{vocherCode}")
	public ResponseEntity<Integer> validateVocherCode(@PathVariable String userId, @PathVariable String vocherCode) throws LoyaltyRewardsGlobalAppException {
		return new ResponseEntity<>(loyaltyService.validateVocherCodeAndFetchDiscountValue(userId,vocherCode),HttpStatus.OK);
	}

	@PostMapping("/")
	public void loyaltyRewards(@RequestBody OrderDetails order) {
		loyaltyService.loyaltyRewards(order);
	}
	
	@PostMapping("/vocher")
	public ResponseEntity<String> addFestiveVocher(@RequestBody LoyaltyVoucher loyaltyVoucher) {
		return new ResponseEntity<>(loyaltyService.addFestiveVoucher(loyaltyVoucher),HttpStatus.CREATED);
	}
	
	
}

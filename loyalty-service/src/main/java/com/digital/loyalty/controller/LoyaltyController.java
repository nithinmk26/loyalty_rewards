package com.digital.loyalty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.loyalty.dto.request.UserProfileDto;
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
	public ResponseEntity<Double> fetchUserLoyaltyPoints(String userId) {
		return new ResponseEntity<>(loyaltyService.fetchUserLoyaltyPoints(userId),HttpStatus.OK);
		
	}


	
	
}

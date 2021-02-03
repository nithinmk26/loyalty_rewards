package com.digital.loyalty.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	
}

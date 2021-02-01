package com.digital.loyalty.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.loyalty.dto.request.UserProfileDto;

@RestController
@RequestMapping("/loyalty")
public class LoyaltyController {
	
	@PostMapping("/memCreation")
	public void loyaltyMemberCreation(@RequestBody UserProfileDto userProfileDto) {
		
	}

	
	
}

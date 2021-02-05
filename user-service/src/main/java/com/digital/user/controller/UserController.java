package com.digital.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.user.dto.request.UserProfileUpdateDto;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;
import com.digital.user.facade.UserFacade;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserFacade userFacade;
	
//	@GetMapping("/")
//	public void getLoggedInMember(@AuthenticationPrincipal OAuth2User oAuth2User) {
//		System.err.println(oAuth2User);
//	}
	
	@PostMapping("/")
	@ApiOperation(value = "Update user Profile....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated Profile"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> updateProfile(@AuthenticationPrincipal OAuth2User oAuth2User,@RequestBody UserProfileUpdateDto userProfileUpdateDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(userFacade.updateProfile(oAuth2User,userProfileUpdateDto),HttpStatus.OK);
	}
	
	
	@GetMapping("/") 
	@ApiOperation(value = "Varify user Profile....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added items to the cart"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> varifyProfile(@AuthenticationPrincipal OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(userFacade.varifyProfile(oAuth2User),HttpStatus.OK);
	}

}

package com.digital.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.user.dto.request.ItemDto;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;
import com.digital.user.facade.UserFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Cart API", description = "List of API's Available related to cart.", tags = { "Cart API's" })
@RestController
@RequestMapping("/user")
public class CartControllerProxy {
	
	
	@Autowired
	private UserFacade userFacade;
	
	@PostMapping("/cart")
	@ApiOperation(value = "Add to cart ....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added items to the cart"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> addToCart(@AuthenticationPrincipal OAuth2User oAuth2User,@RequestBody List<ItemDto> itemList) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(userFacade.addToCart(oAuth2User,itemList),HttpStatus.OK);
	}

}

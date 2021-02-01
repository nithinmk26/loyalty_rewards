package com.digital.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.user.dto.request.CartResponseDto;
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
	
	@PostMapping("/")
	@ApiOperation(value = "Add to cart ....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added items to the cart"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> addToCart(@AuthenticationPrincipal OAuth2User oAuth2User,@RequestBody List<ItemDto> itemList) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(userFacade.addToCart(oAuth2User,itemList),HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	@ApiOperation(value = "Deleting The user Cart....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted cartdetails "),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> deleteCartDetails(@AuthenticationPrincipal OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(userFacade.deleteCartDetails(oAuth2User),HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	@ApiOperation(value = "Deleting The user Cart Item....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted cartdetails "),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> deleteItemInCartDetails(@AuthenticationPrincipal OAuth2User oAuth2User, @PathVariable int productId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(userFacade.deleteItemInCartDetails(oAuth2User , productId),HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	@ApiOperation(value = "Fetch The user Cart based on ID....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched cart details "),
			@ApiResponse(code = 404,message = "Cart Found for specified User ID .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<CartResponseDto> getCartByUserId(@AuthenticationPrincipal OAuth2User oAuth2User) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(userFacade.getCartByUserId(oAuth2User),HttpStatus.OK);
	}

}

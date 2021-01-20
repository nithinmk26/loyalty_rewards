package com.digital.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.cart.dto.CartDto;
import com.digital.cart.dto.CartResponseDto;
import com.digital.cart.exception.LoyaltyRewardsGlobalAppException;
import com.digital.cart.facade.CartFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Loyalty_Digiteam
 *
 */
@RestController
@Api(value = "Cart Service", description = "List of API's Available for Cart CRUD.", tags = { "Cart Service" })
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartFacade cartFacade; 
	
	
	@PostMapping("/")
	@ApiOperation(value = "Adding items Into The user Cart....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added items to the cart"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> addToCart(@RequestBody CartDto cartDto) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(cartFacade.addToCart(cartDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	@ApiOperation(value = "Deleting The user Cart....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted cartdetails "),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> deleteCartDetails(@PathVariable String userId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(cartFacade.deleteCartDetails(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}/product/{productId}")
	@ApiOperation(value = "Deleting The user Cart....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted cartdetails "),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> deleteItemInCartDetails(@PathVariable String userId , @PathVariable int productId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(cartFacade.deleteItemInCartDetails(userId , productId),HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	@ApiOperation(value = "Fetch The user Cart based on ID....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched cart details "),
			@ApiResponse(code = 404,message = "Cart Found for specified User ID .."),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<CartResponseDto> getCartByUserId(@PathVariable String userId) throws LoyaltyRewardsGlobalAppException{
		return new ResponseEntity<>(cartFacade.getCartByUserId(userId),HttpStatus.OK);
	}
	
	
}


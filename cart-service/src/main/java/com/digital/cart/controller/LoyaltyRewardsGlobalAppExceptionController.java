
package com.digital.cart.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digital.cart.exception.CartFetchingException;
import com.digital.cart.exception.CartPersistingException;
import com.digital.cart.exception.LoyaltyRewardsGlobalAppException;
import com.digital.cart.exception.ProductProxyException;

/**
 * @author 
 *
 */
@RestControllerAdvice(assignableTypes = CartController.class)
public class LoyaltyRewardsGlobalAppExceptionController {
	
	private String err = "ERROR";
	private String msg = "Message";
	
	@ExceptionHandler(CartPersistingException.class)
	public ResponseEntity<String> productServicePersistingExceptionHandler(Throwable t, Exception e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CartFetchingException.class)
	public ResponseEntity<String> productServiceFetchingExceptionclass(Throwable t, Exception e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(LoyaltyRewardsGlobalAppException.class)
	public ResponseEntity<String> loyaltyRewardsGlobalAppExceptionHandler(Throwable t, Exception e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductProxyException.class)
	public ResponseEntity<String> loyaltyRewardsGlobalAppProxyExceptionHandler(Throwable t, Exception e){
		return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}

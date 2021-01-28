package com.digital.loyalty.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digital.loyalty.exception.LoyaltyRewardsGlobalAppException;

/**
 * @author 
 *
 */
@RestControllerAdvice(assignableTypes = LoyaltyController.class)
public class LoyaltyRewardsGlobalAppExceptionController {
	
	private String err = "ERROR";
	private String msg = "Message";

	
	@ExceptionHandler(LoyaltyRewardsGlobalAppException.class)
	public ResponseEntity<Map<String, Object>> loyaltyRewardsGlobalAppExceptionHandler(Throwable t, Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put(err, true);
		response.put(msg, e.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	
}
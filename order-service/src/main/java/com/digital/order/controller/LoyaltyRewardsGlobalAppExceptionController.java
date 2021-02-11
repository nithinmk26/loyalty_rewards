package com.digital.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(assignableTypes = OrderUserController.class)
public class LoyaltyRewardsGlobalAppExceptionController {
	
	private String err = "ERROR";
	private String msg = "Message";
	

	public ResponseEntity<Map<String, Object>> orderServicePersistingExceptionHandler(Throwable t, Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put(err, true);
		response.put(msg, e.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

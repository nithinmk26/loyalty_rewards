/**
 * 
 */
package com.digital.productservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digital.productservice.controller.proxy.ProductProxyController;
import com.digital.productservice.exception.LoyaltyRewardsGlobalAppException;
import com.digital.productservice.exception.ProductServiceFetchingException;
import com.digital.productservice.exception.ProductServicePersistingException;
import com.digital.productservice.exception.ProductUnavailabilityException;

/**
 * @author 
 *
 */
@RestControllerAdvice(assignableTypes = {ProductController.class,ProductProxyController.class})
public class LoyaltyRewardsGlobalAppExceptionController {

	private String err = "ERROR";
	private String msg = "Message";

	@ExceptionHandler(ProductServicePersistingException.class)
	public ResponseEntity<Map<String, Object>> productServicePersistingExceptionHandler(Throwable t, Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put(err, true);
		response.put(msg, e.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ProductServiceFetchingException.class)
	public ResponseEntity<Map<String, Object>> productServiceFetchingExceptionclass(Throwable t, Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put(err, true);
		response.put(msg, e.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoyaltyRewardsGlobalAppException.class)
	public ResponseEntity<Map<String, Object>> loyaltyRewardsGlobalAppExceptionHandler(Throwable t, Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put(err, true);
		response.put(msg, e.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductUnavailabilityException.class)
	public ResponseEntity<String> loyaltyRewardsGlobalAppProxyExceptionHandler(Throwable t, Exception e){
		return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
	}
	

}

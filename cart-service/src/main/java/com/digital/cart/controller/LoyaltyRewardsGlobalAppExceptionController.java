/**
 * 
 */
package com.digital.cart.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 
 *
 */
@RestControllerAdvice(assignableTypes = CartController.class)
public class LoyaltyRewardsGlobalAppExceptionController {
	
	private String err = "ERROR";
	private String msg = "Message";
	
//	@ExceptionHandler(ProductServicePersistingException.class)
//	public ResponseEntity<Map<String, Object>> productServicePersistingExceptionHandler(Throwable t, Exception e){
//		Map<String, Object> response = new HashMap<>();
//		response.put(err, true);
//		response.put(msg, e.getLocalizedMessage());
//		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	@ExceptionHandler(ProductServiceFetchingException.class)
//	public ResponseEntity<Map<String, Object>> productServiceFetchingExceptionclass(Throwable t, Exception e){
//		Map<String, Object> response = new HashMap<>();
//		response.put(err, true);
//		response.put(msg, e.getLocalizedMessage());
//		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//	}
//	
//	@ExceptionHandler(LoyaltyRewardsGlobalAppException.class)
//	public ResponseEntity<Map<String, Object>> loyaltyRewardsGlobalAppExceptionHandler(Throwable t, Exception e){
//		Map<String, Object> response = new HashMap<>();
//		response.put(err, true);
//		response.put(msg, e.getLocalizedMessage());
//		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//	}
	
	
}

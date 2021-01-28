/**
 * 
 */
package com.digital.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digital.user.exception.CartServiceProxyAppException;
import com.digital.user.exception.LoyaltyRewardsGlobalAppException;
import com.digital.user.exception.ProfileUpdatedException;
import com.digital.user.exception.UserFetchingException;
import com.digital.user.exception.UserPersistingException;

/**
 * @author 
 *
 */
@RestControllerAdvice(assignableTypes = {UserController.class,CartControllerProxy.class})
public class LoyaltyRewardsGlobalAppExceptionController {
	
	private String err = "ERROR";
	private String msg = "Message";
	
	@ExceptionHandler(UserPersistingException.class)
	public ResponseEntity<Map<String, Object>> productServicePersistingExceptionHandler(Throwable t, Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put(err, true);
		response.put(msg, e.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserFetchingException.class)
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
	
	@ExceptionHandler(ProfileUpdatedException.class)
	public ResponseEntity<Map<String, Object>> ProfileUpdatedExceptionHandler(Throwable t, Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put(err, true);
		response.put(msg, e.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CartServiceProxyAppException.class)
	public ResponseEntity<Map<String, Object>> CartProxyExceptionHandler(Throwable t, Exception e){
		Map<String, Object> response = new HashMap<>();
		response.put(err, true);
		response.put(msg, e.getLocalizedMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	
}

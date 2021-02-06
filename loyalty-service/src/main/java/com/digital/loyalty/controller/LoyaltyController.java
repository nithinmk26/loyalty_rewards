package com.digital.loyalty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.loyalty.dto.request.OrderDetails;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.exception.LoyaltyRewardsGlobalAppException;
import com.digital.loyalty.service.ILoyaltyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/loyalty")
@Api(value = "Loyalty API's", description = "List of API's Available related to Loyalty Service.", tags = { "Loyalty API's" })
public class LoyaltyController {
	
	@Autowired
	private ILoyaltyService loyaltyService;
	
//	@PostMapping("/memCreation")
//	public String loyaltyMemberCreation(@RequestBody UserProfileDto userProfileDto) throws Exception {
//		return loyaltyService.loyaltyMemberCreation(userProfileDto);
//	}
//	
	@PostMapping("/bdayVocher")
	public String generateBdayVocher() throws Exception{
		return loyaltyService.generateBdayVocher();
	}
	
	@GetMapping("/{userId}")
	@ApiOperation(value = "Fetch User Loyalty Points ....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Fetched User Loyalty Points"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<Double> fetchUserLoyaltyPoints(@PathVariable String userId) {
		return new ResponseEntity<>(loyaltyService.fetchUserLoyaltyPoints(userId),HttpStatus.OK);
		
	}
	
	@GetMapping("/{userId}/{vocherCode}")
	@ApiOperation(value = "Validate Vocher Code wrt user ....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Varified the vochers available to user"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 400,message = "Vocher not Found wrt User .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<Integer> validateVocherCode(@PathVariable String userId, @PathVariable String vocherCode) throws LoyaltyRewardsGlobalAppException {
		return new ResponseEntity<>(loyaltyService.validateVocherCodeAndFetchDiscountValue(userId,vocherCode),HttpStatus.OK);
	}

	@PostMapping("/")
	public void loyaltyRewards(@RequestBody OrderDetails order) {
		loyaltyService.loyaltyRewardsReimbursment(order);
	}
	
	@PostMapping("/vocher")
	@ApiOperation(value = "Add Festival vocher wrt Country ....")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added vocher and assigned to tier level 2 and above users wrt Country..!"),
			@ApiResponse(code = 400,message = "Bad Request .."),@ApiResponse(code = 500,message = "Internal Server Error ..")})
	public ResponseEntity<String> addFestiveVocher(@RequestBody LoyaltyVoucher loyaltyVoucher) throws LoyaltyRewardsGlobalAppException {
		return new ResponseEntity<>(loyaltyService.addFestiveVoucher(loyaltyVoucher),HttpStatus.CREATED);
	}
	
	@PostMapping("/unAssignVoucher")
	public String loyaltyRewards() {
		return loyaltyService.deleteAllUsedAndExpiredVouchers();
	}
}

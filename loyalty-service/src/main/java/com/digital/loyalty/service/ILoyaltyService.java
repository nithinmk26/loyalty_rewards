package com.digital.loyalty.service;

import com.digital.loyalty.dto.request.OrderDetails;
import com.digital.loyalty.dto.request.UserProfileDto;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.exception.LoyaltyRewardsGlobalAppException;

public interface ILoyaltyService {

//	String loyaltyMemberCreation(UserProfileDto userProfileDto) throws Exception;
	
	public String generateBdayVocher() throws Exception;

	double fetchUserLoyaltyPoints(String userId);

	int validateVocherCodeAndFetchDiscountValue(String userId,String vocherCode) throws LoyaltyRewardsGlobalAppException;

	void loyaltyRewardsReimbursment(OrderDetails order);

	String addFestiveVoucher(LoyaltyVoucher loyaltyVoucher) throws LoyaltyRewardsGlobalAppException;

	public String deleteAllUsedAndExpiredVouchers();

}

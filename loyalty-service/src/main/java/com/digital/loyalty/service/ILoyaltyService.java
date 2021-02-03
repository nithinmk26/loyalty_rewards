package com.digital.loyalty.service;

import com.digital.loyalty.dto.request.UserProfileDto;

public interface ILoyaltyService {

	String loyaltyMemberCreation(UserProfileDto userProfileDto) throws Exception;

}

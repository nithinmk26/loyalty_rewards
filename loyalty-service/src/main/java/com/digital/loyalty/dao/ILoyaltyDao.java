package com.digital.loyalty.dao;

import java.util.Optional;

import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.entity.TierLevel;

public interface ILoyaltyDao {

	Optional<LoyaltyMember> checkExistingMembers(String userId);

	Optional<TierLevel> fetchTierBasedOnCountry(String country);
	
	Optional<LoyaltyVoucher> fetchLoyaltyVocher(String string, String country);

	LoyaltyMember persistMember(LoyaltyMember loyaltyMember);


}

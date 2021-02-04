package com.digital.loyalty.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.entity.TierLevel;

public interface ILoyaltyDao {

	Optional<LoyaltyMember> checkExistingMembers(String userId);

	Optional<TierLevel> fetchTierBasedOnCountry(String country);
	
	Optional<LoyaltyVoucher> fetchLoyaltyVocher(String string, String country);

	LoyaltyMember persistMember(LoyaltyMember loyaltyMember);

	Optional<List<LoyaltyMember>> fetchBirthdayCelebrators(String dateRegex);

	double fetchLoyaltyPointsforUser(String userId);

	LoyaltyMember validateVocherCode(String vocherCode);

}

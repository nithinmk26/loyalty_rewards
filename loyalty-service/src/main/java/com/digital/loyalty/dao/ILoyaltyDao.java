package com.digital.loyalty.dao;

import java.util.List;
import java.util.Optional;

import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.LoyaltyRewards;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.entity.TierLevel;

public interface ILoyaltyDao {

	Optional<LoyaltyMember> fetchExistingMembers(String userId);

	Optional<TierLevel> fetchTierBasedOnCountry(String country);
	
	Optional<LoyaltyVoucher> fetchLoyaltyVocher(String string, String country);

	LoyaltyMember persistMember(LoyaltyMember loyaltyMember);

	Optional<List<LoyaltyMember>> fetchBirthdayCelebrators(String dateRegex);

	double fetchLoyaltyPointsforUser(String userId);

	LoyaltyMember validateVocherCode(String vocherCode);

	Optional<LoyaltyRewards> fetchLoyaltyRewards(String country);

	LoyaltyVoucher persistVoucher(LoyaltyVoucher loyaltyVoucher);

	Optional<TierLevel> upgradeTier(String country, int existingTierLevel);

	List<LoyaltyMember> findAllMembersAboveTier2(String country);

	void updateAllMembers(List<LoyaltyMember> loyaltyMemberList);

	int findVoucherBasedonCountryAndEngagement(String engagementName, String country);

	List<TierLevel> fetchTiersBasedOnCountry(String country);


}

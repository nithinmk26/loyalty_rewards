package com.digital.loyalty.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.loyalty.dao.ILoyaltyDao;
import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.LoyaltyRewards;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.entity.TierLevel;
import com.digital.loyalty.repository.LoyaltyRepository;
import com.digital.loyalty.repository.LoyaltyRewardsRepository;
import com.digital.loyalty.repository.LoyaltyVocherRepository;
import com.digital.loyalty.repository.TierRepository;

@Service
public class LoyaltyDaoImpl implements ILoyaltyDao{
	
	@Autowired
	private LoyaltyRepository loyaltyRepository;
	
	@Autowired
	private TierRepository tierRepository;
	
	@Autowired
	private LoyaltyVocherRepository loyaltyVocherRepository;
	
	@Autowired
	private LoyaltyRewardsRepository loyaltyRewardsRepository;
	
	@Override
	public Optional<LoyaltyMember> fetchExistingMembers(String userId) {
		return loyaltyRepository.findByUserId(userId);
		
	}

	@Override
	public Optional<TierLevel> fetchTierBasedOnCountry(String country) {
		return tierRepository.findByCountry(country);
	}

	@Override
	public Optional<LoyaltyVoucher> fetchLoyaltyVocher(String engmt, String country) {
		return loyaltyVocherRepository.fetchVocherByCountryAndEngmt(engmt,country);
	}

	@Override
	public LoyaltyMember persistMember(LoyaltyMember loyaltyMember) {
		return loyaltyRepository.saveAndFlush(loyaltyMember);
	}

	@Override
	public Optional<List<LoyaltyMember>> fetchBirthdayCelebrators(String dateRegex) {
		return loyaltyRepository.findAllByDateOfBirth(dateRegex);
	}

	@Override
	public double fetchLoyaltyPointsforUser(String userId) {
		return loyaltyRepository.findByUserLoyaltyPoint(userId);
		 
	}

	@Override
	public LoyaltyMember validateVocherCode(String userId) {
		Optional<LoyaltyMember> loyaltyMember = loyaltyRepository.findByUserId(userId);
		return loyaltyMember.get();
	}

	@Override
	public Optional<LoyaltyRewards> fetchLoyaltyRewards(String country) {
		return loyaltyRewardsRepository.findByCountry(country);
	}

	@Override
	public LoyaltyVoucher persistVoucher(LoyaltyVoucher loyaltyVoucher) {
		return loyaltyVocherRepository.saveAndFlush(loyaltyVoucher);
	}

	@Override
	public Optional<TierLevel> upgradeTier(String country, int existingTierLevel) {
		//existingTierLevel+1 to upgrade into next level
		return tierRepository.findTierByCoutryAndTierLevel(country,existingTierLevel);
	}

	@Override
	public List<LoyaltyMember> findAllMembersAboveTier2(String country) {
		return loyaltyRepository.findAllMembersAboveTier2(country);
	}

	@Override
	public void updateAllMembers(List<LoyaltyMember> loyaltyMemberList) {
		loyaltyRepository.saveAll(loyaltyMemberList);
	}

	@Override
	public int findVoucherBasedonCountryAndEngagement(String engagementName, String country) {
		return loyaltyVocherRepository.existsByEngagementAndCountry(engagementName,country);
	}


}

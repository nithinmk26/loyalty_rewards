package com.digital.loyalty.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.loyalty.dao.ILoyaltyDao;
import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.entity.TierLevel;
import com.digital.loyalty.repository.LoyaltyRepository;
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
	
	@Override
	public Optional<LoyaltyMember> checkExistingMembers(String userId) {
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

}

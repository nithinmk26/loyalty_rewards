package com.digital.loyalty.service.impl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.digital.loyalty.dao.ILoyaltyDao;
import com.digital.loyalty.dto.request.UserProfileDto;
import com.digital.loyalty.entity.EngagementDetail;
import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.entity.TierLevel;
import com.digital.loyalty.service.ILoyaltyService;
import com.digital.loyalty.util.MailGenenerator;

@Service
public class LoyaltyServiceImpl implements ILoyaltyService{
	
	static SecureRandom secRandom = new SecureRandom();
	
	@Autowired
	private ILoyaltyDao loyaltyDao;
	
	@Value("${initial.loyaltypoint}")
	private int initialLoyaltyPoints;
	
	
	public static String vocherIdGenerator(String type) {
		String vocherId = type;
		 String uuid = UUID.randomUUID().toString();
		 return vocherId +"-" +uuid;
	}
	
	public static String memberIdGenerator(String name,LocalDate dob,String country) {
		int nameLength = name.length();
		String nameLiteral = name.substring(0, 3);
		String metaUserData =country + dob.getDayOfMonth();
		StringBuilder memberId = new StringBuilder(10);
		memberId.append(nameLiteral);
		 for(int i = 0; i < 10; i++) {
			 memberId.append(metaUserData.charAt(secRandom.nextInt(metaUserData.length())));
		 }
		 return memberId.toString();
		
	}

	@Override
	public String loyaltyMemberCreation(UserProfileDto userProfileDto) throws Exception {
		Optional<LoyaltyMember> loyaltyMemberFetched = loyaltyDao.checkExistingMembers(userProfileDto.getUserId());
		Set<EngagementDetail> engagementList = new HashSet<>();
		if(!loyaltyMemberFetched.isPresent()) {
			String memberId = memberIdGenerator(userProfileDto.getUserName(), userProfileDto.getDateOfBirth(), userProfileDto.getCountry());
			String vocherCode = vocherIdGenerator("SIGNUP");
			LoyaltyMember loyaltyMember = new LoyaltyMember().setUserId(userProfileDto.getUserId()).setCreatedDate(LocalDate.now())
				.setEmail(userProfileDto.getUserEmail()).setMemberId(memberId).setName(userProfileDto.getUserName()).setCountry(userProfileDto.getCountry()).setDateOfBirth(userProfileDto.getDateOfBirth());
			Optional<TierLevel> tierFetched = loyaltyDao.fetchTierBasedOnCountry(userProfileDto.getCountry());
			loyaltyMember.setTier(tierFetched.get());
			Optional<LoyaltyVoucher> vocherFetched = loyaltyDao.fetchLoyaltyVocher("SIGNUP",userProfileDto.getCountry());
			EngagementDetail engementDetail = new EngagementDetail().setAssignedDate(LocalDate.now()).setCountry(userProfileDto.getCountry()).setDescription(vocherFetched.get().getDescription())
			.setDiscountInPercent(vocherFetched.get().getDiscountInPercent())
			.setEngagementName(vocherFetched.get().getEngagementName())
		    .setVoucherCode(vocherCode);
			engementDetail.setVoucherValidity(engementDetail.getAssignedDate().plus(vocherFetched.get().getVoucherValidity(), ChronoUnit.DAYS));
			engagementList.add(engementDetail);
			loyaltyMember.setLoyaltyPoints((double)initialLoyaltyPoints);
			loyaltyMember.setEngagementDetail(engagementList.stream().collect(Collectors.toList()));
			loyaltyDao.persistMember(loyaltyMember);
//			loyaltyMember.getEngagementDetail().addAll(engagementList.stream().collect(Collectors.toList()));
//			loyaltyDao.updateEngagements(loyaltyMember);
			try {
			MailGenenerator.emailGenerator(userProfileDto.getUserEmail(), vocherCode);
			}
			catch (Exception e) { 
				return "Please connect to internet";
			}
			
		}
		return "Member Created Successfully....!";
	
	}

}

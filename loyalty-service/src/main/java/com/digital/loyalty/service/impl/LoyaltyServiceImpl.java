package com.digital.loyalty.service.impl;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.digital.loyalty.dao.ILoyaltyDao;
import com.digital.loyalty.dto.request.OrderDetails;
import com.digital.loyalty.dto.request.UserProfileDto;
import com.digital.loyalty.entity.EngagementDetail;
import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.LoyaltyRewards;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.entity.TierLevel;
import com.digital.loyalty.exception.LoyaltyRewardsGlobalAppException;
import com.digital.loyalty.exception.VocherAlreadyUtilizedException;
import com.digital.loyalty.exception.VocherInvalidException;
import com.digital.loyalty.service.ILoyaltyService;
import com.digital.loyalty.util.MailGenenerator;

@Service
public class LoyaltyServiceImpl implements ILoyaltyService{
	
	static SecureRandom secRandom = new SecureRandom();
	
	@Autowired
	private ILoyaltyDao loyaltyDao;
	
	@Value("${initial.loyaltypoint}")
	private int initialLoyaltyPoints;
	
	private static final String BDAYENGAGEMENT = "BIRTHDAY";
	
	private static final String SIGNUPENGAGEMENT = "SIGNUP";
	
	private static final String FESTIVEENGAGEMENT = "FEST";
	
	public static String vocherIdGenerator(String type) {
		String vocherId = type;
		 String uuid = UUID.randomUUID().toString();
		 return vocherId +"-" +uuid;
	}
	
	public static String memberIdGenerator(String name,LocalDate dob,String country) {
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
		Optional<LoyaltyMember> loyaltyMemberFetched = loyaltyDao.fetchExistingMembers(userProfileDto.getUserId());
		Set<EngagementDetail> engagementList = new HashSet<>();
		if(!loyaltyMemberFetched.isPresent()) {
			String memberId = memberIdGenerator(userProfileDto.getUserName(), userProfileDto.getDateOfBirth(), userProfileDto.getCountry());
			String vocherCode = vocherIdGenerator(SIGNUPENGAGEMENT);
			LoyaltyMember loyaltyMember = new LoyaltyMember()
					.setUserId(userProfileDto.getUserId())
					.setCreatedDate(LocalDate.now())
					.setEmail(userProfileDto.getUserEmail())
					.setMemberId(memberId)
					.setName(userProfileDto.getUserName())
					.setCountry(userProfileDto.getCountry())
					.setDateOfBirth(userProfileDto.getDateOfBirth());
			//fetch the Tier level based on user country...
//			Optional<TierLevel> tierFetched = loyaltyDao.fetchTierBasedOnCountry(userProfileDto.getCountry());
//			loyaltyMember.setTier(tierFetched.get());
//			
//			//fetch the vocher based on engagements and user country
//			Optional<LoyaltyVoucher> vocherFetched = loyaltyDao.fetchLoyaltyVocher("SIGNUP",userProfileDto.getCountry());
//			
//			//Generating engagement related data and assign the same to user..
//			EngagementDetail engementDetail = new EngagementDetail()
//					.setAssignedDate(LocalDate.now())
//					.setCountry(userProfileDto.getCountry())
//					.setDescription(vocherFetched.get().getDescription())
//					.setDiscountInPercent(vocherFetched.get().getDiscountInPercent())
//					.setEngagementName(vocherFetched.get().getEngagementName())
//					.setVoucherCode(vocherCode);
//			
//			
//			engementDetail.setVoucherValidity(engementDetail.getAssignedDate().plus(vocherFetched.get().getVoucherValidity(), ChronoUnit.DAYS));
//			engagementList.add(engementDetail);
//			loyaltyMember.setLoyaltyPoints((double)initialLoyaltyPoints);
//			loyaltyMember.setEngagementDetail(engagementList.stream().collect(Collectors.toList()));
			//persist user
			loyaltyMember = assignEngagementToUser(loyaltyMember,SIGNUPENGAGEMENT);
			loyaltyDao.persistMember(loyaltyMember);
			try {
				//send the vocher to the user....
			MailGenenerator.emailGenerator(userProfileDto.getUserEmail(), vocherCode);
			if (userProfileDto.getDateOfBirth().getDayOfMonth() == LocalDate.now().getDayOfMonth()  && userProfileDto.getDateOfBirth().getMonthValue() == LocalDate.now().getMonthValue()) {
				//send the bday vocher
				MailGenenerator.emailGenerator(userProfileDto.getUserEmail(), vocherIdGenerator(BDAYENGAGEMENT));
			}
			}
			catch (Exception e) {  
				return "Please connect to internet";
			}
		}
		return "Member Created Successfully....!"; 
	
	} 
	
	
	
	public String generateBdayVocher() throws Exception {
		StringBuilder dateRegex = new StringBuilder("%");
		
		int monthValue = LocalDate.now().getMonthValue();
		if(monthValue < 10)
			dateRegex = dateRegex.append('0').append(monthValue);
		else
			dateRegex = dateRegex.append(monthValue);
		
		int dayOftheMonth = LocalDate.now().getDayOfMonth();
		
		StringBuilder date = new StringBuilder();
		if(dayOftheMonth<10)
			date = date.append('0').append(dayOftheMonth);
		else 
			date = date.append(dayOftheMonth);
		
		dateRegex.append('-').append(date);
		List<LoyaltyMember> membersList = loyaltyDao.fetchBirthdayCelebrators(dateRegex.toString()).get();
		if(!membersList.isEmpty()) {
			for (LoyaltyMember loyaltyMember : membersList) {
				loyaltyMember = assignEngagementToUser(loyaltyMember, BDAYENGAGEMENT);
				loyaltyDao.persistMember(loyaltyMember);
				MailGenenerator.emailGenerator(loyaltyMember.getEmail(), vocherIdGenerator(BDAYENGAGEMENT));
			}
		}
		
		
		return "Birthday Vocher sent all birthday celebrators today..!";
		
	}
	
	public LoyaltyMember assignEngagementToUser(LoyaltyMember loyaltyMember,String engagement) {
		Optional<TierLevel> tierFetched = loyaltyDao.fetchTierBasedOnCountry(loyaltyMember.getCountry());
		loyaltyMember.setTier(tierFetched.get());
		Optional<LoyaltyVoucher> vocherFetched = loyaltyDao.fetchLoyaltyVocher(engagement,loyaltyMember.getCountry());
		Set<EngagementDetail> engagementList = new HashSet<>();
		//Generating engagement related data and assign the same to user..
		EngagementDetail engementDetail = new EngagementDetail()
				.setAssignedDate(LocalDate.now())
				.setCountry(loyaltyMember.getCountry())
				.setDescription(vocherFetched.get().getDescription())
				.setDiscountInPercent(vocherFetched.get().getDiscountInPercent())
				.setEngagementName(vocherFetched.get().getEngagementName())
				.setVoucherCode(vocherIdGenerator(engagement))
				.setApplied(false);
		engementDetail.setVoucherValidity(engementDetail.getAssignedDate().plus(vocherFetched.get().getVoucherValidity(), ChronoUnit.DAYS));
		engagementList.add(engementDetail);
		loyaltyMember.setLoyaltyPoints((double)initialLoyaltyPoints);
		loyaltyMember.setEngagementDetail(engagementList.stream().collect(Collectors.toList()));
		return loyaltyMember;
	}

	@Override
	public double fetchUserLoyaltyPoints(String userId) {
		return loyaltyDao.fetchLoyaltyPointsforUser(userId);
	}

	@Override
	public int validateVocherCodeAndFetchDiscountValue(String userId, String vocherCode) throws LoyaltyRewardsGlobalAppException {
		LoyaltyMember loyaltyMember =  loyaltyDao.validateVocherCode(userId);
		for (EngagementDetail vocher : loyaltyMember.getEngagementDetail()) {
			if(vocher.getVoucherCode().equals(vocherCode) && vocher.getVoucherValidity().isAfter(LocalDate.now())) {	
				if(vocher.isApplied()) {
					throw new VocherAlreadyUtilizedException("Vocher has been already used...try with diffrent vocher..!");
				}
				return vocher.getDiscountInPercent();
			}
			else
				throw new VocherInvalidException("Vocher code is INVALID or EXPIRED...!");
		}
		return 0;
		
	}
	
	
	/**
	 * @param userId
	 * @param vocherCode
	 * 
	 * @implNote updates vocher after being used have to initalized by kafka topic
	 */
	public void updateUtilizedVocher(String userId,String vocherCode) {
		LoyaltyMember loyaltyMember = loyaltyDao.fetchExistingMembers(userId).get();
		for (EngagementDetail vocher : loyaltyMember.getEngagementDetail()) {
			if(vocher.getVoucherCode().equals(vocherCode)) {
				vocher.setApplied(true);
			}
		}
		loyaltyDao.persistMember(loyaltyMember);

	}

	/**
	 *@implNote initialized by kafka topic 
	 *once order placed successfully rewards have to be calculated and updated onto loyalty member rewards in user
	 */
	@Override
	public void loyaltyRewards(OrderDetails order) {
		Optional<LoyaltyMember> loyaltyMember = loyaltyDao.fetchExistingMembers(order.getUserId());
		Optional<LoyaltyRewards> loyaltyRewards = loyaltyDao.fetchLoyaltyRewards(loyaltyMember.get().getCountry());
		int rewardsPercent = loyaltyRewards.get().getRewardsInPercent();
		double totalRewardPoints = (rewardsPercent * order.getOrderAmount())/100;
		loyaltyMember.get().setLoyaltyPoints(loyaltyMember.get().getLoyaltyPoints() + totalRewardPoints);
		//update tier based on total loyalty points
		loyaltyDao.persistMember(loyaltyMember.get());
	}

	@Override
	public String addFestiveVoucher(LoyaltyVoucher loyaltyVoucher) {
		loyaltyDao.persistVoucher(loyaltyVoucher);
		//send vocher data to kafka to assign to all users
		return null;
	}
	
}

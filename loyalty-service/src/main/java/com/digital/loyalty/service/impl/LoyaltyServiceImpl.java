package com.digital.loyalty.service.impl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.digital.loyalty.dao.ILoyaltyDao;
import com.digital.loyalty.dto.request.OrderDetails;
import com.digital.loyalty.dto.request.UserProfileDto;
import com.digital.loyalty.dto.request.VoucherUserDto;
import com.digital.loyalty.entity.EngagementDetail;
import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.LoyaltyRewards;
import com.digital.loyalty.entity.LoyaltyVoucher;
import com.digital.loyalty.entity.TierLevel;
import com.digital.loyalty.exception.LoyaltyRewardsGlobalAppException;
import com.digital.loyalty.exception.VocherAlreadyExistsException;
import com.digital.loyalty.exception.VocherAlreadyUtilizedException;
import com.digital.loyalty.exception.VocherInvalidException;
import com.digital.loyalty.service.ILoyaltyService;
import com.digital.loyalty.util.MailGenenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	private static final String SIGNUPMESSAGE = "Dear %s, Thank you for registering into our website and being part of our KN group , here is the small gift signup voucher for you to shop into our website Have a niceday and enjoy !!! :) ";
	
	private static final String BDAYMESSAGE = "Dear %s, From KN group side we wishing  you a very prosperous Happy Birthday..!Let your day be filled with lot of memories and joyfull, here is the small gift voucher for you...!  ";
	
	private static final String FESTMESSAGE = "Dear %s, From KN group side we wishing  happy festival, here is the small gift voucher for you...!  ";

	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	private static final String VOCHER_ASSIGNMENT_TOPIC = "vocherAssignmentTopic";
	
	
	/**
	 * Completed Working Fine
	 */
//	@Override
	@KafkaListener(topics = "loyaltyMemberCreationTopic", groupId = "group_id")
	public String loyaltyMemberCreation(String byteData) throws Exception {
		UserProfileDto userProfileDto = objectMapper.readValue(byteData,UserProfileDto.class);
		Optional<LoyaltyMember> loyaltyMemberFetched = loyaltyDao.fetchExistingMembers(userProfileDto.getUserId());
		if(!loyaltyMemberFetched.isPresent()) {
			String memberId = memberIdGenerator(userProfileDto.getUserName(), LocalDate.parse(userProfileDto.getDateOfBirth()), userProfileDto.getCountry());
			String vocherCode = vocherIdGenerator(SIGNUPENGAGEMENT);
			LoyaltyMember loyaltyMember = new LoyaltyMember()
					.setUserId(userProfileDto.getUserId())
					.setCreatedDate(LocalDate.now())
					.setEmail(userProfileDto.getUserEmail())
					.setMemberId(memberId)
					.setName(userProfileDto.getUserName())
					.setCountry(userProfileDto.getCountry())
					.setDateOfBirth(LocalDate.parse(userProfileDto.getDateOfBirth()));
			loyaltyMember = assignEngagementToUser(loyaltyMember,SIGNUPENGAGEMENT);
			loyaltyDao.persistMember(loyaltyMember);
			try {
				//send the vocher to the user....
			MailGenenerator.emailGenerator(userProfileDto.getUserEmail(),String.format(SIGNUPMESSAGE, userProfileDto.getUserName()) , SIGNUPENGAGEMENT,vocherCode);
			if (LocalDate.parse(userProfileDto.getDateOfBirth()).getDayOfMonth() == LocalDate.now().getDayOfMonth()  && LocalDate.parse(userProfileDto.getDateOfBirth()).getMonthValue() == LocalDate.now().getMonthValue()) {
				//send the bday vocher
				MailGenenerator.emailGenerator(userProfileDto.getUserEmail(),String.format(BDAYMESSAGE, userProfileDto.getUserName()) ,BDAYENGAGEMENT ,vocherIdGenerator(BDAYENGAGEMENT));
			}
			}
			catch (Exception e) {  
				return "Please connect to internet";
			}
		}
		return "Member Created Successfully....!"; 
	
	} 
	
	
	/**
	 *Genrate Bday Vocher working fyn ... have to implement CRON job
	 */
	@Override
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
				MailGenenerator.emailGenerator(loyaltyMember.getEmail(),String.format(BDAYMESSAGE, loyaltyMember.getName()) ,BDAYENGAGEMENT ,vocherIdGenerator(BDAYENGAGEMENT));
			}
		}
		return "Birthday Vocher sent to all birthday celebrators today..!";
		
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

	/**
	 * Completed Working fyn
	 */
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
	
	
	@KafkaListener(topics = "loyaltyManagermentTopic", groupId = "group_id")
	public void consumeLoyaltyMemberCreationTopic(String byteData)  {
		try {
			VoucherUserDto voucherUserDto = objectMapper.readValue(byteData,VoucherUserDto.class);
			updateUtilizedVocher(voucherUserDto.getUserId(), voucherUserDto.getVoucherCode());
			OrderDetails orderDetails = new OrderDetails().setUserId(voucherUserDto.getUserId()).setOrderAmount(voucherUserDto.getOrderAmount());
			updateUserLoyaltyPoints(voucherUserDto);
			loyaltyRewardsReimbursment(orderDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param userId
	 * @param vocherCode
	 * 
	 * Pending
	 * 
	 * @implNote updates vocher after being used have to initalized by kafka topic
	 */
	public void updateUtilizedVocher(String userId,String vocherCode) {
		//use vocher code dto  
		LoyaltyMember loyaltyMember = loyaltyDao.fetchExistingMembers(userId).get();
		for (EngagementDetail vocher : loyaltyMember.getEngagementDetail()) {
			if(vocher.getVoucherCode().equals(vocherCode)) {
				vocher.setApplied(true);
			}
		}
		loyaltyDao.persistMember(loyaltyMember);

	}
	
	
	//call from kafka consumer
		//downgradeTier
		/**
		 * @param voucherUserDto
		 * Pending
		 */
		public void updateUserLoyaltyPoints(VoucherUserDto voucherUserDto) {
			LoyaltyMember loyaltyMember = loyaltyDao.fetchExistingMembers(voucherUserDto.getUserId()).get();
			loyaltyMember.setLoyaltyPoints(loyaltyMember.getLoyaltyPoints() - voucherUserDto.getUtilizedLoyaltyPoints());
			TierLevel userCurrentTier = loyaltyMember.getTier();
			if((userCurrentTier.getLowerBoundTierValue() > loyaltyMember.getLoyaltyPoints()) && (loyaltyMember.getTier().getLevelOftheTier() > 0)) {
				TierLevel downgradeTier = loyaltyDao.upgradeTier(loyaltyMember.getCountry(),loyaltyMember.getTier().getLevelOftheTier()-1).get();
				loyaltyMember.setTier(downgradeTier);
			}
			
			loyaltyDao.persistMember(loyaltyMember);
		}

	/**
	 *@implNote initialized by kafka topic 
	 *once order placed successfully rewards have to be calculated and updated onto loyalty member rewards in user
	 *
	 *pending
	 */
	@Override
	public void loyaltyRewardsReimbursment(OrderDetails order) {
		//change ordersetails to vocherUserDto request once kafka implemented
		Optional<LoyaltyMember> loyaltyMember = loyaltyDao.fetchExistingMembers(order.getUserId());
		Optional<LoyaltyRewards> loyaltyRewards = loyaltyDao.fetchLoyaltyRewards(loyaltyMember.get().getCountry());
		int rewardsPercent = loyaltyRewards.get().getRewardsInPercent();
		double totalRewardPoints = (rewardsPercent * order.getOrderAmount())/100;
		loyaltyMember.get().setLoyaltyPoints(loyaltyMember.get().getLoyaltyPoints() + totalRewardPoints);
		//update tier based on total loyalty points - Done neeed to test
		TierLevel userCurrentTier = loyaltyMember.get().getTier();
		if((userCurrentTier.getUpperBoundTierValue() < loyaltyMember.get().getLoyaltyPoints()) && (loyaltyMember.get().getTier().getLevelOftheTier() <= 2)) {
			TierLevel upgradeTier = loyaltyDao.upgradeTier(loyaltyMember.get().getCountry(),loyaltyMember.get().getTier().getLevelOftheTier()+1).get();
			loyaltyMember.get().setTier(upgradeTier);
		}
		loyaltyDao.persistMember(loyaltyMember.get());
	}

	
	
	/**
	 *Completed Working fyn
	 */
	@Override
	public String addFestiveVoucher(LoyaltyVoucher loyaltyVoucher) throws LoyaltyRewardsGlobalAppException {
		if(loyaltyDao.findVoucherBasedonCountryAndEngagement(loyaltyVoucher.getEngagementName(),loyaltyVoucher.getCountry())==1) {
			throw new VocherAlreadyExistsException(String.format("Vocher Engagement %s is already present for Country %s", loyaltyVoucher.getEngagementName(),loyaltyVoucher.getCountry()));
		}
		LoyaltyVoucher loyalVoucherSaved = loyaltyDao.persistVoucher(loyaltyVoucher);
		//send voucher data to kafka to assign to all users
		//null pointer exception
		kafkaTemplate.send(VOCHER_ASSIGNMENT_TOPIC,loyalVoucherSaved);
		return String.format("Festival Voucher is assigned to %s country users", loyaltyVoucher.getCountry());
	}
	
	//called from festVocher to assign all vochers to user..
	/**
	 * @param engagement
	 * Consume kafka topic
	 * Vocher Email is not sending - cleared
	 * Completed Working fyn
	 * 
	 * 	 */
	@KafkaListener(topics = VOCHER_ASSIGNMENT_TOPIC, groupId = "group_id")
	public void assigningVocherToUsers(String byteData) {
		String country;
		try {
			LoyaltyVoucher voucher = objectMapper.readValue(byteData, LoyaltyVoucher.class);
			List<LoyaltyMember> loyaltyMemberList = loyaltyDao.findAllMembersAboveTier2(voucher.getCountry());
			loyaltyMemberList.stream().map(member->
			{
				MailGenenerator.emailGenerator(member.getEmail(), String.format(FESTMESSAGE, member.getName()) , voucher.getEngagementName(), vocherIdGenerator(voucher.getEngagementName()));
				return assignEngagementToUser(member, voucher.getEngagementName());
				}).collect(Collectors.toList());
			loyaltyDao.updateAllMembers(loyaltyMemberList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
	
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



	
	//delete all expd voucher assigned to sepcied persons
	//delete all expired vochers from vocher list
	
	
	
}

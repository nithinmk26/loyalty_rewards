package com.digital.loyalty.service.impl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.UUID;

public class LoyaltyServiceImpl {
	
	static SecureRandom sec_random = new SecureRandom();
	
	public static String vocherIdGenerator(String type) {
		String vocherId = type;
		 String uuid = UUID.randomUUID().toString();
		 return vocherId +"-" +uuid;
	}
	
	public static String memberIdGenerator(String name,LocalDate dob,String country) {
		
		String metaUserData = name + country + dob.getDayOfMonth();
		StringBuilder memberId = new StringBuilder(10);
		 for(int i = 0; i < 10; i++) {
			 memberId.append(metaUserData.charAt(sec_random.nextInt(metaUserData.length())));
		 }
		 
		 return memberId.toString();
		
	}

}

package com.digital.loyalty.service.impl;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.UUID;

public class LoyaltyServiceImpl {
	
	static SecureRandom secRandom = new SecureRandom();
	
	public static String vocherIdGenerator(String type) {
		String vocherId = type;
		 String uuid = UUID.randomUUID().toString();
		 return vocherId +"-" +uuid;
	}
	
	public static String memberIdGenerator(String name,LocalDate dob,String country) {
		int nameLength = name.length();
		String nameLiteral = name.substring(0, nameLength-1);
		String metaUserData =country + dob.getDayOfMonth();
		StringBuilder memberId = new StringBuilder(10);
		memberId.append(nameLiteral);
		 for(int i = 0; i < 10; i++) {
			 memberId.append(metaUserData.charAt(secRandom.nextInt(metaUserData.length())));
		 }
		 return memberId.toString();
		
	}

}

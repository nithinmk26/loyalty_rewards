package com.digital.loyalty.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digital.loyalty.entity.LoyaltyVoucher;

@Repository
public interface LoyaltyVocherRepository extends JpaRepository<LoyaltyVoucher, Integer> {

	@Query(nativeQuery = true, value = "select * from loyalty_rewards_tiers.loyalty_voucher where voucher_country = ?2 AND engagement_name = ?1")
	Optional<LoyaltyVoucher> fetchVocherByCountryAndEngmt(String engmt, String country);

}

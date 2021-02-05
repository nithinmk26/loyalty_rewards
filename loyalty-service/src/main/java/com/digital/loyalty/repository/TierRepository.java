package com.digital.loyalty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.TierLevel;

@Repository
public interface TierRepository extends JpaRepository<TierLevel, Integer> {

	@Query(nativeQuery = true, value = "select * from loyalty_rewards_tiers.tier_level where tier_country = ?1 and tier_level=0")
	Optional<TierLevel> findByCountry(String country);

	@Query(nativeQuery = true, value = "select * from loyalty_rewards_tiers.tier_level where tier_country = ?1 and tier_level = ?2")
	Optional<TierLevel> findTierByCoutryAndTierLevel(String country, int existingTierLevel);


}

package com.digital.loyalty.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.loyalty.entity.LoyaltyRewards;

@Repository
public interface LoyaltyRewardsRepository extends JpaRepository<LoyaltyRewards, Integer>{

	Optional<LoyaltyRewards> findByCountry(String country);

}

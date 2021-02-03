package com.digital.loyalty.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.loyalty.entity.LoyaltyMember;
import com.digital.loyalty.entity.TierLevel;

@Repository
public interface LoyaltyRepository extends JpaRepository<LoyaltyMember, Integer>{

	Optional<LoyaltyMember> findByUserId(String userId);

}

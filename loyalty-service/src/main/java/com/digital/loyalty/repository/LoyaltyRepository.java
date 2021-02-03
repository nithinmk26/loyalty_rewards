package com.digital.loyalty.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digital.loyalty.entity.LoyaltyMember;

@Repository
public interface LoyaltyRepository extends JpaRepository<LoyaltyMember, Integer>{

	Optional<LoyaltyMember> findByUserId(String userId);

	@Query(nativeQuery = true, value = "select * from loyalty_rewards_tiers.loyalty_member where loyalty_member.date_of_birth  like ?1")
	Optional<List<LoyaltyMember>> findAllByDateOfBirth(String dateRegex);

	@Query(nativeQuery = true, value = "select loyalty_member.loyalty_points from loyalty_rewards_tiers.loyalty_member where loyalty_member.user_id = ?1")
	double findByUserLoyaltyPoint(String userId);

}

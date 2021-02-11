package com.digital.loyalty.repository;

import java.time.LocalDate;
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
	
	@Query(nativeQuery = true, value = "select loyalty_member.* from loyalty_member inner join tier_level  on loyalty_member.tier_id = tier_level.tier_id where tier_level.tier_level >= 2 and tier_country =?1")
	List<LoyaltyMember> findAllMembersAboveTier2(String country);

	@Query(nativeQuery = true, value = "SELECT DISTINCT mem.* FROM loyalty_member mem JOIN loyalty_member_engagements memeng ON mem.serial_id = memeng.serial_id JOIN engagement_detail eng ON memeng.engagement_id = eng.engagement_id WHERE eng.isapplied=1 or eng.voucher_validity < ?1")
	List<LoyaltyMember> fetchAllUsersWithExipredVouchers(LocalDate date);

}

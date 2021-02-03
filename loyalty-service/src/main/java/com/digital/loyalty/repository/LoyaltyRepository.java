package com.digital.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.loyalty.entity.LoyaltyMember;

@Repository
public interface LoyaltyRepository extends JpaRepository<LoyaltyMember, Integer> {

}

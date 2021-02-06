package com.digital.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.loyalty.entity.EngagementDetail;

@Repository
public interface EngagementDetailRepository extends JpaRepository<EngagementDetail, Integer> {

}

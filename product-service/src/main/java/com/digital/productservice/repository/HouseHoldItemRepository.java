package com.digital.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.productservice.entity.HouseHoldItemData;

@Repository
public interface HouseHoldItemRepository extends JpaRepository<HouseHoldItemData, Integer>{

}

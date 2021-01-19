package com.digital.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.productservice.entity.ElectronicAppliancesData;

@Repository
public interface ElectronicApplancesRepository extends JpaRepository<ElectronicAppliancesData, Integer> {

}

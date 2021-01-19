package com.digital.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.productservice.entity.ApparelData;

@Repository
public interface ApparelDataRepository extends JpaRepository<ApparelData, Integer>{

}

package com.digital.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.productservice.entity.Product;

@Repository
public interface ProductServiceRepository extends JpaRepository<Product, Integer>{

}

package com.digital.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digital.cart.entity.Item;

@Repository
public interface ItemDetailsRepository extends JpaRepository<Item, Integer> {

}

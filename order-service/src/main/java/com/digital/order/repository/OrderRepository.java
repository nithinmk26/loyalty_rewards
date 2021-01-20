package com.digital.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

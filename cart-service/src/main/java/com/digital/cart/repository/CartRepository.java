/**
 * 
 */
package com.digital.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.cart.entity.CartDetail;

/**
 * @author Loyalty_Digiteam
 *
 */
@Repository
public interface CartRepository extends JpaRepository<CartDetail, Integer>{

}

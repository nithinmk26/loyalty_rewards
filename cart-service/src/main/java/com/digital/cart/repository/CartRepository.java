/**
 * 
 */
package com.digital.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.cart.entity.CartDetail;

/**
 * @author Loyalty_Digiteam
 *
 */
@Repository
public interface CartRepository extends JpaRepository<CartDetail, Integer>{
	
	Optional<CartDetail> findByUserId( int userId);
	
	 void deleteByUserId(int userId);
	
	boolean existsByUserId(int userId);

}

package com.inm429.ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inm429.ecommerce.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
	 List<Cart> findByUserUserId(Long userId);
}

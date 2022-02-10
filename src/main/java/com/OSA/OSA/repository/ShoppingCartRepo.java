package com.OSA.OSA.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.OSA.OSA.model.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer> {

	@Transactional
	@Modifying
	@Query("delete from shoppingCart c where c.id=:id")
	void deleteArtId(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("delete from shoppingCart")
	void deleteAllart();
}

package com.OSA.OSA.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.OSA.OSA.model.DTO.OrderElasticRequestDto;
import com.OSA.OSA.model.DTO.ProductElasticDto;
import com.OSA.OSA.model.entity.ProductElastic;

@Repository
public interface ProductElasticService {
	
	void index(ProductElasticDto productElasticDto);
	
	void remove(String id);
	
	List<ProductElasticDto> findAll();
	
	List<ProductElasticDto> findByName(String name);
	
	List<ProductElasticDto> findByUsername(String username);
	
	ProductElasticDto findById(String id);
	
	List<ProductElasticDto> findByPriceBetween(double minPrice, double maxPrice);
	
	ProductElastic save(ProductElastic productElasticDto);

}

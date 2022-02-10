package com.OSA.OSA.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.OSA.OSA.model.DTO.ProductElasticDto;
import com.OSA.OSA.model.entity.OrderElastic;
import com.OSA.OSA.model.entity.ProductElastic;

public interface ProductElasticRepo extends ElasticsearchRepository<ProductElastic, String> {
	
	List<ProductElastic> findAll();
	
	List<ProductElastic> findByName(String name);
	
	Optional<ProductElastic> findById(String id);
	
	List<ProductElastic> findByUsername(String username);
	
	List<ProductElastic> findByPriceBetween(double minPrice, double maxPrice);


}

package com.OSA.OSA.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.OSA.OSA.model.DTO.OrderElasticRequestDto;
import com.OSA.OSA.model.entity.OrderElastic;

@Repository
public interface OrderElasticRepo extends ElasticsearchRepository<OrderElastic, String>{
	
	List<OrderElastic> findAll();
	
	List<OrderElastic> findAllByComment(OrderElasticRequestDto comment);
	
	List<OrderElastic> findAllByComment(String comment);
	
	List<OrderElastic> findByRateBetween(int minRate, int maxRate);

}

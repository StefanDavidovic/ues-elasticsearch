package com.OSA.OSA.service;

import java.util.List;

import com.OSA.OSA.model.DTO.OrderElasticRequestDto;
import com.OSA.OSA.model.entity.OrderElastic;


public interface OrderElasticService {

	void index(OrderElasticRequestDto orderElasticDto);
	
	List<OrderElasticRequestDto> findAll();
	
	List<OrderElasticRequestDto> findAllByComment(OrderElasticRequestDto comment);

	List<OrderElasticRequestDto> findAllByComment(String comment);
	
	List<OrderElasticRequestDto> findByRateBetween(int minRate, int maxRate);


}

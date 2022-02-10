package com.OSA.OSA.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OSA.OSA.model.DTO.OrderElasticRequestDto;
import com.OSA.OSA.model.entity.Order;
import com.OSA.OSA.model.entity.OrderElastic;
import com.OSA.OSA.repository.OrderElasticRepo;
import com.OSA.OSA.service.OrderElasticService;

@Service
public class OrderElasticServiceImpl implements OrderElasticService{

	@Autowired
	OrderElasticRepo orderElasticRepo;

	@Override
	public void index(OrderElasticRequestDto orderElasticDto) {
		orderElasticRepo.save(new OrderElastic(orderElasticDto.getDate(), orderElasticDto.isDelivered(), orderElasticDto.getRate(), orderElasticDto.getComment(),orderElasticDto.getPrice(),orderElasticDto.isAnonymousComment(),
				orderElasticDto.isArchivedComment(), orderElasticDto.getUsername()));
	}

	@Override
	public List<OrderElasticRequestDto> findAllByComment(OrderElasticRequestDto comment) {
		List<OrderElasticRequestDto> orders = new ArrayList<OrderElasticRequestDto>();
		
		for (OrderElastic orderElastic : orderElasticRepo.findAllByComment(comment)) {
			orders.add(new OrderElasticRequestDto(orderElastic.getDate(), orderElastic.isDelivered(), orderElastic.getRate(), orderElastic.getComment(), orderElastic.getPrice(), orderElastic.isAnonymousComment(), orderElastic.isArchivedComment(), orderElastic.getUsername()));
		}
		
		return orders;
	}

	@Override
	public List<OrderElasticRequestDto> findAll() {
		List<OrderElasticRequestDto> orders = new ArrayList<OrderElasticRequestDto>();
		
		for (OrderElastic orderElastic : orderElasticRepo.findAll()) {
			orders.add(new OrderElasticRequestDto(orderElastic.getDate(), orderElastic.isDelivered(), orderElastic.getRate(), orderElastic.getComment(), orderElastic.getPrice(), orderElastic.isAnonymousComment(), orderElastic.isArchivedComment(), orderElastic.getUsername()));
		}
		return orders;
	}

	@Override
	public List<OrderElasticRequestDto> findAllByComment(String comment) {
		List<OrderElasticRequestDto> orders = new ArrayList<OrderElasticRequestDto>();
		
		for (OrderElastic orderElastic : orderElasticRepo.findAllByComment(comment)) {
			orders.add(new OrderElasticRequestDto(orderElastic.getDate(), orderElastic.isDelivered(), orderElastic.getRate(), orderElastic.getComment(), orderElastic.getPrice(), orderElastic.isAnonymousComment(), orderElastic.isArchivedComment(), orderElastic.getUsername()));
		}
		
		return orders;
	}

	@Override
	public List<OrderElasticRequestDto> findByRateBetween(int minRate, int maxRate) {
		List<OrderElasticRequestDto> orders = new ArrayList<OrderElasticRequestDto>();
		
		for (OrderElastic orderElastic : orderElasticRepo.findByRateBetween(minRate, maxRate)) {
			orders.add(new OrderElasticRequestDto(orderElastic.getDate(), orderElastic.isDelivered(), orderElastic.getRate(), orderElastic.getComment(), orderElastic.getPrice(), orderElastic.isAnonymousComment(), orderElastic.isArchivedComment(), orderElastic.getUsername()));
		}
		
		return orders;
	}

}

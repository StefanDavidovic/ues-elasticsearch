package com.OSA.OSA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OSA.OSA.model.entity.Order;
import com.OSA.OSA.repository.OrderRepo;
import com.OSA.OSA.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepo orderRepo;
	

	@Override
	public Order findOne(Integer orderId) {
		return orderRepo.findById(orderId).orElse(null);
	}

	@Override
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	@Override
	public Order save(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public void remove(Integer id) {
		orderRepo.deleteById(id);
		
	}

}

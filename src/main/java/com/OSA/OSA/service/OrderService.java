package com.OSA.OSA.service;

import java.util.List;

import com.OSA.OSA.model.entity.Order;


public interface OrderService {
	
    Order findOne(Integer orderId);
    
    List<Order> findAll();

    Order save(Order order);

    void remove(Integer id);

}

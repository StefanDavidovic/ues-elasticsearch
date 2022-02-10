package com.OSA.OSA.service;

import java.util.List;

import com.OSA.OSA.model.entity.ShoppingCart;


public interface ShoppingCartService {

    ShoppingCart findOne(Integer cartId);
    
    List<ShoppingCart> findAll();

    ShoppingCart save(ShoppingCart cartItem);

    void remove(Integer id);
    
    void removeAll();
}

package com.OSA.OSA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OSA.OSA.model.entity.ShoppingCart;
import com.OSA.OSA.repository.ProductRepo;
import com.OSA.OSA.repository.ShoppingCartRepo;
import com.OSA.OSA.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
    @Autowired
    ShoppingCartRepo cartRepository;

	@Override
	public ShoppingCart findOne(Integer cartId) {
		return cartRepository.findById(cartId).orElse(null);
	}

	@Override
	public List<ShoppingCart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public ShoppingCart save(ShoppingCart cartItem) {
		return cartRepository.save(cartItem);
	}

	@Override
	public void remove(Integer id) {
		cartRepository.deleteArtId(id);
		
	}

	@Override
	public void removeAll() {
		cartRepository.deleteAllart();
		
	}

}

package com.OSA.OSA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OSA.OSA.model.entity.Item;
import com.OSA.OSA.repository.ItemRepo;
import com.OSA.OSA.repository.OrderRepo;
import com.OSA.OSA.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepo itemRepo;
	
	@Override
	public Item findOne(Integer itemId) {
		return itemRepo.findById(itemId).orElse(null);

	}

	@Override
	public List<Item> findAll() {
		return itemRepo.findAll();

	}

	@Override
	public Item save(Item item) {
		return itemRepo.save(item);

	}

	@Override
	public void remove(Integer id) {
		itemRepo.deleteById(id);
		
	}
	
	

}

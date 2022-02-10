package com.OSA.OSA.service;

import java.util.List;

import com.OSA.OSA.model.entity.Item;
import com.OSA.OSA.model.entity.Order;

public interface ItemService {
    Item findOne(Integer itemId);
    
    List<Item> findAll();

    Item save(Item item);

    void remove(Integer id);

}

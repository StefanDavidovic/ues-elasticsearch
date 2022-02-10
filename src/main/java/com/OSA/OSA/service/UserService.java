package com.OSA.OSA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OSA.OSA.model.entity.Order;
import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.model.entity.User;


public interface UserService {
	
    User findByUsernameAndPassword(String username, String password);

    List<User> findAll();

    void add(User user);
    User findOne(Integer userId);
    User findByUsername(String username);
    void remove(Integer id);
    User save(User user);


}

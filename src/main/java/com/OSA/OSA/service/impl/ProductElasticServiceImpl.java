package com.OSA.OSA.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OSA.OSA.model.DTO.OrderElasticRequestDto;
import com.OSA.OSA.model.DTO.ProductElasticDto;
import com.OSA.OSA.model.entity.ProductElastic;
import com.OSA.OSA.model.entity.User;
import com.OSA.OSA.repository.OrderElasticRepo;
import com.OSA.OSA.repository.ProductElasticRepo;
import com.OSA.OSA.repository.ProductRepo;
import com.OSA.OSA.repository.UserRepo;
import com.OSA.OSA.service.ProductElasticService;

@Service
public class ProductElasticServiceImpl implements ProductElasticService {
	
	@Autowired
	ProductElasticRepo productElasticRepo;
	
	@Autowired
	UserRepo usersRepo;

	@Override
	public List<ProductElasticDto> findAll() {
		List<ProductElasticDto> orders = new ArrayList<ProductElasticDto>();
		
		for (ProductElastic productElasticDto : productElasticRepo.findAll()) {
			orders.add(new ProductElasticDto(productElasticDto.getId(),productElasticDto.getName(), productElasticDto.getDescription(), productElasticDto.getPrice(),productElasticDto.getUsername()));
			
		}
		return orders;
	}

	@Override
	public List<ProductElasticDto> findByName(String name) {
		List<ProductElasticDto> orders = new ArrayList<ProductElasticDto>();
		
		for (ProductElastic productElasticDto : productElasticRepo.findByName(name)) {
			orders.add(new ProductElasticDto(productElasticDto.getId(),productElasticDto.getName(), productElasticDto.getDescription(), productElasticDto.getPrice(),productElasticDto.getUsername()));
		}
		
		return orders;
	}
	@Override
	public List<ProductElasticDto> findByPriceBetween(double minPrice, double maxPrice) {
		List<ProductElasticDto> orders = new ArrayList<ProductElasticDto>();
		
		for (ProductElastic productElasticDto : productElasticRepo.findByPriceBetween(minPrice, maxPrice)) {
			orders.add(new ProductElasticDto(productElasticDto.getId(),productElasticDto.getName(), productElasticDto.getDescription(), productElasticDto.getPrice(),productElasticDto.getUsername()));
			
		}
		
		return orders;
	}

	@Override
	public void index(ProductElasticDto productElasticDto) {
		productElasticRepo.save(new ProductElastic(productElasticDto.getName(), productElasticDto.getDescription(), productElasticDto.getPrice(), productElasticDto.getUsername()));
		System.out.println(productElasticDto.getUsername().toString() + " ovo je u servisu");
	}

	@Override
	public ProductElasticDto findById(String id) {
		ProductElasticDto product = new ProductElasticDto();
		for (ProductElastic productElasticDto : productElasticRepo.findAll()) {
			if(id.equals(productElasticDto.getId())) {
				System.out.println("TUJ SAM");
				return product =  new ProductElasticDto(productElasticDto.getId(),productElasticDto.getName(), productElasticDto.getDescription(), productElasticDto.getPrice(),productElasticDto.getUsername());
			}else {
				System.out.println("2TUJ SAM");
			}
			
		}
		return product;
	}

	@Override
	public ProductElastic save(ProductElastic productElasticDto) {
		return productElasticRepo.save(productElasticDto);
	}

	@Override
	public void remove(String id) {
		productElasticRepo.deleteById(id);
		
	}

	@Override
	public List<ProductElasticDto> findByUsername(String username) {
		List<ProductElasticDto> orders = new ArrayList<ProductElasticDto>();
		
		for (ProductElastic productElasticDto : productElasticRepo.findByUsername(username)) {
			orders.add(new ProductElasticDto(productElasticDto.getId(),productElasticDto.getName(), productElasticDto.getDescription(), productElasticDto.getPrice(),productElasticDto.getUsername()));
			
		}
		
		return orders;
		 
	}

}

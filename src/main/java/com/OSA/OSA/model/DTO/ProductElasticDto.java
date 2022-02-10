package com.OSA.OSA.model.DTO;

import java.math.BigDecimal;

public class ProductElasticDto {
	
	private String id;
	
    private String name;

    private String description;

    private BigDecimal price;
    
    private String username;

	public ProductElasticDto(String id,String name, String description, BigDecimal price,String username) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.username=username;
	}
	
	public ProductElasticDto(String name, String description, BigDecimal price,String username) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.username=username;
	}
	
	public ProductElasticDto(String id,String name, String description, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public ProductElasticDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}
	

}

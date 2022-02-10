package com.OSA.OSA.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName="productsss")
@Setting(settingPath= "/analyzers/customAnalyzer.json")
public class ProductElastic {
	
    @Id
    private String id;

	@Field(type = FieldType.Text)
    private String name;

	@Field(type = FieldType.Text)
    private String description;

	@Field(type = FieldType.Double)
    private BigDecimal price;
	
	@Field(type = FieldType.Keyword)
	private String username;
	

	public ProductElastic(String id, String name, String description, BigDecimal price,String username) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.username=username;
	}
	
//	public ProductElastic(String id, String name, String description, BigDecimal price) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.description = description;
//		this.price = price;
//	}

	public ProductElastic(String name, String description, BigDecimal price,String username) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.username=username;
	}
	
//	public ProductElastic(String name, String description, BigDecimal price) {
//		super();
//		this.name = name;
//		this.description = description;
//		this.price = price;
//	}

	public ProductElastic() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

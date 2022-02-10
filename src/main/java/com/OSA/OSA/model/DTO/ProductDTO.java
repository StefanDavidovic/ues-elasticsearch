package com.OSA.OSA.model.DTO;

import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.Lob;

import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.model.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class ProductDTO {

    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;
    
    @Lob
//    private String image_src;
    
    private UserDTO userr;
    
    public ProductDTO() {
    }

	public ProductDTO(Integer id, String name, String description, BigDecimal price, UserDTO userr) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
//		this.image_src = image_src;
		this.userr = userr;
	}
	
	public ProductDTO(String name, String description, BigDecimal price, UserDTO userr) {
		this.name = name;
		this.description = description;
		this.price = price;
//		this.image_src = image_src;
		this.userr = userr;
	}
	
    public ProductDTO(Product product) {
        this(product.getId(), product.getName(),
                product.getDescription(), product.getPrice(), new UserDTO(product.getUser()));
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
//	@JsonIgnore
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

//	public String getImage_src() {
//		return image_src;
//	}
//	
////    @JsonProperty("image_src")
//	public void setImage_src(String image_src) {
//		this.image_src = image_src;
//	}

	public UserDTO getUserr() {
		return userr;
	}

	public void setUserr(UserDTO userr) {
		this.userr = userr;
	}
	
	
    
    
}

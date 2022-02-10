package com.OSA.OSA.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Identity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "prod_name", unique = false, nullable = false)
    private String name;

    @Column(name = "description", unique = false, nullable = false)
    private String description;

    @Column(name = "price", unique = false, nullable = false)
    private BigDecimal price;
    
    @OneToOne(mappedBy = "product",cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private ShoppingCart shoppingCart;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

    public Product() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

//	public String getImage_src() {
//		return image_src;
//	}
	
//	@JsonProperty("name")
//	public void setImage_src(byte[] image_src) {
//		this.image_src = image_src;
//	}

//	public void setImage_src(String image_src) {
//		this.image_src = image_src;
//		
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
    
    
    
}

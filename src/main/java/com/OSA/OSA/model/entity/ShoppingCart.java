package com.OSA.OSA.model.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="shoppingCart")
@Table(name = "shoppingCart")
public class ShoppingCart {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", unique = true, nullable = false)
    private Integer id;
    
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "qty",nullable = false)
    private Integer qty;
    
    @Column(name = "price", unique = false, nullable = false)
    private BigDecimal price;
    

	public ShoppingCart() {
	}


	public ShoppingCart(Integer id, Product product_id, Integer qty, BigDecimal price) {
		super();
		this.id = id;
		this.product = product_id;
		this.qty = qty;
		this.price = price;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct_id() {
		return product;
	}

	public void setProduct_id(Product product_id) {
		this.product = product_id;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
	
    
    
    
}

package com.OSA.OSA.model.DTO;

import java.math.BigDecimal;

import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.model.entity.ShoppingCart;

public class ShoppingCartDTO {
	
	private Integer id;
	private ProductDTO product_id;
	private Integer qty;
	private BigDecimal price;
	
	public ShoppingCartDTO() {
		super();
	}
	public ShoppingCartDTO(Integer id,ProductDTO product_id, Integer qty, BigDecimal price) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.qty = qty;
		this.price = price;
	}
	
    public ShoppingCartDTO(ShoppingCart shoppingCart) {
        this(shoppingCart.getId(),new ProductDTO(shoppingCart.getProduct_id()), shoppingCart.getQty(),
        		shoppingCart.getPrice());
    }
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductDTO getProduct_id() {
		return product_id;
	}
	public void setProduct_id(ProductDTO product_id) {
		this.product_id = product_id;
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

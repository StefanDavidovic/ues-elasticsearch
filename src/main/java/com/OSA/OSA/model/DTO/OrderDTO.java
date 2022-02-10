package com.OSA.OSA.model.DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.OSA.OSA.model.entity.Item;
import com.OSA.OSA.model.entity.Order;
import com.OSA.OSA.model.entity.ShoppingCart;

public class OrderDTO {
	
	private Integer id;
	private Timestamp date;
	private boolean delivered;
	private Integer rate;
	private String comment;
	private boolean anonymousComment;
	private boolean archivedComment;
	private List<Item> items;
	
	public OrderDTO() {
		super();
	}

	public OrderDTO(Integer id, Timestamp date, boolean delivered, Integer rate, String comment,
			boolean anonymousComment, boolean archivedComment, List<Item> items) {
		super();
		this.id = id;
		this.date = date;
		this.delivered = delivered;
		this.rate = rate;
		this.comment = comment;
		this.anonymousComment = anonymousComment;
		this.archivedComment = archivedComment;
		this.items = items;
	}
	
    public OrderDTO(Order order) {
        this(order.getId(),order.getDate(), order.isDelivered(),
        		order.getRate(), order.getComment(), order.isAnonymousComment(),order.isArchivedComment(), order.getItems());
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isAnonymousComment() {
		return anonymousComment;
	}

	public void setAnonymousComment(boolean anonymousComment) {
		this.anonymousComment = anonymousComment;
	}

	public boolean isArchivedComment() {
		return archivedComment;
	}

	public void setArchivedComment(boolean archivedComment) {
		this.archivedComment = archivedComment;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
    
    

}

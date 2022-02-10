package com.OSA.OSA.model.DTO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class OrderElasticRequestDto {
	
//	private String id;
	
	private LocalDate date;
    
	private boolean delivered;
    
	private int rate;
	
	private String comment;
    
    private BigDecimal price;
    
	private boolean anonymousComment;
    
	private boolean archivedComment;
	
	private String username;

	public OrderElasticRequestDto() {
		super();
	}

	public OrderElasticRequestDto(LocalDate date, boolean delivered, int rate, String comment, BigDecimal price,
			boolean anonymousComment, boolean archivedComment, String username) {
		super();
//		this.id = id;
		this.date = date;
		this.delivered = delivered;
		this.rate = rate;
		this.comment = comment;
		this.price = price;
		this.anonymousComment = anonymousComment;
		this.archivedComment = archivedComment;
		this.username = username;
	}
	
	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}

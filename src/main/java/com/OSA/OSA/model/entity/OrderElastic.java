package com.OSA.OSA.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.elasticsearch.search.DocValueFormat.DateTime;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName="orders2")
@Setting(settingPath= "/analyzers/customAnalyzer.json")
public class OrderElastic {
	
    @Id
	private String id;
    
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "uuuu-MM-dd")
	private LocalDate date;
    
    @Field(type = FieldType.Boolean)
	private boolean delivered;
    
	@Field(type = FieldType.Integer)
	private int rate;
	
	@Field(type = FieldType.Text)
	private String comment;
    
	@Field(type = FieldType.Double)
    private BigDecimal price;
    
	@Field(type = FieldType.Boolean)
	private boolean anonymousComment;
    
	@Field(type = FieldType.Boolean)
	private boolean archivedComment;
	
	@Field(type = FieldType.Keyword)
	private String username;

	public OrderElastic(LocalDate date, boolean delivered, int rate, String comment, BigDecimal price,
			boolean anonymousComment, boolean archivedComment, String username) {
		super();
		this.date = date;
		this.delivered = delivered;
		this.rate = rate;
		this.comment = comment;
		this.price = price;
		this.anonymousComment = anonymousComment;
		this.archivedComment = archivedComment;
		this.username = username;
	}

	public OrderElastic() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

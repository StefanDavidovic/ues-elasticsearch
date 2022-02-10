package com.OSA.OSA.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
@Document(indexName="orders")
public class Order implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
	private Integer id;
    
    @Column(name = "date", unique = true, nullable = false)
	private Timestamp date;
    
    @Column(name = "delivered", unique = true, nullable = false)
	private boolean delivered;
    
    @Column(name = "rate", unique = true, nullable = false)
	private Integer rate;
    
    @Column(name = "comment", unique = true, nullable = false)
	private String comment;
    
    @Column(name = "price", unique = false, nullable = false)
    private BigDecimal price;
    
    @Column(name = "anonymousComment", unique = true, nullable = false)
	private boolean anonymousComment;
    
    @Column(name = "archivedComment", unique = true, nullable = false)
	private boolean archivedComment;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    @JsonIgnore
    private List<Item> items = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private User user;

	public Order() {
		super();
	}

	public Order(Integer id, Timestamp date, boolean delivered, Integer rate, String comment, boolean anonymousComment,
			boolean archivedComment, List<Item> items) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	

    
    
    
}

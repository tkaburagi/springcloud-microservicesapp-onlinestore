package com.example;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@SuppressWarnings("serial")
@Entity
@Table(name="orderhistory")
@NamedQuery(name="Orderhistory.findAll", query="SELECT o FROM Orderhistory o where o.username like :username")
public class Orderhistory implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
    
	@Column(nullable = false)
	private String product;
    
	@Column(nullable = false)
	private String username;
	
	public Orderhistory() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

package com.example.entity;

import java.io.Serializable;

public class Orderhistory implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
    
	private String product;
    
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

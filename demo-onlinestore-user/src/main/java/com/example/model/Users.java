package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SuppressWarnings("serial")
@JsonSerialize 
@Entity
@Table(name="users")
public class Users implements Serializable{
	 
    @Id
    @GeneratedValue
    private int id;
 
    @Column(nullable = false)
    private String name;
 
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private int mobile;
    
    @Column(nullable = false)
    private String company;
    
    @Column(nullable = false)
    private String cardnumber;

    @Column(nullable = false)
    private String fullname;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
    
    
}

package com.example.entity;

import java.io.Serializable;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	 
    public String name;
 
    private String category;
 
    private long price;
    
//	private SerialBlob pic;

	public int getId() {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

//	public SerialBlob getPic() {
//		return pic;
//	}
//
//	public void setPic(SerialBlob pic) {
//		this.pic = pic;
//	}
}

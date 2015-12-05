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
@Table(name="product")
public class Product implements Serializable {
//	    private static final long serialVersionUID = 1L;
	 
	    @Id
	    @GeneratedValue
	    private int id;
	 
	    @Column(nullable = false)
	    private String name;
	 
	    @Column(nullable = false)
	    private String category;
	 
	    @Column(nullable = false)
	    private long price;
	    
//	    @Column(nullable = false)
//		private Blob pic;
//
//		public Blob getPic() {
//			return pic;
//		}
//
//		public void setPic(Blob pic) {
//			this.pic = pic;
//		}

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

}


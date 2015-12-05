package com.example.repositry;

import javax.inject.Named;

import org.springframework.stereotype.Repository;

import com.example.entity.PagedProduct;

@Repository
public interface PrdRepository {
//	    @RequestLine("GET /products?page={page}&size={size}")    
	public PagedProduct findAll(@Named("page") Integer page, @Named("size") Integer size);

	
}

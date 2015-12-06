package com.example.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.model.Product;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface PrdRepository extends PagingAndSortingRepository<Product, Long>{
	// @RequestLine("GET /products?page={page}&size={size}")
	public Page<Product> findAll(Pageable pageable);

	// @RestResource(exported = false)
	// Product findById(int id);
	//
	// @RestResource(path = "name", rel = "name")
	// Page<Product> findByNameIgnoreCase(@Param("q") String name, Pageable
	// pageable);

}
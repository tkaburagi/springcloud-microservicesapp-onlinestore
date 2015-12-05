package com.example.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.model.Users;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends PagingAndSortingRepository<Users, Integer>{
	public Page<Users> findAll(Pageable pageable);
	public Users findByName(String name);

}

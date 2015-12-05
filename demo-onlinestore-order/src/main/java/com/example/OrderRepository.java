package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@RepositoryRestResource(collectionResourceRel = "order", path = "order")
public interface OrderRepository extends PagingAndSortingRepository<Orderhistory, Integer> {
//	public Page<Order> findAll(Pageable pageable);
	//By.... はOrderエンティティのプロパティとリンクする
//	public List<Order> findByUsernameContainsOrderByIdAsc(String username);
	@Query(name="Orderhistory.findAll")
	public List<Orderhistory> findByNamedQuery(@Param("username") String username);

}

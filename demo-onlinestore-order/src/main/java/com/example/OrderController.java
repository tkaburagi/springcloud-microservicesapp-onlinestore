package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@JsonSerialize
@RestController
public class OrderController {
	
	@Autowired
	OrderRepository repo;
	
	@HystrixCommand
	@RequestMapping("/showorder")
	public List<Orderhistory> showOrder(@RequestParam("username") String username) {
		return repo.findByNamedQuery(username);
	}
	
	@HystrixCommand
	@RequestMapping("/showall")
	public Iterable<Orderhistory> showAll() {
		return repo.findAll();
	}
	
	@HystrixCommand
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public Orderhistory save(@RequestBody Orderhistory order) {
		return repo.save(order);
	}
}

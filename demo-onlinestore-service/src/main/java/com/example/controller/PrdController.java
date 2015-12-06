package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.repo.PrdRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@JsonSerialize
@RestController
@Component
public class PrdController {

	@Autowired
	private PrdRepository repo;

	@HystrixCommand
	@RequestMapping("/")
	public Iterable<Product> getAllPrds() {
		return repo.findAll();
	}
	
	@HystrixCommand
	@RequestMapping("/kill")
	public String kill() {
		System.exit(-1);
		return "killed!";
	}

}

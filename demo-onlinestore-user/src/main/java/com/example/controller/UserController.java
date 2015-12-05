package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Users;
import com.example.repo.UserRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@JsonSerialize
@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;

	@RequestMapping("/login")
	@HystrixCommand
	public Users getOneUser(@RequestParam("name") String name) {
//		return repo.findAll();
		return repo.findByName(name);
	}
}

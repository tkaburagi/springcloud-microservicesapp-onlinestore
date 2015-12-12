package com.example.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Product;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ServiceClient {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Autowired
	DiscoveryClient discoveryClient;

	@HystrixCommand
	public Product[] getProducts() throws JsonParseException, JsonMappingException, IOException {
		InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("ONLINESTORE-SERVICE", false);
		restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(instanceInfo.getHomePageUrl(), String.class);
		ObjectMapper mapper = new ObjectMapper();
		Product[] prd = mapper.readValue(result, Product[].class);
		return prd;
	}
}

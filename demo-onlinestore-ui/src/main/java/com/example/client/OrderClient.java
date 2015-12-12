package com.example.client;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entity.Orderhistory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class OrderClient {
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Autowired
	DiscoveryClient discoveryClient;
	
	@HystrixCommand
	public Orderhistory[] getOrderByUser(String username) throws JsonParseException, JsonMappingException, IOException {
		InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("ONLINESTORE-ORDER", false);
		restTemplate = new RestTemplate();
		String targetUrl = UriComponentsBuilder.fromUriString(instanceInfo.getHomePageUrl())
				.path("showall")
				.queryParam("username", username)
				.build()
				.toString();
		String result = restTemplate.getForObject(targetUrl, String.class);
		ObjectMapper mapper = new ObjectMapper();
		Orderhistory[] orderhistory = mapper.readValue(result, Orderhistory[].class);
		return orderhistory;
	}
	

	@HystrixCommand
	public void saveOrder(Orderhistory order) {
		InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("ONLINESTORE-ORDER", false);
		restTemplate = new RestTemplate();
		String targetUrl = UriComponentsBuilder.fromUriString(instanceInfo.getHomePageUrl())
				.path("/buy/")
				.build()
				.toString();
		restTemplate.postForObject(targetUrl, order, Orderhistory.class);
	}

}

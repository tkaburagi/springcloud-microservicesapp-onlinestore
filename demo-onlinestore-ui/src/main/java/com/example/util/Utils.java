package com.example.util;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class Utils {
	
	@SuppressWarnings("rawtypes")
	@HystrixCommand
	public Map getVCAP() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map vcapMap = mapper.readValue(System.getenv("VCAP_APPLICATION"), Map.class);
		return vcapMap;
	}
	
	@HystrixCommand
	public String returnLogin() {
		return "onlinestore/login";
	}
}

package com.example.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entity.Orderhistory;
import com.example.entity.Product;
import com.example.entity.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@Controller
public class UiContoller {

	@Autowired
	DiscoveryClient discoveryClient;

//	HttpSession session;
	
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
	
	@HystrixCommand
	@RequestMapping("/")
	public String login() {
		return returnLogin();
	}
	
	@HystrixCommand
	@RequestMapping("/kill")
	public String kill(){
		System.exit(-1);
		return returnLogin();
	}
	
	@HystrixCommand
	public String returnLogin() {
		return "onlinestore/login";
	}
	
	@HystrixCommand
	@RequestMapping("/auth")
	public String authUser(@RequestParam("user") String user, HttpSession session, Model model) throws JsonParseException, JsonMappingException, IOException {
		session.setAttribute("userid", getUserInfo(user).getId());
		session.setAttribute("username", getUserInfo(user).getName());
		session.setAttribute("address", getUserInfo(user).getAddress());
		session.setAttribute("mobile", getUserInfo(user).getMobile());
		session.setAttribute("company", getUserInfo(user).getCompany());
		session.setAttribute("cardnumber", getUserInfo(user).getCardnumber());
		session.setAttribute("fullname", getUserInfo(user).getFullname());			
		System.out.println(session);
		model.addAttribute("prds", getProducts());
		return "onlinestore/index";
	}
	
	@HystrixCommand
	public Product[] getProducts() throws JsonParseException, JsonMappingException, IOException {
		InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("ONLINESTORE-SERVICE", false);
		restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(instanceInfo.getHomePageUrl(), String.class);
		ObjectMapper mapper = new ObjectMapper();
		Product[] prd = mapper.readValue(result, Product[].class);
		return prd;
	}
	
	@HystrixCommand
	public User getUserInfo(String username) throws JsonParseException, JsonMappingException, IOException {
		InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("ONLINESTORE-USER", false);
		restTemplate = new RestTemplate();
		String targetUrl = UriComponentsBuilder.fromUriString(instanceInfo.getHomePageUrl())
				.path("/login/")
				.queryParam("name", username)
				.build()
				.toString();
		String result = restTemplate.getForObject(targetUrl, String.class);
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(result, User.class);
		return user;
	}
	@HystrixCommand
	@RequestMapping("/menu")
	public String menu(Model model, HttpSession session) throws JsonParseException, JsonMappingException, IOException{
  		model.addAttribute("order", getOrderByUser(session.getAttribute("username").toString()));
		return "onlinestore/menu";
	}
	
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
	@RequestMapping("/javainfo")
	public String getJavaInfo(Model model) throws JsonParseException, JsonMappingException, IOException{
//		System.out.println(session.getAttribute("username"));
		model.addAttribute("vcap_app", getVCAP());
		return "onlinestore/javainfo";	
	}
	
	@SuppressWarnings("rawtypes")
	@HystrixCommand
	public Map getVCAP() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map vcapMap = mapper.readValue(System.getenv("VCAP_APPLICATION"), Map.class);
		return vcapMap;
	}
	
	
	@HystrixCommand
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(HttpServletRequest request, HttpSession session, Orderhistory order, Model model) {
		order.setUsername(session.getAttribute("username").toString());
		order.setProduct(request.getParameter("product"));
		saveOrder(order);
		return "onlinestore/thankyou";
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

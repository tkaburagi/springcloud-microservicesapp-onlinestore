# Circuit Breaker Demonstraion

## Pre-requisite
* Four applications are running
* All apps are bound to circuit breaker services
* Read basic information
  * [Netflix OSS Hystrix and Turbine](http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html)
  * [Pivotal Spring Cloud Circuit Breaker](http://docs.pivotal.io/spring-cloud-services/circuit-breaker/)

## Implementation
Configurations
```java
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
@EnableCircuitBreaker  // <- this is for circuit breaker
public class DemoOnlineStoreUiApplicationConfiguration {

}
```
HystrixCommand.
```java
@HystrixCommand(fallbackMethod = "fallbackAuthUser")
@RequestMapping("/auth")
	public String authUser(@RequestParam("user") String user, HttpSession session, Model model) throws JsonParseException, JsonMappingException, IOException {
		if(session == null) {
			return returnLogin();
		}
		session.setAttribute("userid", getUserInfo(user).getId());
~
```
```java
private String fallbackAuthUser(@RequestParam("user") String user, HttpSession session, Model model) throws JsonParseException, JsonMappingException, IOException {
        System.out.println("#####FALLBACKED!!#####");
        ObjectMapper mapper = new ObjectMapper();
        Product prd = new Product();
        prd.setCategory("Error");
        prd.setName("Error");
        prd.setPrice(000000);
        model.addAttribute("prds", prd);
        return "onlinestore/index";
    }
```

## Demonstration
1. Access to each page.
2. See dashboard.
![cb](https://github.com/tkaburagi1214/springcloud-microservicesapp-onlinestore/blob/master/assets/cb.png)

3. Stop backend app, "demo-onlinestore-service"
```bash
cf stop demo-onlinestore-service
```
4. Login
5. Confirm fallback method is running.
If you do not have a fallback method, a server error occurs and entire service is down. However, with fallback method service, you can still access to application and use other functions! 
![cb1](https://github.com/tkaburagi1214/springcloud-microservicesapp-onlinestore/blob/master/assets/Screen%20Shot%202015-12-12%20at%2018.37.47.png)
![cb2](https://github.com/tkaburagi1214/springcloud-microservicesapp-onlinestore/blob/master/assets/Screen%20Shot%202015-12-12%20at%2018.37.55.png)

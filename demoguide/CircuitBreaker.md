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
@HystrixCommand
@RequestMapping("/auth")
	public String authUser(@RequestParam("user") String user, HttpSession session, Model model) throws JsonParseException, JsonMappingException, IOException {
		if(session == null) {
			return returnLogin();
		}
		session.setAttribute("userid", getUserInfo(user).getId());
~
```

## Demonstration
**Fallback method is still being implemented.. Enjoy only Hystrix dashboard and Turbine.**

1. Access each page.
2. See dashboard.
![cb](https://github.com/tkaburagi1214/springcloud-microservicesapp-onlinestore/blob/master/assets/cb.png)

3. Stop backend app, "demo-onlinestore-service"
4. Confirm fallback method is running.

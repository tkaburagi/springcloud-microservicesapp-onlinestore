# Registry Server Demonstration
## Pre-requisite
 * Four applications are running
 * All apps are bound to regitry server services 
 * Read basic information
  * [Netflix OSS Eureka](http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html)
  * [Pivotal Spring Cloud Registry Server](http://docs.pivotal.io/spring-cloud-services/service-registry/)

## 1. Implementation
Dependencies
```xml
<parent>
	<groupId>io.pivotal.spring.cloud</groupId>
	<artifactId>spring-cloud-services-starter-parent</artifactId>
	<version>1.0.1.RELEASE</version>
	<relativePath /> <!-- lookup parent from repository -->
</parent>
~
<dependency>
	<groupId>io.pivotal.spring.cloud</groupId>
	<artifactId>spring-cloud-services-starter-config-client</artifactId>
</dependency>
```
bootstrap.yml
```yml
spring:
  application:
    name: onlinestore-ui
```
Java configuration
```java
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DemoOnlineStoreUiApplicationConfiguration {
}
```

Example of using Eureka server. No need host, ip address and port etc.. Just lookup service name!
```java
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
```

## 2. Registry Server Dashboard
You can see status of microservices in a nice dashboard
![Dashboard](https://github.com/tkaburagi1214/springcloud-microservicesapp-onlinestore/blob/master/assets/registrydb.png)


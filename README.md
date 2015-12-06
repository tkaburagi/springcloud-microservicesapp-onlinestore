# springcloud-microservicesapp-onlinestore

This is a Microservice application for Pivotal Cloud Foundry. Microsevices and 12 Factor Application elements are implemented. This is a very good an application for demonstration. This can run outside PCF using OSS Netflix but some changes and additinal development are needed. **This app was developed for very short term. Some error handling is not yet implemented and also refactoring is highly required. Authentication is actually fake :)**

## Pre-requisite
This application requires five PCF services.
* MySQL for PCF (Datastore) : http://docs.pivotal.io/p-mysql/index.html
 * Service Name : mysql (depends on manifest.yml) 
* Redis for PCF (HTTP Session Store) : http://docs.pivotal.io/redis/index.html
 * Service Name : sessoion-replication (Fix)
  * Why should be the name fixed? -> https://github.com/cloudfoundry/java-buildpack/blob/master/docs/container-tomcat.md 
* Pivotal Spring Cloud Services : http://docs.pivotal.io/spring-cloud-services/index.html
  * Config Server (Config Server)
   * Service Name : scs-config-server (depends on manifest.yml) 
  * Circuit Breaker (Netflix Hystrix and Turbine)
   * Service Name : scs-circuit-breaker (depends on manifest.yml) 
  * Registry Server (Netflix Eureka and Feign)
   * Service Name : scs-registry-server (depends on manifest.yml) 

Also, having Sumo Logic account information is desired but not mandtory.

## Build & Push
```bash
  $ git clone https://github.com/tkaburagi1214/springcloud-microservicesapp-onlinestore.git
  $ cd springcloud-microservicesapp-onlinestore
  $ mvn package
  $ cf push
````
**It might take several minutes to work fine. This is for Eureka discovery time.**

## Application Architecture
This Service has four applications, ui, service, user and order.
![Architecture](https://github.com/tkaburagi1214/springcloud-microservicesapp-onlinestore/blob/master/Architecture.png)

## Tour
This is a simple online store app.
* Login
 * Default users are "testuser", "tkabruagi" and "robmee"
 * Password is fake. You can put any value.
 * If you would like to change or add new users, you woud edit "import.aql" in **demo-onlinestore-user**
 * After login, creating session and retrieve products via **demo-onlinestore-service**.

* Home
 * You can see products list. Checkout button insert the product into orderhistrory table by **demo-onlinestore-order**

* Menu
 * You can get account information via HTTP session and orderhistory via **demo-onlinestore-order**.
 
* Java Information
 * Showing Environmental Information and current user via HTTP session. This is a good tool to show session is stored in Redis.

* Kill Application
 * This causes System.exit(-1) which reproduces JVM accidental shutdown.

* Search 
 * Not implemented yet. Comming soon, I believe... 
 
## Demonstration
###1. Registry Server
###2. Circuit Breaker
###3. Config Server
###4. HTTP Session Redundancy by Redis
###5. Application Auto-recovery and Auto Load Brancing
###6. Log Streaming

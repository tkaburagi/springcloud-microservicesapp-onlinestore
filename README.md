# springcloud-microservicesapp-onlinestore

This is a Microservice application for Pivotal Cloud Foundry. Microsevices and 12 Factor Application elements are implemented. This is a very good an application for demonstration. This can run on outside PCF using OSS Netflix but Some changes and additinal development are needed. *This app was developmed for very short term. Some error handling is not yet implemented and refactoring is highly needed. Take care to user:)*

# Pre-requisite
This application requires five PCF services.
* MySQL for PCF (Datastore) : http://docs.pivotal.io/p-mysql/index.html
 * Service Name : mysql (depends on manifest.yml) 
* Redis for PCF (HTTP Session Store) : http://docs.pivotal.io/redis/index.html
 * Service Name : sessoion-replication (Fix)
  * Why is the name fixed? -> https://github.com/cloudfoundry/java-buildpack/blob/master/docs/container-tomcat.md 
* Pivotal Spring Cloud Services : http://docs.pivotal.io/spring-cloud-services/index.html
  * Config Server (Config Server)
   * Service Name : scs-config-server (depends on manifest.yml) 
  * Circuit Breaker (Netflix Hystrix and Turbine)
   * Service Name : scs-circuit-breaker (depends on manifest.yml) 
  * Registry Server (Netflix Eureka and Feign)
   * Service Name : scs-registry-server (depends on manifest.yml) 

# Build
 git clone https://github.com/tkaburagi1214/springcloud-microservicesapp-onlinestore.git
 cd springcloud-microservicesapp-onlinestore
 mvn package

# 

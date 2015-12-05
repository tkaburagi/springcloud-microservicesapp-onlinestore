# springcloud-microservicesapp-onlinestore

This is a Microservice application for Pivotal Cloud Foundry. Microsevices and 12 Factor Application elements are implemented. This is a very good an application for demonstration.

# Pre-requisite
This application requires four services. Refer to Pivotal Documents.
* MySQL for PCF (Datastore) : http://docs.pivotal.io/p-mysql/index.html
 * Service Name : mysql (depends on manifest.yml) 
* Redis for PCF (HTTP Session Store) : http://docs.pivotal.io/redis/index.html
 * Service Name : sessoion-replication (Fix)
* Spring Cloud Services : http://docs.pivotal.io/spring-cloud-services/index.html
  * Config Server (Config Server)
   * Service Name : scs-config-server (depends on manifest.yml) 
  * Circuit Breaker (Netflix Hystrix and Turbine)
   * Service Name : scs-circuit-breaker (depends on manifest.yml) 
  * Registry Server (Netflix Eureka and Feign)
   * Service Name : scs-registry-server (depends on manifest.yml) 
  


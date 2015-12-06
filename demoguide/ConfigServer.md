# Config Server Demonstration

##Pre-requisite
 * Confirm four applications running
 * Confirm demo-onlinestore-ui app is bound to Pivotal Config Server
 * Read basic information
  * [Pivotal Spring Cloud Config Server](http://docs.pivotal.io/spring-cloud-services/config-server/)
 * Create Github repository for storing configurations. e.g. [config](https://github.com/tkaburagi1214/config)
 * Create application.yml file in config repository and add below lines and restart demo-onlinestore-ui.

```yml
security:
  basic:
    enabled: true
management:
  security:
    enabled: true
```
 
##1. Creating Config Server


##2. How to demostration
1. 

# Config Server Demonstration

##Pre-requisite
 * Four applications are running
 * A demo-onlinestore-ui app is bound to Pivotal Config Server
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
 * Follow the [guide](http://docs.pivotal.io/spring-cloud-services/config-server/creating-an-instance.html)

##2. How to demostration
1. Access to demo-onlinestore-ui app and the app request basic authentication. This is because application.yml setting.
2. Edit application.yml.
```yml
security:
  basic:
    enabled: false
management:
  security:
    enabled: false
```
3. Restart app and access again. Basic authentication is not required. Configuration is injected with no re-build, re-complie and re-deploy! Configuration is distributed by config server.

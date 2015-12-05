package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan
@Import(RepositoryRestMvcConfiguration.class)
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DemoOnlinestoreOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOnlinestoreOrderApplication.class, args);
    }
}

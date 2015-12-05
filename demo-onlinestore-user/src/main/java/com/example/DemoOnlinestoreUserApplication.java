package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableCircuitBreaker
@EnableDiscoveryClient
@Import(RepositoryRestMvcConfiguration.class)
@EnableJpaRepositories 
public class DemoOnlinestoreUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOnlinestoreUserApplication.class, args);
    }
}

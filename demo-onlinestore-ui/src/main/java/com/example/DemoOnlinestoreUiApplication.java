package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
@EnableCircuitBreaker
public class DemoOnlinestoreUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOnlinestoreUiApplication.class,args);
    }
}
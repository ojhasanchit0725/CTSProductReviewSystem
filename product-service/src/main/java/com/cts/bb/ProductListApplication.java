package com.cts.bb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableCircuitBreaker
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableDiscoveryClient
@EnableHystrix

public class ProductListApplication {  
 
	public static void main(String[] args) {
		SpringApplication.run(ProductListApplication.class, args);
		
	}
	
}

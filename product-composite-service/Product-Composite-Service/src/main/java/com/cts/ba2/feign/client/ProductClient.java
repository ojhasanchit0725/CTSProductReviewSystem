package com.cts.ba2.feign.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.cts.ba2.model.Product;
@RibbonClient
@FeignClient(url="localhost:8081/product", name="Product-Service")
public interface ProductClient {

	
	//to get the detail of Product using its id from Product-Service
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id);
	
}


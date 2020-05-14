package com.cts.ba2.feign.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.ba2.model.Product;
import com.cts.ba2.model.Review;
@RibbonClient
@FeignClient(url="http://localhost:8082/Review", name="Review-Service")
public interface ReviewClient {


	//to get the list of all review tag to product with particular productId
	@GetMapping("/{id}")
		public List<Review> allReviewWithProductId(@PathVariable("id") Long pid);
}



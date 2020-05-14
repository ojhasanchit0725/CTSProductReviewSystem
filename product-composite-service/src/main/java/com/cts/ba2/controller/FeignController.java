package com.cts.ba2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ba2.feign.client.ProductClient;
import com.cts.ba2.feign.client.ReviewClient;
import com.cts.ba2.model.Product;
import com.cts.ba2.model.ProductReview;
import com.cts.ba2.model.Review;

@RestController

public class FeignController {
	
	@Autowired
	private ProductClient ProductClient;
	
	@Autowired
	private ReviewClient ReviewClient;
	
	
	//to get the detail of all review for a specific product 
	@GetMapping("/{id}")
	public ProductReview productWithReview(@PathVariable("id") Long id) {
		
		Product product = ProductClient.getProductById(id);
		List<Review> reviewList = ReviewClient.allReviewWithProductId(id);
		ProductReview productReview = new ProductReview( 
				product.getProductName(),
				product.getProductDesc(),
				product.getProductPrice(),
				reviewList);

				return productReview;	
		}
}

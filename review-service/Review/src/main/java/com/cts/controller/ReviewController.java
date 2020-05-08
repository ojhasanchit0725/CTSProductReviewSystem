package com.cts.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.logger.GlobalResource;
import com.cts.model.Review;
import com.cts.service.IReviewService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/Review")
public class ReviewController {

	//get logger variable
	private Logger logger = GlobalResource.getLogger(ReviewController.class);

	@Autowired
	IReviewService service;
	
	// to get All the reviews.
	@GetMapping
	public List<Review> fetchReviewList()
	{//logging
		String methodName = "fetchReviewList()";
		logger.info(methodName+" called");
		
		List<Review> review=new ArrayList<Review>();
		//logic for fetch
		review=service.fetchReviewList();
		return review;
		
	}
	

	
	//to post reviews
	@PostMapping
	public ResponseEntity<Object> saveReview(@RequestBody Review review) {
		//logging
		String methodName = "saveReview()";
		logger.info(methodName+" called");
		
		service.saveReviewToDB(review);
		return new ResponseEntity<>("Review is added successfully", HttpStatus.CREATED);
	}

	//Fetch all review from productId
	@GetMapping("/{productId}")
	public List<Review> fetchReviewById(@PathVariable int productId)
	{//logging
		String methodName = "fetchReviewById()";
		logger.info(methodName+" called");
		
		return  service.fetchReviewById(productId);
	}

}

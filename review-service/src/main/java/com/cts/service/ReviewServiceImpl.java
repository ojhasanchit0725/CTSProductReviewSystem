package com.cts.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.ReviewNotFoundException;
import com.cts.logger.GlobalResource;
import com.cts.model.Review;
import com.cts.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService{
	
	@Autowired
	private ReviewRepository repo;
	
	//get logger variable
		private Logger logger = GlobalResource.getLogger(ReviewServiceImpl.class);
			

	
	@Override
	public List<Review> fetchReviewList()
	{	//logging
		String methodName = "fetchReviewListService()";
		logger.info(methodName+" called");
		
		return repo.findAll();
	}
	
	
	
	
	@Override
	public Review saveReviewToDB(Review review)
	{	//logging
		String methodName = "saveReviewToDBService()";
		logger.info(methodName+" called");
		
		if(review.getUserComment().isBlank())
		{
			throw new ReviewNotFoundException("Review is Required!!");
        }
		
		if(review.getUserName().isBlank())
		{
			throw new ReviewNotFoundException("User Name is Required");
        }
		if(review.getUserEmail().isBlank())
		{
			throw new ReviewNotFoundException("Email is Required");
        }
		return repo.save(review);
	}
	
	
	
	
	@Override
	public List<Review>  fetchReviewById(int productId)
	{	//logging
		String methodName = "fetchReviewByIdService()";
		logger.info(methodName+" called");	 

		List<Review> result=this.repo.findById(productId);
		if (result == null || result.isEmpty()) {
		    throw new ReviewNotFoundException("Product ID : " + productId + " Not Found");
		}
		else {
			return result;
		}

			
	}
	
	
}

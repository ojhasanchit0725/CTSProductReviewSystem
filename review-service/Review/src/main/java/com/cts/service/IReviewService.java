package com.cts.service;

import java.util.List;

import com.cts.model.Review;

public interface IReviewService{

	
	public List<Review> fetchReviewList();
	public Review saveReviewToDB(Review review);
	public List<Review>  fetchReviewById(int productId);
	
}

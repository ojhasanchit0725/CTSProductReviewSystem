package com.cts.ba2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
	
    private int reviewId;
	
	private String userName;
	
	private String userEmail;
	
	private int userRating;
	
	private String userComment;
	
	private int productId;
	

}

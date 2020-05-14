package com.cts.ba2.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductReview {
	
//private Long productId;
	
	private String productName;
	
	private String productDesc;
	
	private int productPrice;
	
	private List<Review> reviewList;

}
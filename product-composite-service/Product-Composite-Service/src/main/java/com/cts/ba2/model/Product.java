package com.cts.ba2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	
	//private Long productId;
	
	private String productName;
	
	private String productDesc;
	
	private int productPrice;
	
	private Long reviewId;

}

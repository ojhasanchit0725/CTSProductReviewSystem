package com.cts.bb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public @Data class Product {
	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
//	@Size(min=2,message ="Product Name is Required!!")
//	@NotNull(message = "Product Name is required")
	@Column(name = "productName", nullable = false)

	private String productName;

//	@Size(min=2,message ="Desc is Required!!")
	@Column(name = "productDesc")
	private String productDesc;
	
	@Column(name = "productPrice")
	private int productPrice;
}

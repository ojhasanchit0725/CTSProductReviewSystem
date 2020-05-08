package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class Review {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int reviewId;
	
	@Column(name = "userName")
	private String userName;

	
	@Column(name = "userEmail")
	private String userEmail;
	
	@Column(name = "userRating")
	private int userRating;
	
	@Column(name = "userComment")
	private String userComment;
	
//	@NotNull(message ="Id is Required!!")
	@Column(name = "productId")
	private int productId;
}
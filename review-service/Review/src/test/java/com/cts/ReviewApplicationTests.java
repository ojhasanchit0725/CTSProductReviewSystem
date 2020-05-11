package com.cts;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List; 
import java.util.stream.Collectors;
import java.util.stream.Stream; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.model.Review;
import com.cts.repository.ReviewRepository;
import com.cts.service.ReviewServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewApplicationTests 
{
	@Autowired
	ReviewServiceImpl service;
	
	@MockBean
	ReviewRepository repo;

	
	//test for fetchEmployeeList
	@Test
	public void  testfetchEmployeeList()
	{
		when(repo.findAll()).thenReturn(Stream.of(new Review(1,"ABC","a@gmailc.com",4,"avg",5)).collect(Collectors.toList()));
		assertEquals(1, service.fetchReviewList().size());
	}
	
	

	//test for SaveToDb
	@Test
	public void saveProductToDBTest() throws Exception
	{
		Review review=new Review(1,"Card","Payments@gmail.com",4,"avg",5);
        when(repo.save(review)).thenReturn(review);
        equals(repo.save(review));
   }

	//test for findbyID
	@Test
	public void fetchProductByIdTest() 
	{   
		Review review=new Review(1,"Card","Payments@gmail.com",4,"avg",5);
        when(repo.findById(review.getProductId())).thenReturn(List.of(review)).getMock();
        assertEquals(1, review.getReviewId());
    }

}



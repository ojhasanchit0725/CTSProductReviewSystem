package com.cts;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
public class ReviewApplicationTests {

	@MockBean
	ReviewRepository repo;

	
	@Autowired
	ReviewServiceImpl service;
	
	@Test
	public void  testfetchEmployeeList()
	{
		when(repo.findAll()).thenReturn(Stream.of(new Review(1,"ABC","a@gmailc.com",4,"avg",5)).collect(Collectors.toList()));
	
		assertEquals(1, service.fetchReviewList().size());
	}

}

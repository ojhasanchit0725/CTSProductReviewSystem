package com.cts.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.bb.model.Product;
import com.cts.bb.repository.ProductRepository;
import com.cts.bb.service.ProductServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

	@Autowired
	private ProductServiceImpl service;
	
	@MockBean
	private ProductRepository repo;
	
	//test for  fetchProductList
	@Test
	public void fetchProductListTest()
	{
		when(repo.findAll()).thenReturn(Stream.of(new Product(100,"USBcable","For Charging",1000),new Product(200,"Adapter","For Cable",2000)).collect(Collectors.toList()));
	
		assertEquals(2, service.fetchProductList().size());
	}
	
	
	//Working
	//test for saveProductToDB
	@Test
	public void saveProductToDBTest() throws Exception
	{
		Product product=new Product(1,"Card","Payments",100000);
        when(repo.save(product)).thenReturn(product);
        equals(repo.save(product));


	}
	
	//test for fetchProductById
	@Test
	public void fetchProductByIdTest() 
	{   
		Product product=new Product(1,"For NA","KeyBoard",3000);
        when(repo.findById(product.getProductId())).thenReturn(Optional.of(product)).getMock();
        assertEquals(1, product.getProductId());

    }
	

 
	
	
}

package com.cts.bb;

import static org.junit.Assert.assertEquals;
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
public class ProductListApplicationTests {

	@Autowired
	private ProductServiceImpl service;
	
	@MockBean
	private ProductRepository repo;
	
	//Working
	@Test
	public void fetchProductListTest()
	{
		when(repo.findAll()).thenReturn(Stream.of(new Product(100,"USBcable","For Charging",1000),new Product(200,"Adapter","For Cable",2000)).collect(Collectors.toList()));
	
		assertEquals(2, service.fetchProductList().size());
	}
	
	//Working
	@Test
	public void saveProductToDBTest() throws Exception
	{
		Product product=new Product(1,"Card","Payments",100000);
        when(repo.save(product)).thenReturn(product);

	}
	@Test
	public void fetchProductByIdTest() 
	{   
		Product product=new Product(1,"For NA","KeyBoard",3000);
        when(repo.findById(product.getProductId())).thenReturn(Optional.of(product)).getMock();
    }
	
	//Working
//	@Test
//	public void fetchProductByIdTest() 
//	{  int id=3;
//	assertEquals(1, service.fetchProductById(1));
//		repo.findById(product.getProductId());
//		assertEquals("By id get name",product.getName());
//	when(repo.findById(1)).thenReturn(Stream.of(new Product(100,"USBcable","For Charging",1000),new Product(200,"Adapter","For Cable",2000)).collect(Collectors.toList()));
//	assertEquals(1, service.fetchProductById(id));
//
//	}
//	@Test
//	public void fetchProjectByIdTest() 
//	{   	Product product=new Product(2,"Mi Watch","sa",100);
//
//        when(repo.findById(product.getProductId())).thenReturn(Optional.of(product)).getMock();
//	}
	
	//Working
//	@Test
//	@DirtiesContext
//	public void deleteProductByIdTest()
//	{	
//		Product product=new Product(3,"Smart Watch","FitBand",2300);
////        when(repo.deleteById(product.getProductId()));
//		service.deleteProductById(product.getProductId());
//    	verify(repo,times(1)).deleteById(product.getProductId());
////		service.deleteProductById(product.getPid());
////		verify(repo,times(1)).deleteById(product.getPid());
////repo.deleteById(6);
////assertNull(repo.findById(6));
//	}
 
	
	
}

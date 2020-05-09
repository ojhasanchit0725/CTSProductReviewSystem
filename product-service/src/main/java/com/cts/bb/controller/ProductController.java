package com.cts.bb.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bb.logger.GlobalResource;
import com.cts.bb.model.Product;
import com.cts.bb.service.IProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
	@Autowired
	IProductService service;

	//get logger variable
	private Logger logger = GlobalResource.getLogger(ProductController.class);

	
	//to get all the list of products  
	@GetMapping
	@HystrixCommand(fallbackMethod="fallBack1")
	public ResponseEntity<Object> fetchProductList()
	{
		//logging
		String methodName = "fetchProductList()";
		logger.info(methodName+" called");
		return new ResponseEntity<>(service.fetchProductList(), HttpStatus.OK);
	}				

	
	//to post data to database
 	@PostMapping
	public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
 		//logging
		String methodName = "saveProduct()";
		logger.info(methodName+" called");
		
		service.saveProductToDB(product);
		return new ResponseEntity<>("Product is added successfully", HttpStatus.CREATED);
		}
	

	//to get the product by product-id
	@GetMapping("/{id}")
	@HystrixCommand(fallbackMethod="fallBack2")
	public ResponseEntity<Object> fetchProductById(@PathVariable int id)
	{//logging
		String methodName = "fetchProductById()";
		logger.info(methodName+" called");
		service.fetchProductById(id);
		return new ResponseEntity<>(service.fetchProductById(id), HttpStatus.OK); 

	}

	//Update by passing  id where id should be same
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product) {
		//logging
		  String methodName = "updateProduct()";
	   	  logger.info(methodName+" called");
	      service.updateProduct(id, product);
	      return new ResponseEntity<>(service.updateProduct(id, product), HttpStatus.OK);
	 }


	//Delete by id..
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteProductByid(@PathVariable int id) {
		//logging
		  String methodName = "deleteProductByid()";
	   	  logger.info(methodName+" called");
	      return new ResponseEntity<>(service.deleteProductById(id), HttpStatus.OK);
	   }
	
	
	
	public ResponseEntity<Object> fallBack1(){
		return new ResponseEntity<>(service.fetchProductList(), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> fallBack2(@PathVariable("id") int id){
		return new ResponseEntity<>("Fallback", HttpStatus.OK);
	}

}

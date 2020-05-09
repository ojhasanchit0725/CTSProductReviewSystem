package com.cts.bb.service;
import org.slf4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bb.exception.ProductNotFoundException;
import com.cts.bb.logger.GlobalResource;
import com.cts.bb.model.Product;
import com.cts.bb.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
 
	private Logger logger = GlobalResource.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> fetchProductList() {
		return repo.findAll();
	}

	@Override
	public Product saveProductToDB(Product product) {
		if(product.getProductName().isBlank())
		{
			throw new ProductNotFoundException("Product Name Required!!");
        }
		
		if(product.getProductDesc().isBlank())
		{
			throw new ProductNotFoundException("Product Description is Required");
        }
	
		//logging
		String methodName = "saveProductToDBService()";
		logger.info(methodName+" called");
		
		return repo.save(product);
	}

	@Override
	public Product fetchProductById(int id) {
		//logging
		String methodName = "fetchProductByIdService()";
		logger.info(methodName+" called");
				
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			throw new ProductNotFoundException("Product ID : " + id + " Not Found");
		}

	}

	@Override
	public String updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		//logging
		String methodName = "updateProductService()";
		logger.info(methodName+" called");

		
		if (repo.findById(id).isPresent()) {

			Product availProduct = repo.findById(id).get();
			availProduct.setProductId(product.getProductId());
			availProduct.setProductDesc(product.getProductDesc());
			availProduct.setProductName(product.getProductName());
			availProduct.setProductPrice(product.getProductPrice());

			if (product.getProductId() != id) {
				throw new ProductNotFoundException("id can't be updated, Please Change to :" + id);

			}

			if(product.getProductName().isBlank())
			{
				throw new ProductNotFoundException("Product Name Required!!");
	        }
			
			if(product.getProductDesc().isBlank())
			{
				throw new ProductNotFoundException("Product Description is Required");
	        }
			Product updateProduct = repo.save(availProduct);
			return "Product with id " + id + " is updated";
		}

		else {
			throw new ProductNotFoundException("Product ID : " + id + " Not Found");

		}
	}

	@Override
	public String deleteProductById(int id) {

		//logging
		String methodName = "deleteProductByIdService()";
		logger.info(methodName+" called");

		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);

			return "Product id with " + id + " is deleted";
		}

		else {
			throw new ProductNotFoundException("Product ID : " + id + " Not Found");
		}

	}


}

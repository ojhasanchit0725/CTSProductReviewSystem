package com.cts.bb.service;

import java.util.List;

import com.cts.bb.model.Product;

public interface IProductService {

public  List<Product> fetchProductList();
public  Product saveProductToDB(Product product);
public  Product fetchProductById(int id);
public  String deleteProductById(int id);
public  String updateProduct(int id, Product product);
}

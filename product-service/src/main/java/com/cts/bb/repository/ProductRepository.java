package com.cts.bb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.bb.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

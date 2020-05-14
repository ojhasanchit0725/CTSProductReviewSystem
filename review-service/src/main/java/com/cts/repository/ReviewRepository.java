package com.cts.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	@Query(value="SELECT * from review where product_id=?", nativeQuery = true)
	List<Review>  findById(int productId);
}

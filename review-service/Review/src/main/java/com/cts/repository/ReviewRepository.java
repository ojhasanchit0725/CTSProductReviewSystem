package com.cts.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import com.cts.model.Review;
import com.cts.repository.ReviewRepository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	@Query(value="SELECT * from review where product_id=?", nativeQuery = true)
	List<Review>  findById(int productId);
}

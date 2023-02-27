package com.reviewanalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reviewanalysis.entity.Reviews;

@Repository
public interface ReviewCustomRepository {
	@Query("from Reviews where reviewId >= :range1 and reviewId <= :range2")
	public List<Reviews> getReviewBetweenIds(@Param("range1") int range1,@Param("range2") int range2)throws Exception;
	public List<Reviews> getReviewByRating(int rating) throws Exception;
	 public Reviews getReviewByReviewId(int reviewId) throws Exception;

}

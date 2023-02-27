package com.reviewanalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reviewanalysis.entity.Reviews;

@Service
public interface ReviewService { 
	public Reviews insertReview(Reviews review)throws Exception;
	public Reviews updateReview(Reviews review)throws Exception;
	public List<Reviews> getAllReviews()throws Exception;
	 public String deleteByReviewId(int reviewId)  throws Exception;
	 public List<Reviews> getReviewByRating(int rating) throws Exception;
	 public List<Reviews> getReviewBetweenIds(int range1, int range2)throws Exception;
	 public Reviews getReviewByReviewId(int reviewId) throws Exception;
	 public List<Reviews>  sortByRatings()  throws Exception;

}

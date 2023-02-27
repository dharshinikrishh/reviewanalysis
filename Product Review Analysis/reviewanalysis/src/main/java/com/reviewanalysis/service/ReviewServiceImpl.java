package com.reviewanalysis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewanalysis.comparator.SortReviewByRatingHighToLow;
import com.reviewanalysis.entity.Reviews;
import com.reviewanalysis.repository.ReviewRepository;
@Service
public class ReviewServiceImpl implements ReviewService{

	
	
	@Autowired
	ReviewRepository reviewRepository;
	@Override
	public Reviews insertReview(Reviews review) throws Exception {
		// TODO Auto-generated method stub
		Reviews savedReview = reviewRepository.save(review);
		if(savedReview!=null) {
			return savedReview;
		}else
			return null;
	}
	@Override
	public Reviews updateReview(Reviews review) throws Exception {
		// TODO Auto-generated method stub
		Reviews savedReview=reviewRepository.save(review);
		return savedReview;
	}
	@Override
	public List<Reviews> getAllReviews() throws Exception {
		// TODO Auto-generated method stub
		List<Reviews> allReview = reviewRepository.findAll();
		return allReview;
	}
	@Override
	public String deleteByReviewId(int reviewId) throws Exception {
		// TODO Auto-generated method stub
		reviewRepository.deleteById(reviewId);
		return "Deleted successfully";
		
	}
	@Override
	public List<Reviews> getReviewByRating(int rating) throws Exception {
		// TODO Auto-generated method stub
			List<Reviews> savedReview= reviewRepository.getReviewByRating(rating);
			return savedReview;
			}
	@Override
	public List<Reviews> getReviewBetweenIds(int range1, int range2) throws Exception {
		// TODO Auto-generated method stub
		return reviewRepository.getReviewBetweenIds(range1, range2);
	}
	@Override
	public Reviews getReviewByReviewId(int reviewId) throws Exception {
		// TODO Auto-generated method stub
		return reviewRepository.getReviewByReviewId(reviewId);
	}
	@Override
	public List<Reviews> sortByRatings() throws Exception {
		// TODO Auto-generated method stub
		List<Reviews> list =reviewRepository.findAll();
		List<Reviews> review=new ArrayList<>();
		Collections.sort(list,new SortReviewByRatingHighToLow());
		return list;
	}
	
	}
	

	
	



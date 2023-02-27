package com.reviewanalysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reviewanalysis.entity.Reviews;
import com.reviewanalysis.service.ReviewService;

@RestController
@RequestMapping("/review/admin")
public class ReviewAdminController {
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/allreviews")
	public List<Reviews> getAllReviews()
	{
		try {
			List<Reviews> allExtractedReviews = reviewService.getAllReviews();
			return allExtractedReviews;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@DeleteMapping("/delete/{reviewId}")
	public String deleteReview(@PathVariable int reviewId)
	{
		try {
			reviewService.deleteByReviewId(reviewId);
			return "deleted successfully";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping("/rating/{rating}")
	public  List<Reviews> getReviewByRating(@PathVariable int rating) throws Exception
	{
		return reviewService.getReviewByRating(rating);
	}
	@GetMapping("/reviewBetweenId")
	public List<Reviews> reviewByReviewI(@RequestParam int r1, @RequestParam  int r2) throws Exception
	{
		return reviewService.getReviewBetweenIds(r1, r2);
	}
	@GetMapping("reviewId/{searchUserId}")
	public Reviews getUserByUserId(@PathVariable int searchUserId) throws Exception {
		return reviewService.getReviewByReviewId(searchUserId);
	}
	
	
}

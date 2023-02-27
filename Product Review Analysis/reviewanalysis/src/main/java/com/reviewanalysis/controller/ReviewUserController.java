package com.reviewanalysis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reviewanalysis.entity.Reviews;
import com.reviewanalysis.service.ReviewService;

@RestController
@RequestMapping("/review/user")
public class ReviewUserController {
	@Autowired
	ReviewService reviewService;
	
	private final Logger mylogs =LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/addreview")
	public ResponseEntity<String> addReview(@RequestBody Reviews review){
		try {
			Reviews savedReview = reviewService.insertReview(review);
			String responseMsg="save with ReviewId " +savedReview.getReviewId();
			mylogs.info("A value is added ");
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		}catch(Exception e) {
			String errorMsg = "Contact customer care Ph.no:- 1800-250-900 or mail to:- bookstore@gmail.com \n "+e  ;
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR); 
			
		}
		
	}
	@PutMapping("/update/{reviewId}")
	public  Reviews updateReview(@RequestBody Reviews reviewId) throws Exception{
		return reviewService.updateReview(reviewId);
	}
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
	@GetMapping("/sort/points")
	public List<Reviews> sortingByRating() throws Exception
	{
		return  reviewService.sortByRatings();
	}
}
	
	
	



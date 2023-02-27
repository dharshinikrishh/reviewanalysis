package com.reviewanalysis.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.reviewanalysis.entity.Reviews;
import com.reviewanalysis.repository.ReviewRepository;

@SpringBootTest
class ReviewServiceImplTest {
	
	@Mock
	ReviewRepository reviewRepository;
	
	@InjectMocks
	ReviewServiceImpl reviewService;

	@Test
	@DisplayName("Test- to verify the insert operation\"")
	void testInsertReview() throws Exception{
		Reviews sampleInput = new Reviews("the product is okay",5,6546l);
		Reviews expectedOutput = new Reviews("the product is okay",5,6546l);
		BDDMockito.given(reviewService.insertReview(sampleInput)).willReturn(expectedOutput);
	}


	@Test
	@DisplayName("Get all the reviews")
	void testGetAllReviews() throws Exception {
		Reviews reviews1 = new Reviews("the product is okay",5,6546l);
		Reviews reviews2= new Reviews("the product is good",7,98l);
		List<Reviews> sampleOutput = new ArrayList<>();
		sampleOutput.add(reviews1);
		sampleOutput.add(reviews2);
		BDDMockito.given(reviewService.getAllReviews()).willReturn(sampleOutput);
		List<Reviews>actualOutput= reviewService.getAllReviews();
		assertNotNull(actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
	}

	@Test
	@DisplayName("Get all reviews between id")
	void testGetReviewBetweenIds() throws Exception {
		Reviews reviews1 = new Reviews("the product is okay",5,6546l);
		Reviews reviews2= new Reviews("the product is good",7,98l);
		List<Reviews>sampleOutput = new ArrayList<>();
		sampleOutput.add(reviews1);
		sampleOutput.add(reviews2);
		int sampleInput1=1;
		int sampleInput2 = 20;
		BDDMockito.given(reviewService.getReviewBetweenIds(sampleInput1, sampleInput2)).willReturn(sampleOutput);
		List<Reviews>actualOutput = reviewService.getReviewBetweenIds(sampleInput1, sampleInput2);
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);
		
	}

	@Test
	@DisplayName("Test to verify the method getReview by reviewId should return Review or not")
	void testGetReviewByReviewId() throws Exception {
		Reviews sampleOutput= new Reviews("the product is okay",5,6546l);
		sampleOutput.setReviewId(1);
		int sampleInput = 1;
		BDDMockito.given(reviewService.getReviewByReviewId(sampleInput)).willReturn(sampleOutput);
		Reviews actualOutput =reviewService.getReviewByReviewId(sampleInput);
		assertEquals(sampleOutput, actualOutput);
		assertSame(sampleOutput.getReviewId(), actualOutput.getReviewId());
		
	}

}

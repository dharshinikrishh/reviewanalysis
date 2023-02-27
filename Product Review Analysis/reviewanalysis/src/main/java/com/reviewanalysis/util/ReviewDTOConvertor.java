package com.reviewanalysis.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.reviewanalysis.dto.ReviewDefaultResponseDTO;
import com.reviewanalysis.entity.Reviews;

@Component
@Scope("singleton")
public class ReviewDTOConvertor {
	public static ReviewDefaultResponseDTO  getUserDefaultDTO(Reviews review)
	{
		ReviewDefaultResponseDTO dto = new ReviewDefaultResponseDTO(
				review.getReviewId(),
				review.getUserId(),
				review.getDescription(),
				
				review.getRating());
								                
		return dto;
	}

}

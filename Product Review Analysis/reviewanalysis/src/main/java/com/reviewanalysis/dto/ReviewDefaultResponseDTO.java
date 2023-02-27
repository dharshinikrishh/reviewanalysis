package com.reviewanalysis.dto;

import lombok.Data;

@Data
public class ReviewDefaultResponseDTO implements ReviewDTO {
	
	
	public ReviewDefaultResponseDTO(int reviewId2, Long userId2, String description2, int rating2) {
		// TODO Auto-generated constructor stub
	}
	private int reviewId;
	private Long userId;
	private String description;
	private int rating;

}

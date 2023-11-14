package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Review;

public interface ReviewService {

	public List<Review> selectAll(int videoId);

	public int writeReview(Review review);
	
	public Review selectReview(int reviewId);
	
	public void updateReview(Review review);
	
	public void deleteReview(int reviewId);
	
}
package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Review;

public interface ReviewDao {
	
	//리뷰 전체보기
	public List<Review> selectAll(int videoId);
	
	//리뷰 작성
	public int writeReview(Review review);
	
	//리뷰 1개 선택해서 보기
	public Review selectReview(int reviewId);
	
	//리뷰 수정하기
	public void updateReview(Review review);
	
	//리뷰 삭제하기 
	public void deleteReview(int reviewId);

	
}

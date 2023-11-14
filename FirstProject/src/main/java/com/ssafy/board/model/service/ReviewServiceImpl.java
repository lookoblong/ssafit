package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.ReviewDao;
import com.ssafy.board.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Override
	public List<Review> selectAll(int videoId) {
		return reviewDao.selectAll(videoId);
	}
	
	@Transactional
	@Override
	public int writeReview(Review review) {
		return reviewDao.writeReview(review);
	}

	@Override
	public Review selectReview(int reviewId) {
		return reviewDao.selectReview(reviewId);
	}

	@Transactional
	@Override
	public void updateReview(Review review) {
		System.out.println(review.getReviewId() + "번 리뷰 업데이트");
		reviewDao.updateReview(review);
	}

	@Transactional
	@Override
	public void deleteReview(int reviewId) {
		System.out.println(reviewId + "번 리뷰 삭제함");
		reviewDao.deleteReview(reviewId);
	}
	
	

	

}

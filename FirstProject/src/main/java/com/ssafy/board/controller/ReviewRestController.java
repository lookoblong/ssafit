package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@Api(tags="리뷰 컨트롤러")
@CrossOrigin("*")
public class ReviewRestController {

	@Autowired
	private ReviewService reviewService;

	// http://localhost:8080/api-review/review?videoId=3 같이 입력받음
	@GetMapping("/review")
	@ApiOperation(value="videoId에 해당하는 리뷰 조회")
	public ResponseEntity<?> list(int videoId){
		List<Review> list = reviewService.selectAll(videoId);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("/review")
	@ApiOperation(value="비디오마다(videoId) 리뷰 작성")
	public ResponseEntity<Review> write(Review review){
		reviewService.writeReview(review);
		return new ResponseEntity<Review>(review ,HttpStatus.OK);
	}
	
	@DeleteMapping("/review/{reviewId}")
	@ApiOperation(value="id로 리뷰 삭제")
	public ResponseEntity<Void> delete(@PathVariable int reviewId){
		reviewService.deleteReview(reviewId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/review/{reviewId}") 
	@ApiOperation(value="리뷰 수정")
	public ResponseEntity<Void> update(@RequestBody Review review){
		reviewService.updateReview(review);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

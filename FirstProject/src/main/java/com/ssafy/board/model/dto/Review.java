package com.ssafy.board.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class Review {
	private int reviewId;
	private int videoId;
	private String userId;
	private String createdAt;
	private String title;
	private String content;
	
	public Review() {}
	
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", videoId=" + videoId + ", userId=" + userId + ", createdAt="
				+ createdAt + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}

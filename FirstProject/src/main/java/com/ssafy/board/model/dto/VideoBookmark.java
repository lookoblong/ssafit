package com.ssafy.board.model.dto;

public class VideoBookmark {
	private String userId;
	private int videoId;
	
	public VideoBookmark() {}

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

	@Override
	public String toString() {
		return "VideoBookmark [videoId=" + videoId + ", userId=" + userId + "]";
	};
	
	
	
	
}

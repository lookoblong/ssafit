package com.ssafy.board.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="게시판 바구니", description = "게시글 정보")
public class Video {
    private int videoId;
    private String videoTitle;
    private String videoPart;
    private String videoUrl;
    private String videoCreatedAt;
    private int videoViewCnt;

    public Video() {
    }

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoPart() {
		return videoPart;
	}

	public void setVideoPart(String videoPart) {
		this.videoPart = videoPart;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoCreatedAt() {
		return videoCreatedAt;
	}

	public void setVideoCreatedAt(String videoCreatedAt) {
		this.videoCreatedAt = videoCreatedAt;
	}

	public int getVideoViewCnt() {
		return videoViewCnt;
	}

	public void setVideoViewCnt(int videoViewCnt) {
		this.videoViewCnt = videoViewCnt;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", videoTitle=" + videoTitle + ", videoPart=" + videoPart + ", videoUrl="
				+ videoUrl + ", videoCreatedAt=" + videoCreatedAt + ", videoViewCnt=" + videoViewCnt + "]";
	}


    
}
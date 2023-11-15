package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.dto.VideoBookmark;
import com.ssafy.board.model.dto.SearchCondition;

public interface VideoService {
	
	List<Video> getList();

	void writeVideo(Video Video);

	Video getVideo(int videoId);

	void modifyVideo(Video Video);

	void removeVideo(int videoId);

	List<Video> search(SearchCondition condition);
	
	public void bookmark(VideoBookmark bm);
	
	public void unbookmark(VideoBookmark bm);
	
    public List<String> findBookmark(String userId);

	void increaseViewCnt(int videoId);
	
}

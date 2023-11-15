package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.dto.VideoBookmark;

public interface VideoDao {
	
	//영상 전체 보기
    public List<Video> selectAll();

    //영상 1개 선택
    public Video selectOne(int videoId);

    //영상 등록
    public void insertVideo(Video video);

    //영상 삭제
    public void deleteVideo(int videoId);

    //영상 수정
    public void updateVideo(Video video);

    //영상 리스트에서 검색
    public List<Video> search(SearchCondition condition);
    
    //영상 찜
    public void bookmark(VideoBookmark bm);
    
    //영상 찜 해제
    public void unbookmark(VideoBookmark bm);
  
    //찜목록 보기
    public List<String> findBookmark(String userId);
    
    //조회수 증가
    public void increaseViewCnt(int videoId);

}
package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.VideoDao;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.dto.VideoBookmark;

@Service
public class VideoServiceImpl implements VideoService {

    private VideoDao videoDao;
    
    @Autowired
    public void setBoardDao(VideoDao videoDao) {
        this.videoDao = videoDao;
    }
    
    
    @Override
    public List<Video> getList() {
        System.out.println("모든 게시글을 가지고 왔습니다.");
        return videoDao.selectAll();
    }

    @Transactional
    @Override
    public void writeVideo(Video video) {
        System.out.println("게시글을 작성합니다.");
        videoDao.insertVideo(video);
    }


    @Transactional
    @Override
    public void modifyVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Transactional
    @Override
    public void removeVideo(int id) {
        System.out.println(id+"번 글을 삭제 했습니다.");
        videoDao.deleteVideo(id);
    }


    @Override
    public List<Video> search(SearchCondition condition) {
        return videoDao.search(condition);
    }


	@Override
	public void bookmark(VideoBookmark bm) {
		videoDao.bookmark(bm);
	}

	@Override
	public void unbookmark(VideoBookmark bm) {
		videoDao.unbookmark(bm);
	}

	@Override
	public List<String> findBookmark(String userId) {
		return videoDao.findBookmark(userId);
	}


	@Override
	public Video getVideo(int videoId) {
		return videoDao.selectOne(videoId);
	}


	@Override
	public void increaseViewCnt(int videoId) {
		videoDao.increaseViewCnt(videoId);
	}

}
package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.dto.UserFollow;

public interface UserDao {
	
	//회원 목록 전체 보기
	List<User> selectAll();
	
	//회원 등록
	void insertUser(User user);
	
	//회원 1명 선택해서 보기
	User selectOne(String userId);
	
	//회원 팔로우 하기
	void follow(UserFollow userFollow);
	
	//회원 팔로우 취소
	void unfollow(UserFollow userFollow);
	
	//팔로잉 중인 회원 목록
	List<String> getFollowing(String userId);
	
	//내 팔로워들 
	List<String> getFollower(String userId);

	//id로 가져오기
	User selectUser(String userId);
	
}
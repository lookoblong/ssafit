package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.dto.UserFollow;

public interface UserService {

	List<User> getUserList();

	void signup(User user);

	User login(User user);
		
	User selectUser(String userId);
	
	List<String> getFollowing(String userId);
	
	List<String> getFollower(String userId);

	void follow(UserFollow userFollow);
	
	void unfollow(UserFollow userFollow);
	
}
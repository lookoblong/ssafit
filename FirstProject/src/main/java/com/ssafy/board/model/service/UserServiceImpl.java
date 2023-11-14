package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.dto.UserFollow;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	
	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}

	
	@Override
	public User login(User user) {
		User tmp = userDao.selectOne(user.getUserId());
		if(tmp != null && tmp.getUserPassword().equals(user.getUserPassword()))
			return tmp;
		return null;
	}


	@Override
	public void follow(UserFollow userFollow) {
		userDao.follow(userFollow);
	}


	@Override
	public List<String> getFollowing(String userId) {
		return userDao.getFollowing(userId);
	}


	@Override
	public List<String> getFollower(String userId) {
		return userDao.getFollower(userId);
	}


	@Override
	public void unfollow(UserFollow userFollow) {
		userDao.unfollow(userFollow);
		
	}


	@Override
	public User selectUser(String userId) {
		return userDao.selectUser(userId);
	}

	
}

package com.ssafy.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.dto.UserFollow;
import com.ssafy.board.model.service.UserService;
import com.ssafy.board.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "사용자 컨트롤러")
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("users")
	@ApiOperation(value="전체 사용자 조회")
	public ResponseEntity<?> list(){
		List<User> list = userService.getUserList();
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@PostMapping("users/signup")
	@ApiOperation(value="회원가입")
	public ResponseEntity<User> signup(@RequestBody User user) {
		userService.signup(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("users/{userId}")
	@ApiOperation(value="userId에 해당하는 user 조회")
	public ResponseEntity<?> getUser(@PathVariable String userId){

		System.out.println(userId);
		User user = userService.selectUser(userId);
		if (user != null) return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@PostMapping("login")
	@ApiOperation(value="로그인")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpStatus status = null;
		
		User loginUser = userService.login(user);
		
		try {
			if (loginUser != null) {
				result.put("access-token", jwtUtil.createToken("id", user.getUserId()));
				result.put("message", "LOGIN SUCCESS");
				status = HttpStatus.ACCEPTED;
			}else {
				result.put("message", "BAD REQUEST");
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", "INTERNAL SERVER ERROR");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String,Object>>(result, status);
	}
	
	@GetMapping("logout")
	@ApiOperation(value="로그아웃")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("follow/{followId}")
	@ApiOperation(value="session의 id + followId로 팔로우")
	public ResponseEntity<Void> follow(String id, @PathVariable String followId)  {
		UserFollow userFollow = new UserFollow();
		userFollow.setUserId(id);
		userFollow.setFollowId(followId);
		userService.follow(userFollow);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("following")
	@ApiOperation(value="session의 id로 팔로잉 목록 가져오기")
	public ResponseEntity<?> following(String id) {
		List<String> followingList = userService.getFollowing(id);
		if (followingList != null) return new ResponseEntity<List<String>>(followingList, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("follower")
	@ApiOperation(value="session의 id로 팔로워 목록 가져오기")
	public ResponseEntity<?> follower(String id) {
		List<String> followerList = userService.getFollower(id);
		if (followerList != null) 
			return new ResponseEntity<List<String>>(followerList, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("follow/{followId}")
	@ApiOperation(value="id + followId로 언팔로우")
	public ResponseEntity<Void> unfollow(String id, @PathVariable String followId)  {
		UserFollow userFollow = new UserFollow();
		userFollow.setUserId(id);
		userFollow.setFollowId(followId);
		userService.unfollow(userFollow);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
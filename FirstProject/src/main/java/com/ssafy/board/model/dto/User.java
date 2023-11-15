package com.ssafy.board.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="사용자", description = "사용자 정보")
public class User {
	private int userSeq;
	private String userId;
	private String userPassword;
	private String userEmail;
	private String userNickname;
	private boolean isKakao;
	
	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public boolean isKakao() {
		return isKakao;
	}

	public void setKakao(boolean isKakao) {
		this.isKakao = isKakao;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [userSeq=" + userSeq + ", userId=" + userId + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userNickname=" + userNickname + ", isKakao=" + isKakao + "]";
	}

	
	
	
}

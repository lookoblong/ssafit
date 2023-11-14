package com.ssafy.board.model.dto;

public class UserSchedule {
	private int userSeq;
	private String userSchedule;
	
	public UserSchedule() {}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserSchedule() {
		return userSchedule;
	}

	public void setUserSchedule(String userSchedule) {
		this.userSchedule = userSchedule;
	}

	@Override
	public String toString() {
		return "UserSchedule [userSeq=" + userSeq + ", userSchedule=" + userSchedule + "]";
	}
	
	
}

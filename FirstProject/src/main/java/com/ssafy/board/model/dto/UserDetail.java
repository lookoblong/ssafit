package com.ssafy.board.model.dto;

public class UserDetail {
	private int userSeq;
	private String userProfilePic;
	private boolean userGender;
	private int userAge;
	private int userHeight;
	private int userWeight;
	private String userJob;
	private int userLevel;
	private String userPreferredPlace;
	private String userExtra;
	
	private UserDetail() {}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserProfilePic() {
		return userProfilePic;
	}

	public void setUserProfilePic(String profilePic) {
		this.userProfilePic = profilePic;
	}

	public boolean isUserGender() {
		return userGender;
	}

	public void setUserGender(boolean userGender) {
		this.userGender = userGender;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public int getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}

	public int getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(int userWeight) {
		this.userWeight = userWeight;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserPreferredPlace() {
		return userPreferredPlace;
	}

	public void setUserPreferredPlace(String userPreferredPlace) {
		this.userPreferredPlace = userPreferredPlace;
	}

	public String getUserExtra() {
		return userExtra;
	}

	public void setUserExtra(String userExtra) {
		this.userExtra = userExtra;
	}

	@Override
	public String toString() {
		return "UserDetail [userSeq=" + userSeq + ", profilePic=" + userProfilePic + ", userGender=" + userGender
				+ ", userAge=" + userAge + ", userHeight=" + userHeight + ", userWeight=" + userWeight + ", userJob="
				+ userJob + ", userLevel=" + userLevel + ", userPreferredPlace=" + userPreferredPlace + ", userExtra="
				+ userExtra + "]";
	};
	
	
	
}

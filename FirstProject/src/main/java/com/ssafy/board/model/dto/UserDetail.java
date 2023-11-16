package com.ssafy.board.model.dto;

public class UserDetail {
	private int userSeq;
	private String userProfilePic;
	private boolean userGender;
	private int userAge;
	private int userHeight;
	private int userWeight;
	private String userPreferredPlace;
	private String userExtra;
	private String trainerId; 
	
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

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	@Override
	public String toString() {
		return "UserDetail [userSeq=" + userSeq + ", userProfilePic=" + userProfilePic + ", userGender=" + userGender
				+ ", userAge=" + userAge + ", userHeight=" + userHeight + ", userWeight=" + userWeight
				+ ", userPreferredPlace=" + userPreferredPlace + ", userExtra=" + userExtra + ", trainerId=" + trainerId
				+ "]";
	}
	
	

	
	
}

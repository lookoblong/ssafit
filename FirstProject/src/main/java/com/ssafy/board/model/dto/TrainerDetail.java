package com.ssafy.board.model.dto;

public class TrainerDetail {
	private int trainerSeq;
	private String trainerProfilePic;
	private String trainerExperience; 
	private String trainerExtra;
	private String userId; 
	
	private TrainerDetail() {}

	public int getTrainerSeq() {
		return trainerSeq;
	}

	public void setTrainerSeq(int trainerSeq) {
		this.trainerSeq = trainerSeq;
	}

	public String getTrainerProfilePic() {
		return trainerProfilePic;
	}

	public void setTrainerProfilePic(String trainerProfilePic) {
		this.trainerProfilePic = trainerProfilePic;
	}

	public String getTrainerExtra() {
		return trainerExtra;
	}

	public void setTrainerExtra(String trainerExtra) {
		this.trainerExtra = trainerExtra;
	}

	public String getTrainerExperience() {
		return trainerExperience;
	}

	public void setTrainerExperience(String trainerExperience) {
		this.trainerExperience = trainerExperience;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TrainerDetail [trainerSeq=" + trainerSeq + ", trainerProfilePic=" + trainerProfilePic
				+ ", trainerExperience=" + trainerExperience + ", trainerExtra=" + trainerExtra + ", userId=" + userId
				+ "]";
	}

	
	

	
}

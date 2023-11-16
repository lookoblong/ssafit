package com.ssafy.board.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "트레이너", description = "트레이너 정보")
public class Trainer {
	private int trainerSeq;
	private String trainerId;
	private String trainerPassword;
	private String trainerEmail;
	private String trainerNickname;

	public int getTrainerSeq() {
		return trainerSeq;
	}

	public void setTrainerSeq(int trainerSeq) {
		this.trainerSeq = trainerSeq;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerPassword() {
		return trainerPassword;
	}

	public void setTrainerPassword(String trainerPassword) {
		this.trainerPassword = trainerPassword;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public String getTrainerNickname() {
		return trainerNickname;
	}

	public void setTrainerNickname(String trainerNickname) {
		this.trainerNickname = trainerNickname;
	}

	@Override
	public String toString() {
		return "Trainer [trainerSeq=" + trainerSeq + ", trainerId=" + trainerId + ", trainerPassword=" + trainerPassword
				+ ", trainerEmail=" + trainerEmail + ", trainerNickname=" + trainerNickname + "]";
	}

}

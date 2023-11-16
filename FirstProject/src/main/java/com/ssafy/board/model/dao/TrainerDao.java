package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Trainer;

public interface TrainerDao {
	
	//트레이너 목록 전체 보기
	List<Trainer> selectAll();
	
	//트레이너 등록
	void insertTrainer(Trainer trainer);
	
	//트레이너 1명 선택해서 보기
	Trainer selectOne(String trainerId);

	//트레이너 id로 가져오기
	Trainer selectTrainer(String trainerId);
	
}
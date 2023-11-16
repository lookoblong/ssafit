package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.TrainerDao;
import com.ssafy.board.model.dto.Trainer;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerDao trainerDao;
	
	
	@Override
	public List<Trainer> getTrainerList() {
		return trainerDao.selectAll();
	}

	
	@Override
	public void signup(Trainer trainer) {
		trainerDao.insertTrainer(trainer);
	}

	
	@Override
	public Trainer login(Trainer trainer) {
		Trainer tmp = trainerDao.selectOne(trainer.getTrainerId());
		if(tmp != null && tmp.getTrainerPassword().equals(trainer.getTrainerPassword()))
			return tmp;
		return null;
	}


	@Override
	public Trainer selectTrainer(String trainerId) {
		return trainerDao.selectTrainer(trainerId);
	}

}

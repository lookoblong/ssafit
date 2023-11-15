package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getList() {
		return boardDao.selectAll();
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public Board getBoard(int boardId) {
		return boardDao.selectOne(boardId);
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(int boardId) {
		boardDao.deleteBoard(boardId); 
	}


}

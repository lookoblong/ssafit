package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardService {
	
		// 게시글 전체 조회
		public List<Board> getList();

		// 게시글 등록
		public void writeBoard(Board board);

		// 게시글 상세 조회
		public Board getBoard(int boardId);

		// 게시글 수정
		public void modifyBoard(Board board);

		// 게시글 삭제
		public void removeBoard(int boardId);


}

package com.ssafy.board.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class Board {
	private int boardId;
	private String boardTitle;
	private String userId;
	private String boardContent;
	private String boardFile;
	
	public Board() {}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardTitle=" + boardTitle + ", userId=" + userId + ", boardContent=" + boardContent + ", boardFile=" + boardFile + "]";
	}
	
	
}

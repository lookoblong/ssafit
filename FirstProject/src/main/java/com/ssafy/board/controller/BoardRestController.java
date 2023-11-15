package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@Api(tags="보드 컨트롤러")
@CrossOrigin("*")
public class BoardRestController {

	@Autowired
	private BoardService boardService;

		@GetMapping("/board")
		@ApiOperation(value="전체 게시글 조회")
		public ResponseEntity<?> list(){
			List<Board> list = boardService.getList(); //전체 조회
			if(list == null || list.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		}

//		@GetMapping("/board")
//		@ApiOperation(value="검색조건 게시글 조회")
//		public ResponseEntity<?> list(SearchCondition condition){
//			List<Board> list = boardService.search(condition); 
//			if(list == null || list.size() == 0)
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
//		}

		@GetMapping("/board/{boardId}")
		public ResponseEntity<Board> detail(@PathVariable int boardId){
			Board board = boardService.getBoard(boardId);
			
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		}

		@PostMapping("/board")
		public ResponseEntity<Board> write(@RequestBody Board board){
			boardService.writeBoard(board);
	
			return new ResponseEntity<Board>(board, HttpStatus.CREATED);
		}

		@DeleteMapping("/board/{boardId}")
		public ResponseEntity<Void> delete(@PathVariable int boardId){
			boardService.removeBoard(boardId);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		@ApiIgnore
		@PutMapping("/board")
		public ResponseEntity<Void> update(@RequestBody Board board){
			boardService.modifyBoard(board);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
	
}

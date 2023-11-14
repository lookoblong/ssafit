package com.ssafy.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.dto.VideoBookmark;
import com.ssafy.board.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(tags="영상 컨트롤러")
@CrossOrigin("*")
public class VideoRestController {

	@Autowired
	private VideoService videoService;

	@GetMapping("/video")
	@ApiOperation(value="전체 영상 조회")
	public ResponseEntity<?> list(){
		List<Video> list = videoService.getList();
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/video/{id}")
	@ApiOperation(value="id 해당 영상 조회")
	public ResponseEntity<Video> detail(@PathVariable int id){
		Video video = videoService.getVideo(id);
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	
	@PostMapping("/video")
	@ApiOperation(value="영상 등록")
	public ResponseEntity<Video> write(@RequestBody Video video){
		videoService.writeVideo(video);
		System.out.println("영상 등록!" + video.getVideoTitle());
		return new ResponseEntity<Video>(video, HttpStatus.CREATED);
	}
	
	@PostMapping("/view/{id}")
	@ApiOperation(value="Deatil 방문시 조회수 증가")
	public ResponseEntity<?> increaseViewCnt(@PathVariable int id){
		try {
			videoService.increaseViewCnt(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/video/{id}")
	@ApiOperation(value="id로 영상 삭제")
	public ResponseEntity<Void> delete(@PathVariable int id){
		videoService.removeVideo(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/video/{id}") 
	@ApiOperation(value="id에 해당하는 영상 수정")
	public ResponseEntity<Void> update(@RequestBody Video video){
		videoService.modifyVideo(video);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/video/bookmark/{videoId}")
	@ApiOperation(value="영상 찜하기 (bookmark table에 삽입)")
	public ResponseEntity<Void> bookmarkVideo(HttpSession session, @PathVariable int videoId){
//		String userId = session.getId();
		String userId = "admin";
		VideoBookmark bm = new VideoBookmark();
		bm.setUserId(userId);
		bm.setVideoId(videoId);
		videoService.bookmark(bm);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/video/bookmark/{videoId}")
	@ApiOperation(value="영상 찜하기 해제")
	public ResponseEntity<Void> delete(HttpSession session, @PathVariable int videoId){
//		String userId = session.getId();
		String userId = "admin";
		VideoBookmark bm = new VideoBookmark();
		bm.setUserId(userId);
		bm.setVideoId(videoId);
		videoService.unbookmark(bm);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/user/bookmark")
	@ApiOperation(value="user가 찜한 영상 userId로 가져오기")
	public ResponseEntity<?> findBookmark(HttpSession session){
//		String userId = session.getId();
		String userId = "admin";
		List<String> videoList = videoService.findBookmark(userId);
		if (videoList != null) return new ResponseEntity<List<String>>(videoList, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	} 
	
}

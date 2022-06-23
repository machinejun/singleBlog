package com.singeblog.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singeblog.blog.dto.ResponseDto;
import com.singeblog.blog.model.Board;
import com.singeblog.blog.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/write")
	public ResponseDto<String> writeBoard(@RequestBody Board board){
		if(boardService.writeBoard(board)) {
			return new ResponseDto<String>(HttpStatus.OK.value(), "ok");
		}else {
			return new ResponseDto<String>(HttpStatus.NOT_ACCEPTABLE.value(), "포스팅 실패 다시한번 시도해주세요");
		}
		
	}
}

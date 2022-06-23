package com.main.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.java.dto.BoardSaveRequestDto;
import com.main.java.model.Board;
import com.main.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/","list"})
	public String list(@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable, Model model) {
		// 서비스 객체에 가서 목록 가져와야 함
		Page<Board> boards = boardService.글목록보기(pageable);
		model.addAttribute("boards", boards);
		
		// paging 처리
		//http://localhost:9090/list?page=1
		
		return "list";
	}
	
	@GetMapping({"listPage"})
	@ResponseBody
	public Page<Board> listPage(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC) Pageable pageable, Model model) {
		// 서비스 객체에 가서 목록 가져와야 함
		Page<Board> boards = boardService.글목록보기(pageable);
		model.addAttribute("boards", boards);
		
		// paging 처리
		//http://localhost:9090/list?page=1
		
		return boards;
	}
	
	
	@GetMapping("/saveform")
	public String saveform() {
		return "saveform";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public String save(@RequestBody BoardSaveRequestDto requestDto) {
		// 서비스객체로 가서 db 저장 요청
		boardService.글쓰기(requestDto);	
		return "ok";
	}
	
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) {
		// 데이터 가져오기
		model.addAttribute("board", boardService.글상세보기(id));
		return "detail";
	}
	
	@GetMapping("/updateform/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Board board = boardService.글상세보기(id);
		model.addAttribute("board", board);
		return "updateform";
	}
	
	@PutMapping("/board/{id}")
	@ResponseBody
	public String put(@PathVariable int id, @RequestBody Board board) {
		if(boardService.글업데이트(board)) {
			return "ok";
		}else {
			return "fail";
		}
	}
	
	@DeleteMapping("/board/{id}")
	@ResponseBody
	public String delete(@PathVariable int id) {
		if(boardService.글삭제(id)) {
			return "ok";
		}else {
			return "fail"; 
		}
	}
	
	
	
}

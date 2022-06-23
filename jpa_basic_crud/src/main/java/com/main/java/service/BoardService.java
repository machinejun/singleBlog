package com.main.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.java.dto.BoardSaveRequestDto;
import com.main.java.model.Board;
import com.main.java.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void 글쓰기(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);

	}

	@Transactional
	public Page<Board> 글목록보기(Pageable pageable) {

		return boardRepository.findAll(pageable);
	}
	
	@Transactional
	public Board 글상세보기(int id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException("id 값이 잘못 들어 왔어요");
		});
		// 조회수 증가 + 더티 체킹(트랜잭션 처리한다면 함수가 끝나게 되면 변경사항을 디비에 업데이트 한다.)
		board.setReadCount(board.getReadCount() + 1);
		return board;
	}
	
	@Transactional
	public boolean 글업데이트(Board board) {
		Board boardEntity = boardRepository.findById(board.getId()).orElseThrow(() -> {
			new RuntimeException("해당글은 존재하지 않습니다");
			return null;
		});
		if(boardEntity == null) {
			return false;
		}
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		/*
		 * 더티 체크 하지 않을 때는
		 * boardRepositoty.save(boardEntity);
		 */
		return true;
	}
	
	@Transactional
	public boolean 글삭제(int id) {
		return boardRepository.mDeleteById(id) == 1 ? true : false;
	}

}

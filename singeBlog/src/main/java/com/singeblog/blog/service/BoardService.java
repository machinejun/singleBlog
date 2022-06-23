package com.singeblog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.singeblog.blog.model.Board;
import com.singeblog.blog.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public boolean writeBoard(Board board) {
		try {
			boardRepository.save(board);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}

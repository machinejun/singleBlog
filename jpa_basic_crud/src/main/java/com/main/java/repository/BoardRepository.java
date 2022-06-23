package com.main.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.main.java.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	
	@Modifying // 수정, 삭제, 저장 할 때 모디파이 붙여주어야 한다.
	@Query(value = "DELETE FROM board WHERE id = :id", nativeQuery = true)
	int mDeleteById(int id);
	
	/*
	 * 컬럼을 변경, 서브쿼리
	 */
	
	@Query(value = "SELECT * FROM borad WHERE id = :id", nativeQuery = true)
	Optional<Board> mFindById(int id);
}

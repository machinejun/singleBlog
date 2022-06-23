package com.singeblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singeblog.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}

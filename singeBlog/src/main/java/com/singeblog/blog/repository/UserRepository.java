package com.singeblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singeblog.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String username, String password);
	

}

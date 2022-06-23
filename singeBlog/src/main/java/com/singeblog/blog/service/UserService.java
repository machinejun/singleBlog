package com.singeblog.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.singeblog.blog.model.User;
import com.singeblog.blog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void joinUser(User user) {
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public User loginUser(User user) {
		User result = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(result != null) {
			return result;
		}
		return null;
	}

}

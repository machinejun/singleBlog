package com.singeblog.blog.api;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singeblog.blog.dto.ResponseDto;
import com.singeblog.blog.model.User;
import com.singeblog.blog.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession httpSession;
	
	@PostMapping("/join")
	public ResponseDto<String> joinUser(@RequestBody User user) {
		System.out.println("join 호출됨");
		userService.joinUser(user);
		return new ResponseDto<String>(HttpStatus.OK.value(), "OK");
	}
	
	@ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
	public ResponseDto<String> duplicateUser(SQLIntegrityConstraintViolationException e){
		ResponseDto<String> error = new ResponseDto<String>();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("동일한 유저 아이디가 존재합니다.");
		return error;
	}
	
	@PostMapping("/login")
	public ResponseDto<String> loginUser(@RequestBody User user){
		System.out.println("login 호출됨");
		User loginUser = userService.loginUser(user);
		if(loginUser != null) {
			httpSession.setAttribute("principal", loginUser);
			return new ResponseDto<String>(HttpStatus.OK.value(), "OK");
		}else {
			//406
			return new ResponseDto<String>(HttpStatus.NOT_ACCEPTABLE.value(), "아이디와 비빌번호를 확인해주세요");
		}
		
	}

}

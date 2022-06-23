package com.main.java.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
public class ControllerAdviceM {
	
	@ExceptionHandler(Exception.class)
	public void errorHandle(Exception e) {
		System.out.println(e.getMessage());
		
	}
}

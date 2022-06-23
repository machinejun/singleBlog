package com.singeblog.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingleBlogController {
	
	@Autowired
	private HttpSession httpSession;
	
	
	@GetMapping({"","/"})
	public String mainPage() {
		return "mainPage";
	}
	
	@GetMapping("/user/joinform")
	public String joinPage() {
		return "/user/joinform";
	}
	
	@GetMapping("/user/loginform")
	public String loginPage() {
		return "/user/loginform";
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		httpSession.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/user/writeform")
	public String writePage() {
		httpSession.invalidate();
		return "writePage";
	}
}

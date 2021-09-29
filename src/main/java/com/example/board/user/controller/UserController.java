package com.example.board.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.user.dto.UserInfoDto;
import com.example.board.user.dto.UserLogin;
import com.example.board.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@SessionAttributes("loginUser")
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

	
	// 로그인 페이지 이동
	@GetMapping("/loginPage.do")
	public String loginPage() {
		return "user/login";
	}
	// 로그인 기능
	@PostMapping("/login.do")
	public String login(@ModelAttribute UserLogin u, Model m) {
		
		
		return null;
	}
	// 회원가입 페이지 이동
	@GetMapping("/signUpPage.do")
	public String signUpPage() {
		return "user/signUp";
	}
	// 회원가입 기능
	@PostMapping("/signUp.do")
	@ResponseBody
	public int signUp(@ModelAttribute UserInfoDto u) {
		System.out.println(u);
		int result = userService.signUpUser(u);
		
		return result;
		
	}
	
}

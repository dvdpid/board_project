package com.example.board.user.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.board.controller.BoardController;
import com.example.board.user.dto.UserInfoDto;
import com.example.board.user.dto.UserLogin;
import com.example.board.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Controller
@Slf4j
@SessionAttributes("loginUser")
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	private UserInfoDto userInfoDto = new UserInfoDto();
    private Logger logger = LoggerFactory.getLogger(UserController.class);

	
	// 로그인 페이지 이동
	@GetMapping("/loginPage.do")
	public String loginPage() throws Exception {
		return "user/login";
	}
	// 로그인 기능
	@PostMapping("/login.do")
	@ResponseBody
	public boolean login(@ModelAttribute UserLogin u, Model m,
								 HttpSession session) throws Exception {
		
		UserInfoDto userInfoDto = userService.userId(u);
		
		if(userInfoDto == null) {
			
			return false;
		} else {
			
			// 로그인 성공 처리
			// 세션 생성
//			session.setAttribute("loginUser", userInfoDto);
			m.addAttribute("loginUser", userInfoDto);
			return true;
			
		}
		
	}
	// 회원가입 페이지 이동
	@GetMapping("/signUpPage.do")
	public String signUpPage() {
		return "user/signUp";
	}
	
	
	// 회원가입 기능
	@ResponseBody
	@PostMapping("/signUp.do")
	public int signUp(@Valid @ModelAttribute UserInfoDto u, ModelMap m) throws Exception {
		//	@ModelAttribute 생략 가능
		
		try {
			int result = userService.signUpUser(u);
			return result;
			
		} catch (Exception e) {
			log.debug(e.getMessage());
			return 0;
		}
		
	}
	
	// 아이디 중복 체크
	@GetMapping("/checkId.do")
	@ResponseBody
	public String checkId(@RequestParam("USER_ID") String id) throws Exception {
		
		try {
			int result = userService.checkId(id);
			return result+"";
			
		} catch (Exception e) {
			log.debug(e.getMessage());
			return null;
		}
	}
	// 닉네임 중복 체크
	@GetMapping("/checkNickname.do")
	@ResponseBody
	public String checkNickname(@RequestParam("USER_NICKNAME") String nickname) throws Exception {
		try {
			int result = userService.checkNickname(nickname);
			return result+"";
			
		} catch (Exception e) {
			log.debug(e.getMessage());
			return null;
		}
	}
	
	// 로그아웃은 스프링 시큐리티에서 처리
	
	// 로그아웃 
//	@GetMapping("/logout.do")
//	public String UserLogout(HttpSession session) {
//		session.invalidate();
//		return "user/login";
//	}
//	
}

package com.example.board.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.board.controller.BoardRestController;
import com.example.board.user.dto.UserInfoDto;
import com.example.board.user.dto.UserLogin;
import com.example.board.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
	
	@Autowired
	private final UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	//회원 가입
	public int signUpUser(UserInfoDto u) {
		// spring-security를 통한 비밀번호 암호화를 통해 db에 저장
		String encodePwd = passwordEncoder.encode(u.getUSER_PWD());
		u.setUSER_PWD(encodePwd);
		
		return userMapper.signUpUser(u);
	}


	public UserInfoDto userId(UserLogin u) {
		UserInfoDto userInfoDto = userMapper.userId(u);
		
		if(userInfoDto == null) {
			return null;
		}
		
		if(passwordEncoder.matches(u.getUSER_PWD(), userInfoDto.getUSER_PWD())) {
			return userInfoDto;
		} else {
			return null;
		}
		
	}


	public int checkId(String id) {
		return userMapper.checkId(id);
	}


	public int checkNickname(String nickname) {
		return userMapper.checkNickname(nickname);
	}


	public UserInfoDto selectUser(int uNo) {
		return userMapper.selectUser(uNo);
	}


	public boolean userPwdCheck(int USER_NO, String pwd) {
		
		// 유저 번호에 담겨있는 암호화된 password값 가져오기
		String chkPwd = userMapper.selectPwd(USER_NO);
		
		log.info(pwd);
		
		if(chkPwd == null) {
			return false;
		}
		if(passwordEncoder.matches(pwd, chkPwd)) {
			return true;
		} else {
			return false;
		}
	}


	public int pwdUpdate(UserInfoDto u) {
		
		// 비밀번호 암호화
		String encodePwd = passwordEncoder.encode(u.getUSER_PWD());
		u.setUSER_PWD(encodePwd);
		
		return userMapper.pwdUpdate(u);
	}


	public int userUpdate(UserInfoDto u) {
		return userMapper.userUpdate(u);
	}


	public int deleteUser(int uNo) {
		return userMapper.deleteUser(uNo);
	}
	
}

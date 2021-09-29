package com.example.board.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.user.dto.UserInfoDto;
import com.example.board.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
	
	@Autowired
	private final UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public int signUpUser(UserInfoDto u) {
		// spring-security를 통한 비밀번호 암호화를 통해 db에 저장
		String encodePwd = passwordEncoder.encode(u.getUSER_PWD());
		u.setUSER_PWD(encodePwd);
		
		return userMapper.signUpUser(u);
	}
	
}

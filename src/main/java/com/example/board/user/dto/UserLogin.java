package com.example.board.user.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("userLogin")
public class UserLogin {
	
	// 아이디
	private String USER_ID;
	// 비밀번호
	private String USER_PWD;
	
	
}

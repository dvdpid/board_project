package com.example.board.user.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("userInfo")
public class UserInfoDto {
	
	// 유저 번호 (PK)
	private int USER_NO;
	// private int userNo;
	
	// 유저 아이디 (필수)
	private String USER_ID;
	// private String userId;
	
	// 유저 비밀번호 (필수)
	private String USER_PWD;
	// private int userPwd;
	
	// 유저 닉네임 (필수)
	private String USER_NICKNAME;
	// private int userNickname;
	
	// 유저 핸드폰
	private String USER_PHONE;
	// private String userNo;
	
	// 가입일
	private Date createDate;
	// private Date createDate;
	
	// 수정일
	private Date updateDate;
	// private Date updateDate;
	
	// 탈퇴 Y/N
	private String DELETE_YN;
	// private String deleteYn;
	
	// 탈퇴일
	private Date DELETE_DATE;
	// private Date deleteDate;
	
	
	
}

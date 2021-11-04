package com.example.board.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.user.dto.UserInfoDto;
import com.example.board.user.dto.UserLogin;

@Mapper
public interface UserMapper {

	int signUpUser(UserInfoDto u);

	UserInfoDto userId(UserLogin u);

	int checkId(String id);

	int checkNickname(String nickname);

	UserInfoDto selectUser(int uNo);

	String selectPwd(int USER_NO);

	int pwdUpdate(UserInfoDto u);

	int userUpdate(UserInfoDto u);

	int deleteUser(int uNo);
}

package com.example.board.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.user.dto.UserInfoDto;

@Mapper
public interface UserMapper {

	int signUpUser(UserInfoDto u);
}

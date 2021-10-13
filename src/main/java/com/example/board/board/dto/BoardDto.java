package com.example.board.board.dto;


import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Alias("Board")
public class BoardDto {
	
	// 게시글 번호 (pk)
	private int BOARD_NO;
	// private int boardNo;
	
	//게시글 순번
	private int BOARD_ROW;
	// private int boardRow;
	
	// 게시글 제목
	private String BOARD_TITLE;
	// private String boardTitle;
	
	// 게시글 내용
	private String BOARD_CONTENTS;
	// private String boardContents;
	
	// 게시글 작성자
	private String BOARD_WRITER;
	// private String boardWriter;
	
	// 게시글 작성일
	private Date BOARD_DATE;
	// private Date boardDate;
	
	// 게시글 조회수
	private int BOARD_COUNT;
	// private int boardCount;
	
	// 비회원 닉네임
	private String nmNickName;
	
	// 비회원 비밀번호
	private String nmPassword;
	
	// 게시글 수정일
	private Date updateDate;
	
	// 유저 번호
	private int USER_NO;
	// private int userNo;
}

package com.example.board.web.board.dto;


import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@RequiredArgsConstructor
@ToString
@Alias("Board")
public class BoardDto {
	
	// 게시글 번호
	private int BOARD_NO ;
	// 게시글 제목
	private String BOARD_TITLE;
	// 게시글 내용
	private String BOARD_CONTENTS;
//	// 게시글 작성자
//	private String BOARD_WRITER;
//	// 게시글 작성일
//	private Date CREATE_DATE;
//	// 게시글 수정일
//	private Date MODIFY_DATE;
//	// 게시글 상태
//	private String BOARD_STATUS;
	
}

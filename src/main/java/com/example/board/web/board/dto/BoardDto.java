package com.example.board.web.board.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString

public class BoardDto {
	
	// 게시글 번호
	private long bNo;
	// 게시글 제목
	private String bTitle;
	// 게시글 내용
	private String bContents;
	// 게시글 작성자
	private String bWriter;
	// 게시글 작성일
	private Date bCreateDate;
	// 게시글 수정일
	private Date bModifyDate;
	// 게시글 상태
	private String bStatus;
	
}

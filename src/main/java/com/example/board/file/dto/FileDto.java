package com.example.board.file.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileDto {
	
	// 파일 번호(pk)
	private int file_No;
	// 게시글 번호
	private int board_No;
	// 원본 파일명
	private String origin_Name;
	// 변경 파일명
	private String change_Name;
	// 파일 경로
	private String file_Path;
	// 파일 크기
	private Long file_Size;
	// 삭제 상태
	private String delete_Yn;
	// 파일 생성일
	private Date create_Date;
	// 파일 삭제일
	private Date delete_Date;

}

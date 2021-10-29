package com.example.board.comment.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Alias("Comment")
public class CommentDto {
	
	// 댓글 번호
	private int comment_No;
	// 게시글 번호
	private int board_No;
	// 유저 번호
	private int user_No;
	// 댓글 그룹
	private int comment_Group;
	// 부모 댓글
	private int comment_Parent;
	// 댓글 계층
	private int comment_Depth;
	// 댓글 순서
	private int comment_Order;
	// 댓글 내용
	private String comment_Content;
	// 댓글 작성자
	private String comment_Writer;
	// 댓글 작성일
	private Date create_Date;
	// 댓글 수정일
	private Date update_Date;
	// 삭제일
	private Date delete_Date;
	// 삭제YN
	private String delete_Yn;
	
//		// 댓글 번호
//		private int commentNo;
//		// 게시글 번호
//		private int boardNo;
//		// 유저 번호
//		private int userNo;
//		// 댓글 그룹
//		private int commentGroup;
//		// 부모 댓글
//		private int commentParent;
//		// 댓글 계층
//		private int commentDepth;
//		// 댓글 순서
//		private int commentOrder;
//		// 댓글 내용
//		private String commentContent;
//		// 댓글 작성자
//		private String commentWriter;
//		// 댓글 작성일
//		private Date createDate;
//		// 댓글 수정일
//		private Date updateDate;
//		// 삭제일
//		private Date deleteDate;
//		// 삭제YN
//		private String deleteYn;
		
	
}

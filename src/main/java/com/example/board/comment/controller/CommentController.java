package com.example.board.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.comment.dto.CommentDto;
import com.example.board.comment.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("loginUser")
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService commentService;
	
	
	// 기본 댓글 작성하기
	@PostMapping("insertComment.do")
	@ResponseBody
	public int insertComment(CommentDto commentDto 
							, Model m) throws Exception {
		
		
		try {
			int result = commentService.insertComment(commentDto);
			return result;
			
		} catch (Exception e) {
			log.info(e.getMessage());
			return 0;
		}
	}
	
	// 대댓글 작성하기
	@PostMapping("insertReComment.do")
	@ResponseBody
	public int insertReComment(CommentDto commentDto
								, Model m) throws Exception {
		
		try {
			log.info("대댓글 정보 : " + commentDto);
			
			int result = commentService.insertReComment(commentDto);
			return result;
		} catch (Exception e) {
			log.info(e.getMessage());
			return 0;
		}
		
		
	}
	@PostMapping("updateComment.do")
	@ResponseBody
	public int updateComment(CommentDto commentDto) throws Exception {
		
		try {
			int result = commentService.updateComment(commentDto);
			return result;
		} catch (Exception e) {
			log.info(e.getMessage());
			return 0;
		}
	}
	@PostMapping("deleteComment.do")
	@ResponseBody
	public int deleteComment(CommentDto commentDto) throws Exception {
		try {
			int result = commentService.deleteComment(commentDto);
			return result;
			
		} catch (Exception e) {
			log.info(e.getMessage());
			return 0;
		}
	}
	
}

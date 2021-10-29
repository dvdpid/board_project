package com.example.board.comment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.board.mapper.BoardMapper;
import com.example.board.comment.dto.CommentDto;
import com.example.board.comment.mapper.CommentMapper;
import com.example.board.user.dto.UserInfoDto;

import lombok.RequiredArgsConstructor;
@SessionAttributes("loginUser")
@RequiredArgsConstructor
@Service
public class CommentService {
	private final HttpSession session;
	private final CommentMapper commentMapper;
	
	public int insertComment(CommentDto commentDto) {
		
		int uNo = ((UserInfoDto)session.getAttribute("loginUser")).getUSER_NO();
		commentDto.setUser_No(uNo);
		return commentMapper.insertComment(commentDto);
	}

	public List<CommentDto> cList(int bNo) {
		return commentMapper.cList(bNo);
	}

	public int insertReComment(CommentDto commentDto) {
		// 유저 정보 넣기
		int uNo = ((UserInfoDto)session.getAttribute("loginUser")).getUSER_NO();
		commentDto.setUser_No(uNo);
		// 그룹 마지막 순서를 받기 위한 것
		int order = commentMapper.selectOrder(commentDto);
		int count = commentMapper.selectMatch(commentDto);
		// 계층이 들어온 값이 1보다 크면
		if(commentDto.getComment_Depth()+1 > 1) {
			// 현재 들어온 order랑 db order 가장 높은값이 높거나같으면
			if (commentDto.getComment_Order() + 1 <= order) {
				// 대대댓글일경우 순서재정의를 위한 업데이트 쿼리
				if(count > 0) {
					commentDto.setComment_Order(commentDto.getComment_Order() + count);
					commentMapper.orderUpdate(commentDto);
					return commentMapper.insertReComment(commentDto);
				} else {
					commentMapper.orderUpdate(commentDto);
					return commentMapper.insertReComment(commentDto);
					
				}
			}
		} else {
			commentDto.setComment_Order(order);
			return commentMapper.insertReComment(commentDto);
		}
		return commentMapper.insertReComment(commentDto);
		
	}

	public int updateComment(CommentDto commentDto) {
		return commentMapper.updateComment(commentDto);
	}

	public int deleteComment(CommentDto commentDto) {
		return commentMapper.deleteComment(commentDto);
	}


}

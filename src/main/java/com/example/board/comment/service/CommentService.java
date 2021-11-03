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
		/*
		 *  설계
		 * 1. 대댓글이면 depth +1 , 순서 + 1 증가 시킨다
		 * 2. 대대댓글이면 depth +1 , 순서를 자식수 만큼 증가 시킨다.
		 * 3. 순서를 불러와서 순서보다 큰값들을 전부 +1 증가 시킨다.
		 * 4. 같은 계층에 댓글을 달경우에는 자식수를 구해 순서에 그 자식수 만큼 증가 시킨다.
		 */
		
		
		/*1
		 * 1-1
		 * 	1-1-1 : 1-1 순서를 가지고와 1-1 순서보다 큰값들의 순서를 +1 증가시키고 1-1 의 순서값에 +1값을 집어 넣는다.
		 * 1-2
		 * 1-3
		 *2
		 *3 
		 */
		
		/*
		 * 넘어온 값
		 * group = 1
		 * parent = 1
		 * order = 0
		 * depth = 0
		 */
		
		
			// 유저 정보 넣기
			int uNo = ((UserInfoDto)session.getAttribute("loginUser")).getUSER_NO();
			commentDto.setUser_No(uNo);
			
			// 그룹 마지막 순서를 받기 위한 것
			int order = commentMapper.selectOrder(commentDto);
			
			// 자식수를 구하기 위한 것
			int count = commentMapper.selectMatch(commentDto);
			
			/*
			 * order(순서) = 4
			 * count(자식수) = 4
			 */
			
			
			// 계층이 들어온 값이 +1 한 경우보다 1보다 크면
			if(commentDto.getComment_Depth()+1 > 1) {
				// 현재 들어온 order랑 db order 가장 높은값이 높거나같으면
				if (commentDto.getComment_Order() + 1 <= order) {
					if(count > 0) {
						
						
						commentDto.setComment_Order(commentDto.getComment_Order() + count);
						
						// 대대댓글일경우 순서재정의를 위한 업데이트 쿼리
						commentMapper.orderUpdate(commentDto);
						
						return commentMapper.insertReComment(commentDto);
					} else {
						// 대대댓글일경우 순서재정의를 위한 업데이트 쿼리
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

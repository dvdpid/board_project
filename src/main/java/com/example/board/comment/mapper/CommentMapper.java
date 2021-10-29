package com.example.board.comment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.comment.dto.CommentDto;

@Mapper
public interface CommentMapper {

	int insertComment(CommentDto commentDto);

	List<CommentDto> cList(int bNo);

	int insertReComment(CommentDto commentDto);

	int updateComment(CommentDto commentDto);

	int deleteComment(CommentDto commentDto);

	void orderUpdate(CommentDto commentDto);

	int selectOrder(CommentDto commentDto);

	int selectMatch(CommentDto commentDto);




}

package com.example.board.Repository.Board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.web.board.dto.BoardDto;

@Mapper
public interface BoardRepository {

	List<BoardDto> getBoardList();

}

package com.example.board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.board.dto.BoardDto;
import com.example.board.common.dto.PageDto;

@Mapper
public interface BoardMapper {

	

	int getListCount();

	List<BoardDto> getBoardList(PageDto pageDto);

	int insertBoard(BoardDto b);

	BoardDto boardSelect(int bNo);

	int updateBoard(BoardDto b);

	void boardCount(int bNo);

	int deleteBoard(BoardDto b);

	int nmInsertBoard(BoardDto b);

	int nmUpdateBoard(BoardDto b);

	int searchGetListCount(PageDto pageDto);

	List<BoardDto> getSearchBoardList(PageDto pageDto);


}

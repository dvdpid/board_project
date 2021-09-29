package com.example.board.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardMapper boardMapper;
	
	public List<BoardDto> getBoardList() {
		return boardMapper.getBoardList();
	}
	
}

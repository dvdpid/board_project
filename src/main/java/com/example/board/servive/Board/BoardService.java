package com.example.board.servive.Board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.Repository.Board.BoardRepository;
import com.example.board.web.board.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public List<BoardDto> getBoardList() {
		return boardRepository.getBoardList();
	}
	
}

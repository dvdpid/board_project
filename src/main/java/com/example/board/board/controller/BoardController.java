package com.example.board.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class BoardController {
	
	private final BoardService boardService;
	
	
	@RequestMapping("/")
	public String Test(Model model) {
		
		List<BoardDto> bList = boardService.getBoardList();
		model.addAttribute("bList", bList);
		return "/board/board";
	}
}

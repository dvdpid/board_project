package com.example.board.web.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class boardController {
	
	@RequestMapping("/")
	public String Test() {
		return "/board/board";
	}
}

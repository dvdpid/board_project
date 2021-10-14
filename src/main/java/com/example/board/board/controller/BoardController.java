package com.example.board.board.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.service.BoardService;
import com.example.board.common.dto.PageDto;
import com.example.board.user.dto.UserInfoDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("loginUser")
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardController {
	
	private final BoardService boardService;
	private final HttpSession session;
	// 게시판 리스트
	@RequestMapping("/")
	public String boardList(Model model
							, PageDto pageDto
							, @RequestParam(value="nowPage", required=false) String nowPage
							, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {

		
			int total = boardService.getListCount();
			
			if (nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			} else if (nowPage == null) {
				nowPage = "1";
			} else if (cntPerPage == null) { 
				cntPerPage = "10";
			}
			
			
			pageDto = new PageDto(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
			
			List<BoardDto> bList = boardService.getBoardList(pageDto);
			
			
			
			model.addAttribute("paging", pageDto);
			model.addAttribute("bList", bList);
			
			return "/board/board";

		
	}
	
	// 게시글 작성 페이지 이동
	@GetMapping("/insertPage.bo")
	public String insertPage() {
		return "board/insertBoard";
	}
	
	
	
	// 게시글 상세조회
	@GetMapping("/boardDetail.bo")
	public String boardDetail(@RequestParam(value="nowPage", required=false)String nowPage,
							 @RequestParam("BOARD_NO") int bNo,
								Model m ) throws Exception {
		
		BoardDto bDetail = boardService.boardSelect(bNo);
		
		// 조회수 증가
		try {
			if(bDetail.getUSER_NO() != ((UserInfoDto)session.getAttribute("loginUser")).getUSER_NO()) {
				boardService.boardCount(bNo);
			}
		} catch (NullPointerException e) {
			log.debug(e.getMessage());
		}
		
		m.addAttribute("nowPage", nowPage).addAttribute("bDetail", bDetail);
		
		return "/board/boardDetail";
		
	}
	
	// 게시글 수정 페이지로 이동
	@GetMapping("/updatePage.bo")
	public String updatePage(@RequestParam("bNo") int bNo, Model m, 
							 @RequestParam(value="nowPage", required=false)String nowPage){
		
		BoardDto b = boardService.boardSelect(bNo);
		m.addAttribute("b", b);
		m.addAttribute("nowPage", nowPage);
		
		
		return "/board/boardUpdate";
	}

	
}

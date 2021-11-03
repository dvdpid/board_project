package com.example.board.board.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.service.BoardService;
import com.example.board.comment.dto.CommentDto;
import com.example.board.comment.service.CommentService;
import com.example.board.common.dto.PageDto;
import com.example.board.file.dto.FileDto;
import com.example.board.file.service.FileService;
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
	private final CommentService commentService;
	private final FileService fileService;
	private final HttpSession session;
	// 게시판 리스트
	@RequestMapping("/")
	public String boardList(Model model
							, PageDto pageDto
							, @RequestParam(value="nowPage", required=false) String nowPage
							, @RequestParam(value="cntPerPage", required=false)String cntPerPage
							, @RequestParam(value="searchType", required=false)String searchType
							, @RequestParam(value="keyword", required=false)String keyword) throws Exception {

		
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
			
			pageDto.setSearchType(searchType);
			pageDto.setKeyword(keyword);
			
			
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
	public String boardDetail(@RequestParam(value="nowPage", required=false)String nowPage
							, @RequestParam("BOARD_NO") int bNo
							, @RequestParam(value="searchType", required=false)String searchType
							, @RequestParam(value="keyword", required=false)String keyword
							, Model m ) throws Exception {
		
		// 게시글 정보
		BoardDto bDetail = boardService.boardSelect(bNo);
		
		// 댓글 리스트
		List<CommentDto> cList = commentService.cList(bNo);
		
		// 이미지 리스트
		List<FileDto> fList = fileService.fList(bNo);
		
		
		// 조회수 증가
		try {
			if(bDetail.getUSER_NO() != ((UserInfoDto)session.getAttribute("loginUser")).getUSER_NO()) {
				boardService.boardCount(bNo);
			}
		} catch (NullPointerException e) {
			log.debug(e.getMessage());
		}
		
		m.addAttribute("nowPage", nowPage);
		m.addAttribute("bDetail", bDetail);
		m.addAttribute("searchType", searchType);
		m.addAttribute("keyword", keyword);
		m.addAttribute("cList", cList);
		m.addAttribute("fList", fList);
		
		return "/board/boardDetail";
		
	}
	
	// 게시글 수정 페이지로 이동
	@PostMapping("/updatePage.bo")
	public String updatePage(@ModelAttribute BoardDto b
							, Model m
							, @RequestParam(value="nowPage", required=false)String nowPage){
		
		m.addAttribute("b", b);
		m.addAttribute("nowPage", nowPage);
		
		
		return "/board/boardUpdate";
	}
	
	// 게시판 검색기능
	@GetMapping("/searchBoard.bo")
	public String searchBoard(PageDto pageDto
							, Model model
							, @RequestParam(value="nowPage", required=false) String nowPage
							, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws Exception {
		
		String keyword = pageDto.getKeyword();
		String searchType =  pageDto.getSearchType();
		
		
		int total = boardService.searchGetListCount(pageDto);
		
		
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		
		
		pageDto = new PageDto(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		pageDto.setSearchType(searchType);
		pageDto.setKeyword(keyword);
		
		
		List<BoardDto> sbList = boardService.getSearchBoardList(pageDto);
		
		
		
		model.addAttribute("paging", pageDto);
		model.addAttribute("sbList", sbList);
		model.addAttribute("total", total);
		
		
		return "/board/board";
	}
	

	
}

package com.example.board.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SessionAttributes("loginUser")
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardRestController {
	
	private final BoardService boardService;
	private final HttpSession session;
	
		// 게시글 작성
		@PostMapping("/insertBoard.bo")
		@ResponseBody
		public int insertBoard(@ModelAttribute BoardDto b) throws Exception {
			
			try {
				int result = boardService.insertBoard(b);
				return result;
				
			} catch (Exception e) {
				log.info(e.getMessage());
				return 0;
			}
			
		}
	
		// 비회원 게시글 작성
		@PostMapping("/nmInsertBoard.bo")
		@ResponseBody
		public int nmInsertBoard(@ModelAttribute BoardDto b) throws Exception {
			
			try {
				int result = boardService.nmInsertBoard(b);
				return result;
				
			} catch (Exception e) {
				log.debug(e.getMessage());
				return 0;
			}
			
		}
		
		// 게시글 수정
		@PostMapping("/updateBoard.bo")
		@ResponseBody
		public int updateBoard(@ModelAttribute BoardDto b
								, @RequestParam(value="nowPage", required=false)String nowPage
								, Model m) throws Exception {
			
			try {
				int result = boardService.updateBoard(b);
				m.addAttribute("nowPage", nowPage);
				return result;
			} catch (Exception e) {
				log.debug(e.getMessage());
				return 0;
			}
			
		}
		// 게시글 삭제
		@PostMapping("/deleteBoard.bo")
		@ResponseBody
		public int deleteBoard(@ModelAttribute BoardDto b) throws Exception {
			
			try {
				int result = boardService.deleteBoard(b);
				return result;
				
			} catch (Exception e) {
				log.debug(e.getMessage());
				return 0;
			}
		}
		
		
		// 비회원 수정 버튼 누를시 비밀번호 확인 페이지로 이동
		@PostMapping("/mmPwdCheck.bo")
		public boolean mmPwdCheck(@ModelAttribute BoardDto b, Model m) throws Exception {
			try {
				log.info("비밀번호 확인 : " + b.getNmPassword());
				boolean result = boardService.mmPwdCheck(b);
				return result;
			} catch (Exception e) {
				log.debug(e.getMessage());
				return false;
			}
		}
		
		// 비회원 수정 기능
		@PostMapping("/nmUpdateBoard.bo")
		public int nmUpdateBoard(@ModelAttribute BoardDto b
								, @RequestParam(value="nowPage", required=false)String nowPage
								, Model m) throws Exception {
			
			try {
				int result = boardService.nmUpdateBoard(b);
				m.addAttribute("nowPage", nowPage);
				return result;
				
			} catch (Exception e) {
				log.debug(e.getMessage());
				return 0;
			}
		}
		
	
}

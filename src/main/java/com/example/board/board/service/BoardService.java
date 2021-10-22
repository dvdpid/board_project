package com.example.board.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.mapper.BoardMapper;
import com.example.board.common.dto.PageDto;
import com.example.board.user.dto.UserInfoDto;

import lombok.RequiredArgsConstructor;
@SessionAttributes("loginUser")
@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final HttpSession session;
	private final BoardMapper boardMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public int getListCount() {
		return boardMapper.getListCount();
	}
	
	public List<BoardDto> getBoardList(PageDto pageDto) {
		
		return boardMapper.getBoardList(pageDto);
	}

	public int insertBoard(BoardDto b) {
		
		// 세션에 있는 유저 번호
		int uNo = ((UserInfoDto)session.getAttribute("loginUser")).getUSER_NO();
		b.setUSER_NO(uNo);
		
		return boardMapper.insertBoard(b);
	}

	public BoardDto boardSelect(int bNo) {
		
		return boardMapper.boardSelect(bNo);
	}

	public int updateBoard(BoardDto b) {
		return boardMapper.updateBoard(b);
	}

	public void boardCount(int bNo) {
		boardMapper.boardCount(bNo);
		
	}

	public int deleteBoard(BoardDto b) {
		return boardMapper.deleteBoard(b);
	}

	public int nmInsertBoard(BoardDto b) {
		// spring-security를 통한 비밀번호 암호화를 통해 db에 저장
		String encodePwd = passwordEncoder.encode(b.getNmPassword());
		b.setNmPassword(encodePwd);
		
		return boardMapper.nmInsertBoard(b);
	}

	public boolean mmPwdCheck(BoardDto b) {
		
		int bNo = b.getBOARD_NO();
		BoardDto boardDto = boardMapper.boardSelect(bNo);
		
		if(boardDto == null) {
			return false;
		}
		if(passwordEncoder.matches(b.getNmPassword(), boardDto.getNmPassword())){
			return true;
		} else {
			return false;
		}
		
		
	}

	public int nmUpdateBoard(BoardDto b) {
		String encodePwd = passwordEncoder.encode(b.getNmPassword());
		b.setNmPassword(encodePwd);
		
		return boardMapper.nmUpdateBoard(b);
	}

	public int searchGetListCount(PageDto pageDto) {
		return boardMapper.searchGetListCount(pageDto);
	}

	public List<BoardDto> getSearchBoardList(PageDto pageDto) {
		return boardMapper.getSearchBoardList(pageDto);
	}

	
}

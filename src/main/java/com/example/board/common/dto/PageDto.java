package com.example.board.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PageDto {
	
	
	// 현재 페이지
	private int nowPage;
	// 시작 페이지
	private int startPage;
	// 끝 페이지
	private int endPage;
	// 게시글 총 갯수
	private int total;
	// 페이지당 글 갯수
	private int cntPerPage;
	// 마지막 페이지
	private int lastPage;
	// sql문에 쓸 start
	private int start = 0;
	// sql문에 쓸 end
	private int end;
	// 보여질 게시글 수
	private int cntPage = 10;
	
	
	/* 
	 * mybatis는 한 가지 자료형밖에 처리를 못함
	 * 컨트롤러단에서 서비스단으로 던지는 객체 개수는 한개여야 함.
	 * 그래서 pageDto에 뭉쳐서 보내기 위해 검색 필드를 넣음
	*/
	// 검색 타입(제목, 내용, 작성자)
	private String searchType;
	// 검색 내용
	private String keyword;
		
	
	
	public PageDto(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
	}
	
	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage);
	}
	
	
	
}

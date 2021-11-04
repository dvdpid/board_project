package com.example.board.file.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.board.controller.BoardRestController;
import com.example.board.file.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequiredArgsConstructor
public class FileController {
	private final FileService fileService;
	
	// 파일 삽입
	@PostMapping("insertFile.do")
	public String insertFile(@RequestParam("board_No") int board_No,
						   	 @RequestParam("files") List<MultipartFile> fileList) throws Exception {
		
		/**
		 * 원본 파일명과 저장 파일명을 구분하는 이유
		 * os에 따라 저장되지 않거나 파일명이 바뀌는 이슈가 발생.
		 * 윈도우의 경우, 동일한 파일 이름으로 저장할 때 파일 이름 뒤에 숫자가 붙음
		 * 이와 같이 번호가 붙은 상태로 저장되면 파일을 못찾기때문에 구분한다.
		 */
		
		int result = fileService.insertFile(fileList, board_No);
		
		if(result>0) {
			return "redirect:/";
		} else {
			return "error/errorpage";
		}
	}
	// 지정 파일 삭제
	@GetMapping("deleteFile.do")
	@ResponseBody
	public int deleteFile(@RequestParam("file_No") int fNo) {
		
		try {
			int result = fileService.deleteFile(fNo);
			if(result > 0) {
				return result;
			} else {
				return 0;
			}
		} catch (Exception e) {
			log.debug(e.getMessage());
			return 0;
		}
	}
}

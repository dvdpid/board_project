package com.example.board.file.service;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.file.dto.FileDto;
import com.example.board.file.mapper.FileMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileService {
	
	private final FileMapper fileMapper;
	
	/** 오늘 날짜를 계산해서 파일경로에 넣어주기 위해*/
	private final String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));

	/** 파일경로 
	 * C:\Users\dvdpi\DEV\board\src\main\resources
	 * */
	private final String uploadPath = Paths.get("C:", "Users", "dvdpi", "DEV", "board", "src", "main", "resources", today).toString();
	
	
	/**
	 * 파일명을 처리할 랜덤 문자열 반환
	 */
	private final String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	public void insertFile(List<MultipartFile> fileList, int board_No) {
		
		/** 파일경로에 해당하는 디렉터리가 존재하지 않으면, 부모 디렉터리를 포함한 모든 디렉터리를 생성 */
		File dir = new File(uploadPath);
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
		/** 파일 개수만큼 forEach 실행 */
		for (MultipartFile file : fileList) {
			try {
				/** 파일 확장자 구하기 */
				final String extension = FilenameUtils.getExtension(file.getOriginalFilename());
				/** 로컬에 저장할 파일명 (랜덤 문자열 + 확장자) */
				final String saveName = getRandomString() + "." + extension;
				
				/** 파일경로에 파일 생성 */
				File target = new File(uploadPath, saveName);
				file.transferTo(target);
				
				/** 파일 정보 저장 */
				FileDto f = new FileDto();
				f.setBoard_No(board_No);
				f.setOrigin_Name(file.getOriginalFilename());
				f.setChange_Name(saveName);
				f.setFile_Size(file.getSize());
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
	
	
}

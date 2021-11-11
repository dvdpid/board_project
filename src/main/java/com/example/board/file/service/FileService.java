package com.example.board.file.service;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.file.dto.FileDto;
import com.example.board.file.mapper.FileMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service
public class FileService {
	
	private final FileMapper fileMapper;
	
	/** 오늘 날짜를 계산해서 파일경로에 넣어주기 위해*/
	private final String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));

	/** 파일경로 설정을 위한 값
	 * C:\Users\dvdpi\DEV\board\src\main\resources
	 * C:\Users\dvdpi\git\board_project2\src\main\resources\static\images
	 * */
//	private final String uploadPath = Paths.get("C:", "Users", "dvdpi", "DEV", "board", "src", "main", "resources", "static", "images", today).toString();
//	private final String uploadPath = Paths.get("C:", "Users", "dvdpi", "git", "board_project4", "src", "main", "resources", "static", "images",today).toString();
	private final String uploadPath = Paths.get("C:", "Users", "dvdpi", "git", "board_project5", "src", "main", "resources", "static", "images", today).toString();
	
	/**
	 * 이클립스는 로컬에서 실행되는 경로(배포경로)와 업로드 경로(workspace)가 다르기 때문에 ​이미지를 바로 찾지 못한다.
	 * 
	 * */
	
	
	
	/**
	 * 원본 파일명과 저장 파일명을 구분하는 이유
	 * os에 따라 저장되지 않거나 파일명이 바뀌는 이슈가 발생.
	 * 윈도우의 경우, 동일한 파일 이름으로 저장할 때 파일 이름 뒤에 숫자가 붙음
	 * ex) plateer.jpg , plateer(1).jpg
	 * 이와 같이 번호가 붙은 상태로 저장되면 파일을 못찾기때문에 구분한다.
	 */
	
	
	/**
	 * 파일명을 처리할 랜덤 문자열 반환
	 * UUID : 네트워크 상에서 서로 모르는 개체들을 식별하고 구별하기 위해서
	 * 고유성을 완벽하게 보장할 수는 없지만 실제 사용상에서 중복될 가능성이 거의 없다고 인정
	 */
	private final String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/** 파일정보 insert*/
	public int insertFile(List<MultipartFile> fileList, int board_No) {
		/** 파일 정보를 담을 빈 리스트 */
		List<FileDto> attachList = new ArrayList<>();
		
		
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
				
				/** 지정한 파일경로에 파일 생성 */
				File target = new File(uploadPath, saveName);
				file.transferTo(target);
				
				/** 파일 정보 저장 */
				FileDto f = new FileDto();
				f.setBoard_No(board_No);
				f.setOrigin_Name(file.getOriginalFilename());
				f.setChange_Name(saveName);
				f.setFile_Path("images/"+today);
				f.setFile_Size(file.getSize());
				
				/** 빈 리스트에 값 넣어주기*/
				attachList.add(f);
				
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
			
		}
		
		log.info("파일정보 확인하기 : " +attachList);
		return fileMapper.insertFile(attachList);
		
		
	}

	/** 파일 리스트 불러오기*/
	public List<FileDto> fList(int bNo) {
		return fileMapper.fList(bNo);
	}
	
	
	/** 파일 삭제 (update)
	 * 가져온 file_no 로 해당 파일 delete_yn = 'Y' 로 변경
	 * */
	public int deleteFile(int fNo) {
		return fileMapper.deleteFile(fNo);
	}
}

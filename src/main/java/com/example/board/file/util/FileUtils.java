/*
 * package com.example.board.file.util;
 * 
 * import java.io.File; import java.io.IOException; import java.nio.file.Paths;
 * import java.time.LocalDate; import java.time.format.DateTimeFormatter; import
 * java.util.ArrayList; import java.util.Collections; import java.util.List;
 * import java.util.UUID;
 * 
 * import org.apache.commons.io.FilenameUtils; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.example.board.comment.controller.CommentController; import
 * com.example.board.file.dto.fileDto;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 * @Slf4j
 * 
 * @Component public class FileUtils {
 * 
 * 
 *//** 오늘 날짜 */
/*
 * private final String today =
 * LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
 * 
 *//** 업로드 경로 */
/*
*//** C:\Users\dvdpi\DEV\board\src\main\resources\static\images */
/*
 * private final String uploadPath = Paths.get("C:", "Users", "DEV", "board" ,
 * "src" , "main" , "resources" , "static" , today).toString();
 * 
 *//**
	 * 서버에 생성할 파일명을 처리할 랜덤 문자열 반환
	 *//*
		 * private final String getRandomString() { return
		 * UUID.randomUUID().toString().replaceAll("-", ""); }
		 * 
		 * public List<fileDto> uploadFiles(MultipartFile[] files, int board_No) throws
		 * Exception {
		 * 
		 * 파일이 비어있으면 비어있는 리스트 반환 if (files[0].getSize() < 1) { return
		 * Collections.emptyList(); }
		 * 
		 * 업로드 파일 정보를 담을 비어있는 리스트 List<fileDto> fileList = new ArrayList<>();
		 * 
		 * uploadPath에 해당하는 디렉터리가 존재하지 않으면, 부모 디렉터리를 포함한 모든 디렉터리를 생성 File dir = new
		 * File(uploadPath); // 경로 if (dir.exists() == false) { dir.mkdirs(); }
		 * 
		 * 파일 개수만큼 forEach 실행 for (MultipartFile file : files) { try { 파일 확장자 final
		 * String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		 * 서버에 저장할 파일명 (랜덤 문자열 + 확장자) final String saveName = getRandomString() + "." +
		 * extension;
		 * 
		 * 업로드 경로에 saveName과 동일한 이름을 가진 파일 생성 File target = new File(uploadPath,
		 * saveName); file.transferTo(target);
		 * 
		 * 파일 정보 저장 fileDto attach = new fileDto(); attach.setBoard_No(board_No);
		 * attach.setOrigin_Name(file.getOriginalFilename());
		 * attach.setChange_Name(saveName); attach.setFile_Size(file.getSize());
		 * 
		 * 파일 정보 추가 fileList.add(attach);
		 * 
		 * } catch (IOException e) { log.debug(e.getMessage());
		 * 
		 * } catch (Exception e) { log.debug(e.getMessage()); } } // end of for
		 * 
		 * return fileList; }
		 * 
		 * }
		 */
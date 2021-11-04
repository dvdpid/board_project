package com.example.board.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.file.dto.FileDto;

@Mapper
public interface FileMapper {

	int insertFile(List<FileDto> attachList);

	List<FileDto> fList(int bNo);

	int deleteFile(int fNo);
	
}

package com.example.board.servive.User;

import org.springframework.stereotype.Service;

import com.example.board.Repository.User.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	
}

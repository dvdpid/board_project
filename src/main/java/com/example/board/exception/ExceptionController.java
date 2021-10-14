package com.example.board.exception;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errormv(Exception ex) {
		ModelAndView mdoelAndView = new ModelAndView();
		mdoelAndView.setViewName("/error/errorpage");
		mdoelAndView.addObject("exception", ex);
		
		
		return mdoelAndView;
	}
	
}

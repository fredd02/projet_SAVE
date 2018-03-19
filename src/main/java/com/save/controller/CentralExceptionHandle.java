package com.save.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.save.web.NotFoundException;

@ControllerAdvice
public class CentralExceptionHandle {

	@ExceptionHandler(NotFoundException.class)
	private ModelAndView notFoundHandler(HttpServletRequest req, Exception e) {
		ModelAndView m = new ModelAndView();
		m.addObject("exception", e);
		m.addObject("url", req.getRequestURL());
		m.setViewName("error");
		return m;
	}

}

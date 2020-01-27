package com.bcits.springmvc1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bcits.springmvc1.customexceptions.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(EmployeeException.class)
	public String handleEmployeeException(EmployeeException empEx, HttpServletRequest req) {
		String errmsg = empEx.getMessage();
		req.setAttribute("errmsg", errmsg);
		return "errorpage";
	}

}

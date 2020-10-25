package com.example.demo.errors;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(TaskNotFoundException.class)
	public void HandleTaskNotFound(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.NOT_FOUND.value());
	}
	
	@ExceptionHandler(TaskAlreadyExistsException.class)
	public void HandleTaskAlreadyExists(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.BAD_REQUEST.value());
	}

}

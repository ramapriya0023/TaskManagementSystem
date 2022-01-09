package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(TaskNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleTaskNotFoundException(TaskNotFoundException errorResponse){
		ExceptionResponse response=new ExceptionResponse();
		  response.setErrorCode(HttpStatus.BAD_REQUEST.name());
		  response.setErrorMessage(errorResponse.getMessage());
		  response.setTimestamp(LocalDateTime.now());
		 
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		
	}
}

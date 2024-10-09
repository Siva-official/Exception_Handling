package com.exception.globalexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exception.customexception.ControllerException;
import com.exception.customexception.EmptyStudentList;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmptyStudentList.class)
	public ResponseEntity<?> handleEmptyStudentList(EmptyStudentList ex){
		return new ResponseEntity<>(ex.getErrorMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ControllerException.class)
	public ResponseEntity<?> handleControllerException(ControllerException exception){
		return new ResponseEntity<>(exception.getErrorMessage(),HttpStatus.NOT_FOUND);
	}
	
	

}

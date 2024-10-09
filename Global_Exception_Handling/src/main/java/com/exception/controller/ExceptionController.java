package com.exception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.customexception.ControllerException;
import com.exception.entity.Student;
import com.exception.service.ExceptionSrervice;

@RestController
@RequestMapping("/api")
public class ExceptionController {

	@Autowired
	ExceptionSrervice exceptionSrervice;

	@PostMapping("/savedata")
	public ResponseEntity<?> saveStudentdata() {
		return exceptionSrervice.saveStudentData();
	}

	@GetMapping("/getdata")
	public ResponseEntity<?> getStudentData() {
		return exceptionSrervice.getStudentData();
	}
	
	
	
	/**
	 * 
	 * @param id
	 * @return
	 * /getstudent/{id} ,  /getstudent/{rollNo}
	 * In this method we are throwing custom exception(ControllerException) which is handle in global exception class .
	 * We can use this Custom exception(ControllerException ) in  methods present in controller.
	 * No need to handle this ControllerException  in all methods just we can throw wherever we what it will re direct GlobalExceptionHandler.
	 * 
	 */
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<?> getStudnet(@PathVariable  long id ){
		Student student = new Student();
		try {
			 student = exceptionSrervice.getStudent(id);
	         String name = student.getStName();
		} catch (Exception e) {
			throw new ControllerException("603","Exception in Controller getStudnet() method");
		}
		return new  ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@GetMapping("/getstudent/{rollNo}")
	public ResponseEntity<?> getStudnetByRollNo(@PathVariable  String rollNo ){
		Student student = new Student();
		try {
			 student = exceptionSrervice.getStudnetByRollNo(rollNo);
	         String name = student.getStName();
		} catch (Exception e) {
			throw new ControllerException("603","Exception in Controller getStudnetByRollNo() method");
		}
		return new  ResponseEntity<Student>(student,HttpStatus.OK);
	}
	

}

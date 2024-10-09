package com.exception.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exception.customexception.EmptyStudentList;
import com.exception.entity.Student;

@Service
public class ExceptionSrervice {
	List<Student> students = new ArrayList<>();

	public ResponseEntity<?> saveStudentData() {
		List<Student> students1 = Arrays.asList(new Student(121, "John", "A31", 12000.0),
				new Student(122, "James", "A32", 15000.0), new Student(123, "Steven", "A34", 15000.0));
		students.addAll(students1);
		return new ResponseEntity<String>("Data saved ..!!!", HttpStatus.OK);

	}

	/**
	 * getStudentData()
	 *  In this method we are throwing custom exception(EmptyStudentList) which is handle in global exception class .
     * We can use this Custom exception(EmptyStudentList ) in all  methods present application
     * No need to handle this EmptyStudentList  in all methods just we can throw wherever we want it will re-direct to GlobalExceptionHandler.
	 */
	public ResponseEntity<?> getStudentData() {
		if (students.isEmpty()) {
			throw new EmptyStudentList("601", "No data found in Student list ,Method getStudentData()");
		}
		return ResponseEntity.ok(students);
	}

	
	public Student getStudent(long id) throws Exception {
		return students.stream().filter(a -> (a.getStId() == id)).findFirst().orElse(null);
//		  Student student = students.stream().filter(a->(a.getStId() ==id)).findFirst().get(); return student;
		 
	}

	public Student getStudnetByRollNo(String rollNo) {
			return students.stream().filter(a -> (a.getStRollNo().equals(rollNo))).findFirst().orElse(null);
		}
}

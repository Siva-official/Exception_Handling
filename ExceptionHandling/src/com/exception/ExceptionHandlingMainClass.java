package com.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.exception.customexception.EmptyListException;
import com.exception.customexception.NoDataFoundException;

public class ExceptionHandlingMainClass {
	
	private static void validateData(Employee employee) {
		if (employee.getEmId() <= 0) {
			throw new NoDataFoundException("601", "Validation failed No data found in object "); // CustomException
		}
	}

	private void validateEmployeeList(List<Employee> empList) {
		if (empList.isEmpty()) {
			throw new EmptyListException("602", "No data found in list");
		}
	}
	
	
	
	//Throws Example
	
	private void readFile() throws FileNotFoundException {
		/**
		 * This Statement throws FileNotFoundException at compile time only .There may be a chance to file not present at destination path 
		 * 
		 * Here we are throwing FileNotFoundException but we need to handle this exception in delegated method
		 */
		FileReader  fileReader = new FileReader("test.txt"); 
		System.out.println(fileReader);
	}
	
	
	
	
	public static void main(String[] args) {
		
		/**
		 * 
		 * We can handle exceptions in two ways 
		 * 1. By using try_catch
		 * 2. By using throws keyword
		 * 
		 * Note : Even if we are throwing exception by using throws keyword at the end we need to handle that exception by using try_catch
		 * 
		 * 
		 */
		ExceptionHandlingMainClass custObj = new ExceptionHandlingMainClass();
		//Object creation
		Employee employee = new Employee();
		
		//Setting data into list 
		List<Employee> listEmps = Arrays.asList(new Employee("James", 101, 25000.0, "Associate Software Engineer"),
            	new Employee("Tony", 102, 35000.0, "SDE 1"),
            	new Employee("Ram", 103, 50000.0, "SDE 2"));
		
		
		
		/**
		 * 1. By using try_catch ...........!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 * 
		 * ArithmeticException handling
		 */

		try {
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception handled");
		}

		/**
		 * NullPointerException handling
		 */

		String message = null;
		try {
			System.out.println(message.length());
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception handled");
		}

		/**
		 * 2. By using throws keyword ...........!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
		try {
			custObj.readFile();
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception handled by using Throws keyword ");
		}
		
		/**
		 * Custom Exception Handling.......!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 */

		/**
		 * Handling custom exception (NoDataFoundException) by using try_catch
		 */

		// try_catch Example

		try {
			// Invoke method
			validateData(employee); // this throwing exception.
		} catch (NoDataFoundException e) {
			System.out.println(e.getErrorCode() + " " + e.getErrorMessage());
		}

		/**
		 * Handling custom exception (EmptyListException) by using try_catch
		 */
		try {
			custObj.validateEmployeeList(listEmps);
		} catch (EmptyListException e) {
			System.out.println(e.getErrorCode() + " " + e.getErrorMessage());
		}
		
		
		/**
		 * try with finally 
		 * 
		 * Note: Finally block will executes in normal termination and abnormal termination also 
		 * Basically we use finally for close resources 
		 */
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println(10/0);
			String name = scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Exception in try block ...!!!!");
		}finally {
			scanner.close();
			System.out.println("Resources are closed successfully");
		}
		
	/**
	 * try with resources
	 * The try with resource will automatically close resources inn both normal and abnormal termination 
	 */
		try(Scanner scanner2 = new Scanner(System.in)){
			System.out.println(message.length());
		}catch (Exception e) {
			System.out.println("Try with resource handled ....!!!!!!");
		}
		
		
		
		/**
		 *try with finally
		 *
		 *We can use without try finally without catch block 
		 */
		try {
//			System.out.println(10/0);
		} finally {
			System.out.println("Always executes finally block ");
		}
		
		/**
		 *try with multiple catch blocks
		 *
		 * We can use one try and multiple catch block but we can't create try after try without catch
		 * 
		 * Note : Catch block order should be child to parent .. you can check below.  
		 * 
		 */
		
		try {
			System.out.println(10/0);
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception handled in multiple Catch blocks ..!!!!");
		}catch (Exception e) {
			System.out.println("Exception handled by Exception class ..!!!!");
		}
		
		
		
		/**
		 * we can crate nested try_catch also
		 * 
		 */
		/**
		 *  Inside try block
		 */
		try {
			try {
				try {

				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		/**
		 * Inside catch block
		 */
		try {

		} catch (Exception e) {
			// TODO: handle exception
			try {

			} catch (Exception e2) {
				// TODO: handle exception
				try {

				} catch (Exception e3) {
					// TODO: handle exception
				}
			}
		}

	}

}

package com.learning.exception;

public class DepartmentNotFoundException extends RuntimeException{
	public DepartmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public DepartmentNotFoundException(String message) {
		super(message);
	}
}

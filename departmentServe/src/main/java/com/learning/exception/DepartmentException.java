package com.learning.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class DepartmentException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;	
}

package com.learning.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ApiResponseDto {
	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;
}

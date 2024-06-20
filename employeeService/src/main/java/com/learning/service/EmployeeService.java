package com.learning.service;

import java.util.List;
import java.util.Map;

import com.learning.dto.ApiResponseDto;
import com.learning.dto.DepartmentDto;
import com.learning.dto.EmployeeDto;
import com.learning.entity.Employee;

public interface EmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public ApiResponseDto getEmployeeDetails(Integer employeeId);
	public Map<Map<Integer, DepartmentDto>, Map<Integer, List<Employee>>> getAllEmployees();
	public DepartmentDto getDepartmetDetails(Integer departmentId);
	public EmployeeDto updateEmployee(Integer employeeId,EmployeeDto employeeDto);
	public String getLocalDateTime();
	public String softDeleteEmployeeById(Integer employeeId);
	public String softDeleteDepartmentEmployees(Integer departmentId);
	public List<EmployeeDto> getOneDepartmentEmployees(Integer departmentId);
	public EmployeeDto findByEmployeeFirstNameAndEmployeeLirstName(String employeeFirstName,String employeeLasttName);
}

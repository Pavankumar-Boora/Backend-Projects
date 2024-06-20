package com.learning.service;

import java.util.List;
import java.util.Map;

import com.learning.dto.DepartmentDto;
import com.learning.dto.EmployeeDto;
import com.learning.entity.Department;

public interface DepartmentService {
	public DepartmentDto createDepartment(DepartmentDto departmentDto);
	public DepartmentDto updateDepartment(Integer departmentId,DepartmentDto departmentDto);
	public Map<DepartmentDto, List<EmployeeDto>> getDepartmentById(Integer departmentId);
	public String softDeleteDepartmentById(Integer departmentId);
	public List<Department> findAll();
	public String getLocalDateTime();
	public DepartmentDto getOnlyDepartmentById(Integer departmentId);
}

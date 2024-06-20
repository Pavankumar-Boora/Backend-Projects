package com.learning.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.dto.ApiResponseDto;
import com.learning.dto.DepartmentDto;
import com.learning.dto.EmployeeDto;
import com.learning.entity.Department;
import com.learning.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private ApiResponseDto apiResponseDto;
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Department department = new Department(departmentDto);
		String localDateAndTime = getLocalDateTime();
		department.setCreationDateAndTime(localDateAndTime);
		department.setUpdationDateAndTime(localDateAndTime);
		departmentRepository.save(department);
		return new DepartmentDto(department);
	}

	@Override
	public DepartmentDto updateDepartment(Integer departmentId, DepartmentDto departmentDto) {
		DepartmentDto departmentById = getOnlyDepartmentDetails(departmentId);
		if (departmentDto.getDepartmentName() != null) {
			departmentById.setDepartmentName(departmentDto.getDepartmentName());
		}
		if (departmentDto.getUpdatedPerson() != null) {
			departmentById.setUpdatedPerson(departmentDto.getUpdatedPerson());
		}
		departmentById.setUpdationDateAndTime(getLocalDateTime());
		return new DepartmentDto(departmentRepository.save(new Department(departmentById)));
	}

	public DepartmentDto getOnlyDepartmentDetails(Integer departmentId) {
		
		return new DepartmentDto(departmentRepository.findById(departmentId).orElseThrow(
	            () -> new RuntimeException("Department not found")));
	}

	@Override
	public Map<DepartmentDto, List<EmployeeDto>> getDepartmentById(Integer departmentId) {
		List<EmployeeDto> employeeList = restTemplate.exchange(
				"http://localhost:8080/employee/getOneDepartmentEmployees/" + departmentId, HttpMethod.GET,
				new HttpEntity<>(new HttpHeaders()), new ParameterizedTypeReference<List<EmployeeDto>>() {
				}).getBody();
		Map<DepartmentDto, List<EmployeeDto>> listDeptEmployees=new HashMap<>();
		DepartmentDto departmentDto = new DepartmentDto(departmentRepository.findById(departmentId).orElseThrow(
	            () -> new RuntimeException("Department not found")));
		listDeptEmployees.put(departmentDto,employeeList);
		return listDeptEmployees;
		 
	}

	@Override
	public String softDeleteDepartmentById(Integer departmentId) {
		getDepartmentById(departmentId);
		departmentRepository.deleteById(departmentId);
		return "Department has been deleted successfully (Soft Deletion)";
	}

	@Override
	public DepartmentDto getOnlyDepartmentById(Integer departmentId) {
		return new DepartmentDto(departmentRepository.findById(departmentId).get());
	}
	
	@Override
	public List<Department> findAll() {
		List<Department> allDepartments = departmentRepository.findAll();
		return allDepartments;
	}
	
	public String getLocalDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return now.format(formatter);
	}

	

}

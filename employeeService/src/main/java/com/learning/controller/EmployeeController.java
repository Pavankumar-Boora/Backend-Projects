package com.learning.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.ApiResponseDto;
import com.learning.dto.EmployeeDto;
import com.learning.entity.Employee;
import com.learning.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok(employeeService.createEmployee(employeeDto));
	}
	@GetMapping("/getAllEmployees")
	public ResponseEntity<Map<Map<Integer, DepartmentDto>, Map<Integer, List<Employee>>>> getAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	@GetMapping("/{employeeId}")
	public ResponseEntity<ApiResponseDto> getEmployeeDetails(@PathVariable Integer employeeId){
		return ResponseEntity.ok(employeeService.getEmployeeDetails(employeeId));
	}
	
	@PatchMapping("/updateEmployee/{employeeId}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok(employeeService.updateEmployee(employeeId, employeeDto));
	}
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
		return ResponseEntity.ok(employeeService.softDeleteEmployeeById(employeeId));
	}
	@DeleteMapping("/deleteDepartmentEmployees/{departmentId}")
	public ResponseEntity<String> softDeleteDepartmentEmployees(@PathVariable Integer departmentId) {
		return ResponseEntity.ok(employeeService.softDeleteDepartmentEmployees(departmentId));
	}
	@GetMapping("/getOneDepartmentEmployees/{departmentId}")
	public ResponseEntity<List<EmployeeDto>> getOneDepartmentEmployees(@PathVariable Integer departmentId){
		return ResponseEntity.ok(employeeService.getOneDepartmentEmployees(departmentId));
	}
	@GetMapping("/findByEmployeeFirstNameAndEmployeeLirstName")
	public ResponseEntity<EmployeeDto> findByEmployeeFirstNameAndEmployeeLirstName(@RequestParam String employeeFirstName,@RequestParam String employeeLastName){
		return ResponseEntity.ok(employeeService.findByEmployeeFirstNameAndEmployeeLirstName(employeeFirstName, employeeLastName));
	}
	
}

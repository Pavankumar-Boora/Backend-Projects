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
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.DepartmentDto;
import com.learning.dto.EmployeeDto;
import com.learning.entity.Department;
import com.learning.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/createDepartment")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		return ResponseEntity.ok(departmentService.createDepartment(departmentDto));
	}
	
	@PatchMapping("/updateDepartment/{departmentId}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Integer departmentId,@RequestBody DepartmentDto departmentDto){
		return ResponseEntity.ok(departmentService.updateDepartment(departmentId,departmentDto));
	}
	@GetMapping("/{departmentId}")
	public ResponseEntity<Map<DepartmentDto, List<EmployeeDto>>> fetchDepartment(@PathVariable Integer departmentId){
		return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
	}
	@GetMapping("/getOnlyDepartment/{departmentId}")
	public ResponseEntity<DepartmentDto> fetchOnlyDepartment(@PathVariable Integer departmentId){
		return ResponseEntity.ok(departmentService.getOnlyDepartmentById(departmentId));
	}
	@GetMapping("/getAllDepartments")
	public ResponseEntity<List<Department>> fetchAll(){
		return ResponseEntity.ok(departmentService.findAll());
	}
	@DeleteMapping("/deleteDepartmentById/{departmentId}")
	public ResponseEntity<String> softDeletionOfDepartment(@PathVariable Integer departmentId){
		return ResponseEntity.ok(departmentService.softDeleteDepartmentById(departmentId));
	}
}

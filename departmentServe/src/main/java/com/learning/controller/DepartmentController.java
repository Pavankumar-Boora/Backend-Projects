package com.learning.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	public static final String DEPARTMENT_SERVICE = "department-service";
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/checksFilter")
	public ResponseEntity<String> checksFilter(HttpServletRequest request,HttpServletResponse response){
		 try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		return ResponseEntity.ok("X-Header : "+ request.getHeader("X-Header"));
	}
	@PostMapping("/createDepartment")
	public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
		logger.info("executing the createDepartment");
		return ResponseEntity.ok(departmentService.createDepartment(departmentDto));
	}
	
	@PatchMapping("/updateDepartment/{departmentId}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Integer departmentId,@RequestBody DepartmentDto departmentDto){
		return ResponseEntity.ok(departmentService.updateDepartment(departmentId,departmentDto));
	}
	@GetMapping("/{departmentId}")
	@CircuitBreaker(name = DEPARTMENT_SERVICE, fallbackMethod = "userServiceFallBack")
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
	
	public ResponseEntity<Map<DepartmentDto, List<EmployeeDto>>> userServiceFallBack(@PathVariable Integer departmentId, Exception userException) {
		 // Create default DepartmentDto
        DepartmentDto defaultDepartment = new DepartmentDto();
        defaultDepartment.setDepartmentId(-1);
        defaultDepartment.setDepartmentName("Default Department");

        // Create default EmployeeDto
        EmployeeDto defaultEmployee = new EmployeeDto();
        defaultEmployee.setEmployeeDepartmentId(-1);
        defaultEmployee.setEmployeeFirstName("Default Employee");
        defaultEmployee.setEmployeeDepartmentId(-1);

        // Create fallback response map
        Map<DepartmentDto, List<EmployeeDto>> fallbackResponse = Map.of(
            defaultDepartment, List.of(defaultEmployee)
        );

        logger.info("Fallback method executed for departmentId: {}. Returning default response.", departmentId);

        return ResponseEntity.ok(fallbackResponse);
	}
}

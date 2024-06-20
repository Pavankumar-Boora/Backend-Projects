package com.learning.entity;

import com.learning.dto.EmployeeDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	private Integer employeeId;
	private String employeeEmailId;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeecreationDateAndTime;
	private String employeeupdationDateAndTime;
	private String employeecreatedPerson;
	private String employeeupdatedPerson;
	private Boolean deleted =false;
	private Integer employeeDepartmentId;
	
	public Employee(EmployeeDto employeeDto) {
		super();
		this.employeeId = employeeDto.getEmployeeId();
		this.employeeEmailId = employeeDto.getEmployeeEmailId();
		this.employeeFirstName = employeeDto.getEmployeeFirstName();
		this.employeeLastName = employeeDto.getEmployeeLastName();
		this.employeecreationDateAndTime = employeeDto.getEmployeecreationDateAndTime();
		this.employeeupdationDateAndTime = employeeDto.getEmployeeupdationDateAndTime();
		this.employeecreatedPerson = employeeDto.getEmployeecreatedPerson();
		this.employeeupdatedPerson = employeeDto.getEmployeeupdatedPerson();
		this.deleted=deleted;
		this.employeeDepartmentId = employeeDto.getEmployeeDepartmentId();
	}
	
}

package com.learning.dto;

import com.learning.entity.Employee;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {
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
	
	

	public EmployeeDto(Employee employee) {
		super();
		this.employeeId = employee.getEmployeeId();
		this.employeeEmailId = employee.getEmployeeEmailId();
		this.employeeFirstName = employee.getEmployeeFirstName();
		this.employeeLastName = employee.getEmployeeLastName();
		this.employeecreationDateAndTime = employee.getEmployeecreationDateAndTime();
		this.employeeupdationDateAndTime = employee.getEmployeeupdationDateAndTime();
		this.employeecreatedPerson = employee.getEmployeecreatedPerson();
		this.employeeupdatedPerson = employee.getEmployeeupdatedPerson();
		this.deleted=deleted;
		this.employeeDepartmentId = employee.getEmployeeDepartmentId();
	}

}

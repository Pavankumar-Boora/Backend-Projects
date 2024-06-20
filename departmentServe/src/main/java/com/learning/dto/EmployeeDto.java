package com.learning.dto;

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
	private Boolean deleted = false;
	private Integer employeeDepartmentId;

}

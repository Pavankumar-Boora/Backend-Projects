package com.learning.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.learning.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class DepartmentDto {
	private Integer departmentId;
	private String departmentName;
	private String creationDateAndTime;
	private String updationDateAndTime;
	private String createdPerson;
	private String updatedPerson;
	private Boolean deleted=false;
	
	public DepartmentDto(Department department) {
		super();
		this.departmentId = department.getDepartmentId();
		this.departmentName = department.getDepartmentName();
		this.creationDateAndTime = department.getCreationDateAndTime();
		this.updationDateAndTime = department.getUpdationDateAndTime();
		this.createdPerson = department.getCreatedPerson();
		this.updatedPerson = department.getUpdatedPerson();
		this.deleted = deleted;
	}
}

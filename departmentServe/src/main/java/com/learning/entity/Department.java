package com.learning.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.learning.dto.DepartmentDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Department {
	@Id
	private Integer departmentId;
	private String departmentName;
	private String creationDateAndTime;
	private String updationDateAndTime;
	private String createdPerson;
	private String updatedPerson;
	private Boolean deleted=false;

	public Department(DepartmentDto departmentDto) {
		super();
		this.departmentId = departmentDto.getDepartmentId();
		this.departmentName = departmentDto.getDepartmentName();
		this.creationDateAndTime = departmentDto.getCreationDateAndTime();
		this.updationDateAndTime = departmentDto.getUpdationDateAndTime();
		this.createdPerson = departmentDto.getCreatedPerson();
		this.updatedPerson = departmentDto.getUpdatedPerson();
		this.deleted = deleted;
	}
	
	
	
}

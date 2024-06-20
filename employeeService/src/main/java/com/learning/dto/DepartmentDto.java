package com.learning.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class DepartmentDto {
	private Integer departmentId;
	private String departmentName;
	private String creationDateAndTime;
	private String updationDateAndTime;
	private String createdPerson;
	private String updatedPerson;
	private Boolean deleted=false;
	
}

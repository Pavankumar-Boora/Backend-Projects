package com.learning.api;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer{
	@Id
	private Integer id;
	private String name;
	private String address;
	private Long mobileNumber;
}


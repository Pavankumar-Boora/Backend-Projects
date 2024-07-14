package com.learning.api;

import com.learning.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Integer id;
	private String name;
	private Double price;
	private Integer customerId;
}

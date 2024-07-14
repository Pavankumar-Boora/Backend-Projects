package com.learning.api;

import com.learning.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponce {
	private Customer customer;
	private Product product;
}

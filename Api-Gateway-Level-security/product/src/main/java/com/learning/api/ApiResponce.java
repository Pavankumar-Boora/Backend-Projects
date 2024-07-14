package com.learning.api;

import com.learning.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponce {
	private Product product;
	private Customer customer;
}

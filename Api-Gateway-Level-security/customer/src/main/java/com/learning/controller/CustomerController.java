package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.api.ApiResponce;
import com.learning.entity.Customer;
import com.learning.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<ApiResponce> createcCustomer(@RequestBody ApiResponce apiResponce) {
		return ResponseEntity.ok(customerService.createcApiResponce(apiResponce));
	}
	@GetMapping("/fetchUserWithProducts/{customerId}")
	public ResponseEntity<ApiResponce> fetchCustomerWithProductsUsingId(@PathVariable Integer customerId) {
		return ResponseEntity.ok(customerService.fetchCustomerWithProductsUsingId(customerId));
	}
	@GetMapping("/fetchCustomer/{customerId}")
	public ResponseEntity<Customer> fetchCustomer(@PathVariable Integer customerId) {
		return ResponseEntity.ok(customerService.fetchCustomer(customerId));
	}
}

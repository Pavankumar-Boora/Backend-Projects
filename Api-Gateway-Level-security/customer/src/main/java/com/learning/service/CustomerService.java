package com.learning.service;

import com.learning.api.ApiResponce;
import com.learning.api.Product;
import com.learning.entity.Customer;

public interface CustomerService {
	public ApiResponce createcApiResponce(ApiResponce apiResponce);	
	public Customer createCustomer(Customer customer);	
	public Product createProduct(Product product);	
	public ApiResponce fetchCustomerWithProductsUsingId(Integer customerId);
	public Customer fetchCustomer(Integer customerId);
}

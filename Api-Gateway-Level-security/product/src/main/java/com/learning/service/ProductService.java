package com.learning.service;

import java.util.List;

import com.learning.api.ApiResponce;
import com.learning.entity.Product;

public interface ProductService {
	public Product create(Product product);

	public Product getProductById(Integer productId);

	public ApiResponce getProductAndCustomerDetailsUsingProdId(Integer productId);

	public List<Product> getProductByCustomerId(Integer customerId);
}

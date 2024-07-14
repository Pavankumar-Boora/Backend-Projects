package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.learning.api.ApiResponce;
import com.learning.api.Customer;
import com.learning.entity.Product;
import com.learning.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
//	
//	@Value("${customer.service.url}")
//	private String customerUrl;
	private RestClient restClient;
	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl() {
		restClient = RestClient.builder().baseUrl("http://localhost:8091/customer/").build();
	}

	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Integer productId) {
		return productRepository.findById(productId).get();
	}

	@Override
	public ApiResponce getProductAndCustomerDetailsUsingProdId(Integer productId) {
		Product product = getProductById(productId);
		Customer customer = restClient.get().uri("fetchCustomer/"+product.getCustomerId()).retrieve().body(Customer.class);
		return new ApiResponce(product, customer);
	}

	@Override
	public List<Product> getProductByCustomerId(Integer customerId) {
		return productRepository.findByCustomerId(customerId);
	}

}

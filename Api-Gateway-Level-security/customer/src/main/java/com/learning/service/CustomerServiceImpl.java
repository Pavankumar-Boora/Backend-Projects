package com.learning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.learning.api.ApiResponce;
import com.learning.api.Product;
import com.learning.entity.Customer;
import com.learning.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Value("${product.service.url}")
	private static String productUrl;
	
	private RestClient restClient;
	
	public CustomerServiceImpl() {
//		RestClient.create();
		restClient = RestClient.builder().baseUrl("http://localhost:8090/product/").build();
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public ApiResponce fetchCustomerWithProductsUsingId(Integer customerId) {
		Customer customer = fetchCustomer(customerId);
		Product product = restClient.get().uri("getProductByCustomerId/"+customerId).retrieve().body(Product.class);
		return new ApiResponce(customer, product);
	}

	@Override
	public ApiResponce createcApiResponce(ApiResponce apiResponce) {
		Customer customer = createCustomer(apiResponce.getCustomer());
		Product product = createProduct(apiResponce.getProduct());
		return new ApiResponce(customer,product);
	}

	@Override
	public Product createProduct(Product product) {
       return restClient.post().uri("createProduct").contentType(MediaType.APPLICATION_JSON).body(product).retrieve().body(Product.class);
	}

	@Override
	public Customer fetchCustomer(Integer customerId) {
		return customerRepository.findById(customerId).get();
	}

}

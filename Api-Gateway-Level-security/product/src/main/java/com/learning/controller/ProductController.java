package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.api.ApiResponce;
import com.learning.entity.Product;
import com.learning.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok(productService.create(product));
	}
	
	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<Product> fetchProductById(@PathVariable Integer productId){
		return ResponseEntity.ok(productService.getProductById(productId));
	}	
	
	@GetMapping("/getProductAndCustomerUsingProdId/{productId}")
	public ResponseEntity<ApiResponce> getProductAndCustomerDetailsUsingProdId(@PathVariable Integer productId){
		return ResponseEntity.ok(productService.getProductAndCustomerDetailsUsingProdId(productId));
	}
	
	@GetMapping("/getProductByCustomerId/{customerId}")
	public ResponseEntity<List<Product>> getProductByCustomerId(@PathVariable Integer customerId){
		return ResponseEntity.ok(productService.getProductByCustomerId(customerId));
	}
}

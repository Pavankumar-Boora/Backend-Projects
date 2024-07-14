package com.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByCustomerId(Integer customerId);

}

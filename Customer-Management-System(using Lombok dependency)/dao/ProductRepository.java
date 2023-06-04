package com.example.Customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Customer.entities.Product;

public interface ProductRepository extends  JpaRepository<Product, Integer> {
	public Product findById(int id);
}

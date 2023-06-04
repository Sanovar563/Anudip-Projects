package com.example.Customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findById(int id);
}

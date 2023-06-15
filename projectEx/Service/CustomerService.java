package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;

@Component
public interface CustomerService {

	public Customer createCustomer(CustomerDTO cdto);
	public Customer getCustomer(int id);
	public List<Customer> getAllCustomers();
	public String deleteCustomer(int id);
	public Customer updateCustomer(int id,CustomerDTO cdto);
	public String deleteAllCustomers();
}

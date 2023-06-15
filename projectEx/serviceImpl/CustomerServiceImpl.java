package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.CustomerService;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

// creating instance for Repository

	@Autowired
	CustomerRepository cr;
	
	// Crud Operations
	// Creating Customer	
	@Override
	public Customer createCustomer(CustomerDTO cdto) {
		Customer cust = Customer.builder()
				.customer_name(cdto.getCustomer_name()).customer_contact(cdto.getCustomer_contact())
				.customer_email(cdto.getCustomer_email()).customer_address(cdto.getCustomer_address())
				.pin(cdto.getPin()).build();
		return cr.save(cust);
	}
	
// To view customer details of particular customer
	@Override
	public Customer getCustomer(int id) {
		return cr.findById(id).get();
	}

// To view all customers details
	@Override
	public List<Customer> getAllCustomers() {
		return cr.findAll();
	}
	
// To delete  particular customer
	@Override
	public String deleteCustomer(int id) {
		cr.deleteById(id);
		return "Customer deleted successfully.";
	}
	
// To update customer details
	@Override
	public Customer updateCustomer(int id, CustomerDTO cdto) {
		Customer cust = cr.findById(id).get();
		
		Customer cust1 = Customer.builder()
				.customer_name(cdto.getCustomer_name()).customer_contact(cdto.getCustomer_contact())
				.customer_email(cdto.getCustomer_email()).customer_address(cdto.getCustomer_address())
				.pin(cdto.getPin()).build();
		
		cust.setCustomer_name(cust1.getCustomer_name());
		cust.setCustomer_contact(cust1.getCustomer_contact());
		cust.setCustomer_email(cust1.getCustomer_email());
		cust.setCustomer_address(cust1.getCustomer_address());
		cust.setPin(cust1.getPin());
		cr.save(cust1);
		return cr.save(cust1);
	}

// To delete all customer 
	@Override
	public String deleteAllCustomers() {
		cr.deleteAll();
		return "All Customers deleted successfully.";
	}

}

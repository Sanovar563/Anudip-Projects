package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Service.CustomerService;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;

@RestController
@CrossOrigin
public class CustomerController {

// creating instance for Customer Service

	@Autowired(required = true)
	CustomerService cs;

// Entering customer details throgh  ordercontroller
	@PostMapping("/customer")
	public  ResponseEntity<Customer> createCustomer(@RequestBody @Valid CustomerDTO cdto )
	{	 
	Customer cust=cs.createCustomer(cdto);
		if(cust!=null)
			return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);
		
	   return new ResponseEntity<Customer>(cust, HttpStatus.BAD_REQUEST);
	}
	
//	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id)
	{
		try {
			Customer cust=cs.getCustomer(id);
		if(cust!=null)
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		}catch(Exception e)
		{		
			e.printStackTrace();		}
		 return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomer()
	{
		try {
			List<Customer> clist=cs.getAllCustomers();
			if(clist!=null)
				return new ResponseEntity<List<Customer>>(clist, HttpStatus.OK);
			}catch(Exception e)
			{		
			       throw new CustomerNotFoundException("Customer not found");
			}
			 return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable("id") int id,@RequestBody @Valid CustomerDTO cdto)
	{
		return cs.updateCustomer(id, cdto);
	}
	
	
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable("id") int id)
	{
		return cs.deleteCustomer(id);
		
	}

	@DeleteMapping("/customers")
	public String deleteOrders()
	{
		return cs.deleteAllCustomers();		
	}
}

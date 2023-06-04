package com.example.Customer.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import com.example.Customer.dao.CustomerRepository;
import com.example.Customer.entities.Customer;


@RestController
public class CustomerService {

@Autowired
private CustomerRepository customerRepository;
//to get all customer list

	
public List<Customer> getAllCustomer()
{
	List<Customer> list=(List<Customer>)this.customerRepository.findAll();
	return list;
}
//to get books by ID
	public Customer getById(int id)
	{
		Customer customer=null;
		try {
			customer=this.customerRepository.findById(id);
			return customer;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return customer;
		}
	}
	
	//to add a new book to the list
		public Customer addCustomer(Customer b)
		{
			Customer result=this.customerRepository.save(b);
			return result;
		}

		//delete a book from the list based on ID
		public void deleteCustomer(int id) 
		{
			this.customerRepository.deleteById(id);
			
		}

		public void updateCustomer(Customer customer, int customerId) {
			//book.setBid(bookId);
			this.customerRepository.save(customer);
			
		}
//		public void updateProduct(Customer customer, int customerId) {
//			// TODO Auto-generated method stub
//			
//		}
//		public void deleteCustomer(int id) {
//			// TODO Auto-generated method stub
//			
//		}

}

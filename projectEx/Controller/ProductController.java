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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.exception.CustomerNotFoundException;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired(required = true)
	ProductService ps;

// Entering product details throgh  ordercontroller
	@PostMapping("/product")
	public  ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO pdto )
	{	 
		Product p =ps.createProduct(pdto);
		if(p!=null)
			return new ResponseEntity<Product>(p, HttpStatus.CREATED);
		
	   return new ResponseEntity<Product>(p, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id)
	{
		try {
			Product p= ps.getProduct(id);
		if(p!=null)
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		}catch(Exception e)
		{		
			e.printStackTrace();		}
		 return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts()
	{
		try {
			List<Product> plist=ps.getAllProducts();
			if(plist!=null)
				return new ResponseEntity<List<Product>>(plist, HttpStatus.OK);
			}catch(Exception e)
			{		
			       throw new CustomerNotFoundException("Customer not found");
			}
			 return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable("id") int id,@RequestBody @Valid ProductDTO pdto)
	{
		return ps.updateProduct(id, pdto);
	}
	
	
	
	@DeleteMapping("/product/{id}")
	public String deleteCustomer(@PathVariable("id") int id)
	{
		return ps.deleteProducts(id);
		
	}

	@DeleteMapping("/products")
	public String deleteProducts()
	{
		return ps.deleteAllProducts();		
	}
	
}

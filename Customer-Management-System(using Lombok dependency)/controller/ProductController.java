package com.example.Customer.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.Customer.entities.Product;
import com.example.Customer.service.ProductService;

@RestController
public class ProductController {
@Autowired
private ProductService productservice;
@GetMapping("/product")
public ResponseEntity<List<Product>> getProducts()
{
	List<Product> list=productservice.getAllProduct();
	if(list.size()<=0)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.of(Optional.of(list));
}
@GetMapping("/product/{id}")
public ResponseEntity<Product> getProducts(@PathVariable("id") int id)
{
	Product product=productservice.getById(id);
	if(product==null)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.of(Optional.of(product));
}
@PostMapping("/products")
public ResponseEntity<Product> addProduct(@RequestBody Product product)
{
	Product b=null;
	try {
			b=this.productservice.addProduct(product);
			System.out.println(b);
			return ResponseEntity.of(Optional.of(b));
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
}

@DeleteMapping("/products/{productid}")
public ResponseEntity<Void> deleteProduct(@PathVariable("productid") int id)
{
	try {
			this.productservice.deleteProduct(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
}
@PutMapping("/products/{productid}")
public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable ("productid") int productId)
{
	try {
		this.productservice.updateProduct(product, productId);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	catch(Exception e)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}

}

package com.example.Customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer.dao.ProductRepository;
import com.example.Customer.entities.Product;

@RestController
public class ProductService {
@Autowired
private ProductRepository productRepository;


//to get all product list
public List<Product> getAllProduct()
{
	List<Product> list=(List<Product>)this.productRepository.findAll();
	return list;
}


//to get books by ID
	public Product getById(int id)
	{
		Product product=null;
		try {
			product=this.productRepository.findById(id);
			return product;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return product;
		}
	}
	//to add a new book to the list
	public Product addProduct(Product b)
	{
		Product result=this.productRepository.save(b);
		return result;
	}

	//delete a book from the list based on ID
	public void deleteProduct(int id) 
	{
		this.productRepository.deleteById(id);
		
	}

	public void updateProduct(Product product, int productId) {
		//product.setPid(productId);
		this.productRepository.save(product);
		
	}




}

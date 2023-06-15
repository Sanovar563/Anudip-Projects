package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

// creating instance for Repository

	@Autowired
    ProductRepository pr;

	// Crud Operations
		// Creating Product
	@Override
	public Product createProduct(ProductDTO pdto) {
		Product p = Product.builder()
				.product_name(pdto.getProduct_name()).product_quantity(pdto.getProduct_quantity()).product_price(pdto.getProduct_price()).build();
		return pr.save(p);
	}

// To view Product details of particular Product

	@Override
	public Product getProduct(int id) {
		return pr.findById(id).get();

	}
	
// To view all Product details
	
	@Override
	public List<Product> getAllProducts() {
		return pr.findAll();
	}
	
// To delete  particular Product
	
	@Override
	public String deleteProducts(int id) {
		pr.deleteById(id);
		return "Product deleted successfully.";
	}

// To update product details	
	@Override
	public Product updateProduct(int id, ProductDTO pdto) {
Product p = pr.findById(id).get();
		
		Product p1 = Product.builder()
				.product_name(pdto.getProduct_name()).product_quantity(pdto.getProduct_quantity()).product_price(pdto.getProduct_price()).build();
		
		p.setProduct_name(p1.getProduct_name());
		p.setProduct_quantity(p1.getProduct_quantity());
		pr.save(p1);
		return pr.save(p1);
	}

// To delete all product
	@Override
	public String deleteAllProducts() {
		pr.deleteAll();
		return "All Products deleted successfully.";
	}

	
	

}

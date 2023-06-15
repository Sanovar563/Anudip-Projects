package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;


@Component
public interface ProductService {

	public Product createProduct(ProductDTO pdto);
	public Product getProduct(int id);
	public List<Product> getAllProducts();
	public String deleteProducts(int id);
	public Product updateProduct(int id,ProductDTO pdto);
	public String deleteAllProducts();
}

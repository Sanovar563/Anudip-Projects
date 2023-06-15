package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Repository.OrderRepository;
import com.example.demo.Service.OrderService;
import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.Order;

@Service
public class OrderServiceimpl implements OrderService {

// creating instance for Repository
	@Autowired
	OrderRepository or;

	// Crude Operations
		// Creating Order
	@Override
	public Order createOrder(OrderDTO ort) {
		Order o = Order.builder()
				.order_name(ort.getOrder_name()).shipping_charge(ort.getShipping_charge())
				.status(ort.getStatus()).order_date(ort.getOrder_date()).total_price(ort.getTotal_price())
				.customer(ort.getCustomer()).product(ort.getProduct()).build();
		return or.save(o);
	}
	
// To view order details of particular order
	@Override
	public Order getorder(int id) {
		return or.findById(id).get();
	}

// To view all orders details
	@Override
	public List<Order> getAllOrders() {
		return or.findAll();
	}

// To delete particular order 	
	@Override
	public String deleteOrder(int id) {
		or.deleteById(id);
		return "Order deleted successfully.";
	}

// To update order,customer,product details	
	@Override
	public Order updateOrder(int id, OrderDTO ort) {
		Order o = or.findById(id).get();
		
		Order o1 = Order.builder()
				.order_name(ort.getOrder_name()).shipping_charge(ort.getShipping_charge())
				.status(ort.getStatus()).order_date(ort.getOrder_date()).total_price(ort.getTotal_price())
				.customer(ort.getCustomer()).product(ort.getProduct()).build();
		
		o.setOrder_name(o1.getOrder_name());
		o.setShipping_charge(o1.getShipping_charge());
		o.setStatus(o1.getStatus());
		o.setOrder_date(o1.getOrder_date());
		o.setCustomer(o1.getCustomer());
		o.setProduct(o1.getProduct());
		
//		or.save(o1);
		
		return or.save(o1);
	}

// To delete all order	
	@Override
	public String deleteAllOrders() {
		or.deleteAll();
		return "All orders deleted successfully.";
	}

	
}

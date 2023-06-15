package com.example.demo.dto;



import java.sql.Date;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// importing all the annotation from lombok for getter,setter and constructor
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class OrderDTO {
	
// copy of instance variable created 
	
// taking validation on entity variable using @valid Annotation
	@NotBlank(message = "Order_Name can't be empty")
	@NotNull(message = "Order_Name can't be  null")
	@Size(min = 3, max = 20, message = "Order_Name must be within 3-20 characters")
	String order_name;
	
	@Digits(fraction = 0, integer = 5)
	@DecimalMax(value = "1000.00")
	@DecimalMin(value = "0.00")
	int shipping_charge;
	
	@NotBlank(message = "Status can't be empty")
	@NotNull(message = "Status  can't be  null")
	String status;
	
	@Digits(fraction = 0, integer = 7)
	@DecimalMax(value = "5000000.00")
	@DecimalMin(value = "0.00")
	private int total_price;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private Date order_date;
	
	private Customer customer;
	
	private Product product;
	
	
}
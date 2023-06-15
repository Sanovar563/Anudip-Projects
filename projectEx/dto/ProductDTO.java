package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// importing all the annotation from lombok for getter,setter and constructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO implements Serializable{
// copy of instance variable created 
	
// taking validation on entity variable using @valid Annotation
	@NotBlank(message = "Product_Name can't be empty")
	@NotNull(message = "Product_Name can't be  null")
	private String product_name;
	

	@Digits(fraction = 0, integer = 5)
	@DecimalMax(value = "1000.00")
	@DecimalMin(value = "0.00")
	private int product_quantity;
	
	@Digits(fraction = 0, integer = 7)
	@DecimalMax(value = "1000000.00")
	@DecimalMin(value = "0.00")
	private int product_price;
}

package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
// we use a builder to create instances of our class.
@Builder
@Entity
// creates table in databas with name PRODUCT_DETAILS
@Table(name = "PRODUCTS")
public class Product{
	
// instance variable for product entity
	
// Product_id is auto generated
	@Id
	@GeneratedValue
	private int product_id;
// creating columns for table Product	
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

package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// importing all the annotation from Lombok for getter,setter and constructor
@AllArgsConstructor
@NoArgsConstructor
@Data
//we use a builder to create instances of our class.
@Builder
@Entity
// creates table in database with name CUSTOMER_DETAILS
@Table(name = "CUSTOMERS")
public class Customer {
	
// instance variable for customer entity
	
// customer_id is auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customer_id;

// creating columns for table customer

	@NotBlank(message = "Customer Name can't be empty")
	@NotNull(message = "Customer Name  can't be  null")	
	@Size(min = 3, max = 20, message = "Customer_Name must be within 3-20 characters")
	private String customer_name ;
	@NotNull(message = "Contact No can not be null")
//	Start from +91 or 91 OR Contact Number starting from 7,8 or 9.
	@Pattern(regexp = "^((\\+91)?|91)?[789][0-9]{9}", message = " Invalid Contact Number it should start from 7,8 or 9 and must haev country code +91 or 91 ")
	private String customer_contact;
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z]+\\.(com|in)",message = "Enter valid Email Address")
	private String customer_email;
	@NotBlank(message = "Customer Address can't be empty")
	@NotNull(message = "Customer Address  can't be  null")
	private String customer_address;
	@NotNull(message = "pin can't be  null")
	private int pin;
	
	
}

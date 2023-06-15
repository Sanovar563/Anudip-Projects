package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// importing all the annotation from lombok for getter,setter and constructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDTO {
	
// copy of instance variable created

// taking validation on entity variable using @valid Annotation
	
	@NotBlank(message = "Customer Name can't be empty")
	@NotNull(message = "Customer Name  can't be  null")	
	@Size(min = 3, max = 20, message = "Customer_Name must be within 3-20 characters")
	private String customer_name ;
	
	@NotNull(message = "Contact No can not be null")
//	Start from +91 or 91 OR Contact Number starting from 7,8 or 9.
	@Pattern(regexp = "^((\\+91)?|91)?[789][0-9]{9}", message = " Invalid phone number /n Contact Number should be start from +91 or 91 ")
	private String customer_contact;
	
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z]+\\.(com|in)",message = "Enter valid Email Address")
	private String customer_email;
	
	@NotBlank(message = "Customer Address can't be empty")
	@NotNull(message = "Customer Address  can't be  null")
	private String customer_address;
	
//	@Size(min = 5, max = 20, message = "Please enter valid pin code or postal pin")
	@NotNull(message = "pin can't be  null")
	private int pin;

}

package com.example.Customer.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.Data;

@Entity
@Data
@Table(name="Product_Table")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Product_Id")
	private int pid;
	
	@Column(name="Product_Name")
	private String name;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="Product_Price")
    private int price;
	@OneToOne(mappedBy="product")
	@JsonBackReference
	private Customer customer;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JsonManagedReference
//	private Customer customer;
	
}

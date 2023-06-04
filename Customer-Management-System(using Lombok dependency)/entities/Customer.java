package com.example.Customer.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="Customer_Id")
	private int cid;
	
	@Column(name="Customer_Name")
	private String name;
	
	@Column(name="Mobile_no.")
	private int number;
	
	
	
//	@OneToOne(mappedBy="customer")
//	@JsonBackReference
//	private Product product;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Product product;
}

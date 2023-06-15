package com.example.demo.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;
//importing all the annotation from lombok for getter,setter and constructor
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
// we use a builder to create instances of our class.
@Builder
@Entity
// creates table in database with name ORDER_DETAILS
@Table(name = "ORDERS")
public class Order {
// instance variable for customer entity
	
// order_id is auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;
	
	private String order_name;
	
	private int shipping_charge;
	
	private String status;
	
	private Date order_date;
	
	private int total_price;
	
// this connect with Customer entity using one to one mapping
// relationship
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

// this connect with Product entity using one to many mapping
// relationship	
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	
}

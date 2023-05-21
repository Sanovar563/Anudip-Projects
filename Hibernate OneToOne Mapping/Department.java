package com.hibernateone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Department {
	@Id
	private int did;
	private String dname;
	
	@OneToOne
	private Employee emp;
	
	
	//getter setter method
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setEmp(Employee emp) {
		
		this.emp=emp;
	}
	
}

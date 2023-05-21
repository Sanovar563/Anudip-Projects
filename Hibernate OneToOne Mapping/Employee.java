package com.hibernateone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
@Id
private int eid;
private String ename;


@OneToOne
	private Department dept;

//getter setter method
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
	public void setDept(Department dept) {
		
		this.dept=dept;
	}
}

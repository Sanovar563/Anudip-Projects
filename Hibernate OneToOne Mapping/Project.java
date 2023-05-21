package com.hibernateone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Project {
	@Id
	private int pid;
	
	private String pname;
	
	private String Pdescription;
	
	@OneToOne
	private Employee emp;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return Pdescription;
	}
	public void setPdescription(String pdescription) {
		Pdescription = pdescription;
	}
	public void setEmp(Employee emp) {
	
		this.emp=emp;
	}

}

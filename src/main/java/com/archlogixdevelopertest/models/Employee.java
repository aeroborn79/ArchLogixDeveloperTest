package com.archlogixdevelopertest.models;

import java.util.ArrayList;

public class Employee {
	
	int id;
	String email;
	String fname;
	String lname;
	ArrayList<WorkDetail> work;
	
	public Employee(String email) {
		
		this.email = email;
		
	}
	
	public Employee() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public ArrayList<WorkDetail> getWork() {
		return work;
	}
	
	public void setWork(ArrayList<WorkDetail> work) {
		this.work = work;
	}

}

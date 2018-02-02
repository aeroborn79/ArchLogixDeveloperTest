package com.archlogixdevelopertest.models;

public class WorkDetail {
	
	String date;
	int hours;
	
	public WorkDetail(String date, int hours) {
		
		this.date = date;
		this.hours = hours;
		
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}

}

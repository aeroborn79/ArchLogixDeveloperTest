package com.archlogixdevelopertest.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.archlogixdevelopertest.models.Employee;
import com.archlogixdevelopertest.models.WorkDetail;

public class FileProcessor {
	
	public Employee fileProcessor(String dateRange) {
	
		String csvFile = System.getProperty("user.home") + "\\Downloads\\Hours " + dateRange + ".csv";
		String line = "";
	    final String DELIMTER = ",";
	    Employee employee = new Employee();
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {	
	        while ((line = br.readLine()) != null) {	
	            String[] work = line.split(DELIMTER);
	            employee.setEmail(work[0]);
	            ArrayList<WorkDetail> workDetails = new ArrayList<WorkDetail>();
	            
	            for(int i = 1; i < work.length; i++) {
	            	int hours = Integer.parseInt(work[i]);
	            	String date;
	            	if(i == 1) {
	            		date = "2017-07-24";
	            	}
	            	else if(i == 2) {
	            		date = "2017-07-25";
	            	}
	            	else if(i == 3) {
	            		date = "2017-07-26";
	            	}
	            	else if(i == 4) {
	            		date = "2017-07-27";
	            	}
	            	else date = "2017-07-28";
	            	
	            	WorkDetail workDetail = new WorkDetail(date, hours);
	            	workDetails.add(workDetail);
	            }
	
	            employee.setWork(workDetails);
	
	        }
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return employee;
	
	}
}

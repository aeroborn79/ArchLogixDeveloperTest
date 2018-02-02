package com.archlogixdevelopertest.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.archlogixdevelopertest.models.Employee;
import com.archlogixdevelopertest.models.WorkDetail;

public class FileProcessor {
	
	public static Employee fileProcessor(String path) {
		String csvFile = path;
		String line = "";
	    final String DELIMTER = ",";
	    Employee employee = new Employee();
	    String startDate = PathUtils.getStartDate(path);
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {	
	        while ((line = br.readLine()) != null) {	
	            String[] work = line.split(DELIMTER);
	            employee.setEmail(work[0]);
	            ArrayList<WorkDetail> workDetails = new ArrayList<WorkDetail>();
	            
	            for(int i = 1; i < work.length; i++) {
	            	int hours = Integer.parseInt(work[i]);
	            	String date = PathUtils.dateParser(startDate, "year") + "-"
	            			+ PathUtils.dateParser(startDate, "month") + "-"
	            			+ String.valueOf((Integer.parseInt(PathUtils.dateParser(startDate, "day")) + (i - 1)));
	            	WorkDetail workDetail = new WorkDetail(date, hours);
	            	workDetails.add(workDetail);
	            }
	            employee.setWork(workDetails);
	            
	            /*
	             * Left off here. At step #4. Make api call to complete employee parameters
	             */
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return employee;
	}
	
}

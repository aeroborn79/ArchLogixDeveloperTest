package com.archlogixdevelopertest.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.archlogixdevelopertest.models.Employee;
import com.archlogixdevelopertest.models.WorkDetail;
import com.google.gson.Gson;

public class FileProcessor {
	
	public static void fileProcessor(String path) {
		String csvFile = path;
		String line = "";
	    final String DELIMTER = ",";
	    Employee employee = new Employee();
	    String startDate = PathUtils.getStartDate(path);
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {	
	        int count = 0;
	    	while ((line = br.readLine()) != null) {	
	            if (count == 0) {
	            	count++;
	            }
	            else if(count > 0) {
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
		            
		            // Make api call to complete employee parameters
		            String response = GetController.getEmployeeData(employee.getEmail());
		            System.out.println(response);
		            Gson gson = new Gson();
		            Employee temp = gson.fromJson(response, Employee.class);
		            System.out.println(temp.getFname() + " " + temp.getLname());
		            employee.setId(temp.getId());
		            temp = null;
		            PostController.logHours(employee.getId(), employee.getWork());
		            count++;
	            }
	        }
	        GetController.getEmployeeHours();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}

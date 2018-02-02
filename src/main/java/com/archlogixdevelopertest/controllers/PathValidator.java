package com.archlogixdevelopertest.controllers;

public class PathValidator {
	
	public static String pathConverter(String path) {
		
		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			
			path = path.replace('/', '\\');
			
		}
		
		return path;
		
	}
	
	public String pathParser(String path) {
		
		String dateRange = path.substring(path.lastIndexOf(" "), path.lastIndexOf("."));
		
		return dateRange;
		
	}

}
